package com.zjuqsc.qscdap.controller;


import com.zjuqsc.qscdap.model.Order;
import com.zjuqsc.qscdap.service.OrderService;
import com.zjuqsc.qscdap.util.TimeUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;


@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order/new",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Post an order")
    @ResponseBody
    public HashMap<String, Object> newOrder(
            @ApiParam(required = true, value = "User Id") @RequestParam(required = true) String userId,
            @ApiParam(required = true, value = "Express station") @RequestParam(required = true) String expressStation,
            @ApiParam(required = true, value = "Express company") @RequestParam(required = true) String expressCompany,
            @ApiParam(required = true, value = "Shelf number") @RequestParam(required = true) String shelfNumber,
            @ApiParam(required = true, value = "Days to Expire") @RequestParam(required = true) int daysToExpire,
            @ApiParam(required = false, value = "Tracking number") @RequestParam(required = false) String trackingNumber,
            @ApiParam(required = false, value = "Remarks") @RequestParam(required = false) String remarks
    ) {
        Date now = new Date();
        Order order = new Order();

        order.setId(orderService.generateOrderId());
        order.setCreateTime(now);
        order.setIsExpired(false);
        order.setIsFinished(false);
        order.setUserId(userId);
        order.setExpressStation(expressStation);
        order.setExpressCompany(expressCompany);
        order.setShelfNumber(shelfNumber);
        order.setExpireTime(TimeUtils.addDays(now, daysToExpire));
        order.setTrackingNumber(trackingNumber);
        order.setRemarks(remarks);

        int code = this.orderService.insertOrder(order);
        String message = (code > 0) ? "insert success" : "insert failed";

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("message", message);
        map.put("data", order);

        return map;
    }

    @RequestMapping(value = "/order/delete",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Delete an order")
    @ResponseBody
    public HashMap<String, Object> deleteOrder(
            @ApiParam(required = true, value = "Order Id") @RequestParam(required = true) String orderId
    ) {
        int code = this.orderService.deleteOrder(orderId);
        String message = (code > 0) ? "delete success" : "delete failed";

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("message", message);
        map.put("data", orderId);

        return map;
    }

    @RequestMapping(value = "/order/update",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Update an order")
    @ResponseBody
    public HashMap<String, Object> updateOrder(
            @ApiParam(required = true, value = "Order Id") @RequestParam(required = true) String orderId,
            @ApiParam(required = true, value = "Express station") @RequestParam(required = true) String expressStation,
            @ApiParam(required = true, value = "Express company") @RequestParam(required = true) String expressCompany,
            @ApiParam(required = true, value = "Shelf number") @RequestParam(required = true) String shelfNumber,
            @ApiParam(required = true, value = "Days to Expire") @RequestParam(required = true) int daysToExpire,
            @ApiParam(required = false, value = "Tracking number") @RequestParam(required = false) String trackingNumber,
            @ApiParam(required = false, value = "Remarks") @RequestParam(required = false) String remarks
    ) {
        int updatedField =
                this.orderService.setOrderExpressStation(orderId, expressStation) +
                this.orderService.setOrderExpressCompany(orderId, expressCompany) +
                this.orderService.setOrderShelfNumber(orderId, shelfNumber) +
                this.orderService.setOrderExpireTime(orderId, daysToExpire) +
                this.orderService.setOrderTrackingNumber(orderId, trackingNumber) +
                this.orderService.setOrderRemarks(orderId, remarks) +
                this.orderService.setOrderUpdateTime(orderId);
        Order order = this.orderService.getOrder(orderId);

        String message = (updatedField > 0) ? String.format("updated %d fields", updatedField) : "update failed";

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("code", updatedField);
        map.put("message", message);
        map.put("data", order);

        return map;
    }

}
