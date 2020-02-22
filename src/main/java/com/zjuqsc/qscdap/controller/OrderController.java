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
import java.util.List;


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

    @RequestMapping(value = "/order/getAll",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Get all order")
    @ResponseBody
    public HashMap<String, Object> getAllOrder() {
        List<Order> activeOrder = this.orderService.getOrderByStatus(false, false);
        List<Order> finishedOrder = this.orderService.getOrderByStatus(false, true);
        List<Order> expiredOrder = this.orderService.getOrderByStatus(true, false);

        HashMap<String, Object> orderMap = new HashMap<String, Object>();
        HashMap<String, Object> map = new HashMap<String, Object>();

        orderMap.put("activeOrder", activeOrder);
        orderMap.put("finishedOrder", finishedOrder);
        orderMap.put("expiredOrder", expiredOrder);

        map.put("code", 1);
        map.put("message", "success");
        map.put("data", orderMap);

        return map;
    }

    @RequestMapping(value = "/order",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Get order")
    @ResponseBody
    public HashMap<String, Object> getOrder(
            @ApiParam(required = true, value = "Order Id") @RequestParam(required = true) String orderId
    ) {
        Order order = this.orderService.getOrder(orderId);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("code", 1);
        map.put("message", "success");
        map.put("data", order);

        return map;
    }

    @RequestMapping(value = "/order/user",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Get user's order")
    @ResponseBody
    public HashMap<String, Object> getOrderByUser(
            @ApiParam(required = true, value = "User Id") @RequestParam(required = true) String userId
    ) {
        // List<Order> userOrder = this.orderService.getOrderByUserId(userId);

        List<Order> userActiveOrder = this.orderService.getOrderByUserIdAndStatus(userId, false, false);
        List<Order> userFinishedOrder = this.orderService.getOrderByUserIdAndStatus(userId,false, true);
        List<Order> userExpiredOrder = this.orderService.getOrderByUserIdAndStatus(userId, true, false);

        HashMap<String, Object> userOrderMap = new HashMap<String, Object>();
        HashMap<String, Object> map = new HashMap<String, Object>();

        userOrderMap.put("activeOrder", userActiveOrder);
        userOrderMap.put("finishedOrder", userFinishedOrder);
        userOrderMap.put("expiredOrder", userExpiredOrder);

        map.put("code", 1);
        map.put("message", "success");
        map.put("data", userOrderMap);

        return map;
    }

    @RequestMapping(value = "/order/take",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Take order")
    @ResponseBody
    public HashMap<String, Object> takeOrder(
            @ApiParam(required = true, value = "User Id") @RequestParam(required = true) String userId,
            @ApiParam(required = true, value = "Order Id") @RequestParam(required = true) String orderId
    ) {
        int code;
        String message;
        Order order = this.orderService.getOrder(orderId);
        // User user = this.userService.getUser(userId);
        if (order.getUserId().equals(userId)) {
            code = 0;
            message = "not permitted";
        }
        else {
            code = this.orderService.setOrderOrderTakerId(orderId, userId);
            message = (code > 0) ? "success" : "failed";
            order = this.orderService.getOrder(orderId);
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("message", message);
        map.put("data", order);

        return map;
    }

    @RequestMapping(value = "/order/finish",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Finish order")
    @ResponseBody
    public HashMap<String, Object> finishOrder(
            @ApiParam(required = true, value = "User Id") @RequestParam(required = true) String userId,
            @ApiParam(required = true, value = "Order Id") @RequestParam(required = true) String orderId
    ) {
        int code;
        String message;
        Order order = this.orderService.getOrder(orderId);
        if (!order.getUserId().equals(userId) &&
                (order.getOrderTakerId() == null || !order.getOrderTakerId().equals(userId))) {
            code = 0;
            message = "not permitted";
        }
        else{
            code = this.orderService.setOrderIsFinished(orderId, true);
            message = (code > 0) ? "success" : "failed";
            order = this.orderService.getOrder(orderId);
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("message", message);
        map.put("data", order);

        return map;
    }

    @RequestMapping(value = "/order/confirm",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "confirm order taker")
    @ResponseBody
    public HashMap<String, Object> confirmOrderTaker(
            @ApiParam(required = true, value = "User Id") @RequestParam(required = true) String userId,
            @ApiParam(required = true, value = "Order Id") @RequestParam(required = true) String orderId
    ) {
        int code;
        String message;
        Order order = this.orderService.getOrder(orderId);
        if (!order.getUserId().equals(userId) || order.getOrderTakerId() == null){
            code = 0;
            message = "not permitted";
        }
        else {
            code = this.orderService.setOrderIsConfirmed(orderId, true);
            message = (code > 0) ? "success" : "failed";
            order = this.orderService.getOrder(orderId);
        }
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("message", message);
        map.put("data", order);

        return map;
    }

}
