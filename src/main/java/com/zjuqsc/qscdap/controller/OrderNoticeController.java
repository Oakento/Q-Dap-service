package com.zjuqsc.qscdap.controller;

import com.zjuqsc.qscdap.model.OrderNotice;
import com.zjuqsc.qscdap.service.OrderNoticeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class OrderNoticeController {

    @Autowired
    OrderNoticeService orderNoticeService;

    @RequestMapping(value = "/notice/getListByUser",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Get notice list by user")
    @ResponseBody
    public HashMap<String, Object> getOrderNoticeList(
            @ApiParam(required = true, value = "UserId") @RequestParam(required = true) String userId
    ) {
        List<OrderNotice> listOrderNotice = this.orderNoticeService.getOrderNoticeByUserId(userId);

        HashMap<String, Object> map = new HashMap<>();

        map.put("code", 1);
        map.put("message", "success");
        map.put("data", listOrderNotice);

        return map;
    }

    @RequestMapping(value = "/notice/getByNoticeId",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Get notice by order notice id")
    @ResponseBody
    public HashMap<String, Object> getOrderNotice(
            @ApiParam(required = true, value = "orderNoticeId") @RequestParam(required = true) String orderNoticeId
    ) {
        OrderNotice OrderNotice = this.orderNoticeService.getOrderNotice(orderNoticeId);

        HashMap<String, Object> map = new HashMap<>();

        map.put("code", 1);
        map.put("message", "success");
        map.put("data", OrderNotice);

        return map;
    }
    
}
