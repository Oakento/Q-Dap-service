package com.zjuqsc.qscdap.controller;


import com.zjuqsc.qscdap.model.Order;
import com.zjuqsc.qscdap.service.OrderService;
import com.zjuqsc.qscdap.util.SnowFlake;
import com.zjuqsc.qscdap.util.TimeUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order/new",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Post an order")
    public ResponseEntity<String> newOrder(
            @ApiParam(required = true, value = "Express station") @RequestParam(required = true) String expressStation,
            @ApiParam(required = true, value = "Express company") @RequestParam(required = true) String expressCompany,
            @ApiParam(required = true, value = "Shelf number") @RequestParam(required = true) String shelfNumber,
            @ApiParam(required = true, value = "Days to Expire") @RequestParam(required = true) int daysToExpire,
            @ApiParam(required = false, value = "Tracking number") @RequestParam(required = false) String trackingNumber,
            @ApiParam(required = false, value = "Remarks") @RequestParam(required = false) String remarks
    ) {
        Date now = new Date();
        Order order = new Order();
        order.setId(Long.toString(new SnowFlake(0, 0).nextId()));
        order.setCreateTime(now);
        order.setIsExpired(false);
        order.setIsFinished(false);
        order.setExpressStation(expressStation);
        order.setExpressCompany(expressCompany);
        order.setShelfNumber(shelfNumber);
        order.setExpireTime(TimeUtils.addDays(now, daysToExpire));
        order.setTrackingNumber(trackingNumber);
        order.setRemarks(remarks);

        OrderService orderService = new OrderService();
        int orderStatus = orderService.insertOrder(order);

        return new ResponseEntity<String>(Integer.toString(orderStatus), HttpStatus.OK);

    }
}
