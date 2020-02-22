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
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
            @ApiParam(required = true, value = "Days to Expire") @RequestParam(required = true) String daysToExpire,
            @ApiParam(required = false, value = "Tracking number") @RequestParam(required = false) String trackingNumber,
            @ApiParam(required = false, value = "Remarks") @RequestParam(required = false) String remarks
    ) {
        Date now = new Date();
        Order order = new Order();
        HashMap<String, Object> map = new HashMap<>();

        Pattern pattern = Pattern.compile("^[1-9]d*$");
        Matcher matcher = pattern.matcher(daysToExpire);
        if (!matcher.find()) {
            map.put("code", 0);
            map.put("message", "Days Input invalid");
            return map;
        }
        order.setId(orderService.generateOrderId());
        order.setCreateTime(now);
        order.setIsExpired(false);
        order.setIsFinished(false);
        order.setUserId(userId);
        order.setExpressStation(expressStation);
        order.setExpressCompany(expressCompany);
        order.setShelfNumber(shelfNumber);
        order.setExpireTime(TimeUtils.addDays(now, Integer.parseInt(daysToExpire)));
        order.setTrackingNumber(trackingNumber);
        order.setRemarks(remarks);

        int code = this.orderService.insertOrder(order);
        String message = (code > 0) ? "insert success" : "insert failed";

        map.put("code", code);
        map.put("message", message);
        map.put("data", order);

        return map;
    }

    @RequestMapping(value = "/order/delete",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Delete an order")
    @ResponseBody
    public HashMap<String, Object> deleteOrder(
            @ApiParam(required = true, value = "Order Id") @RequestParam(required = true) String orderId,
            @ApiParam(required = true, value = "User Id") @RequestParam(required = true) String userId
    ) {
        HashMap<String, Object> map = new HashMap<>();
        Order order = this.orderService.getOrder(orderId);
        // if (this.userService.getUser(userId) == null ) {
        //     map.put("code", 0);
        //     map.put("message", "User does not exist");
        //     return map;
        // }
        if (order == null) {
            map.put("code", 0);
            map.put("message", "Order does not exist");
            return map;
        }
        if (order.getUserId() == null) {
            map.put("code", 0);
            map.put("message", "Unknown error");
            return map;
        }
        if (!order.getUserId().equals(userId)) {
            map.put("code", 0);
            map.put("message", "Not permitted");
            return map;
        }
        int code = this.orderService.deleteOrder(orderId);
        String message = (code > 0) ? "delete success" : "delete failed";

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
            @ApiParam(required = false, value = "Express station") @RequestParam(required = false) String expressStation,
            @ApiParam(required = false, value = "Express company") @RequestParam(required = false) String expressCompany,
            @ApiParam(required = false, value = "Shelf number") @RequestParam(required = false) String shelfNumber,
            @ApiParam(required = false, value = "Days to Expire") @RequestParam(required = false) String daysToExpire,
            @ApiParam(required = false, value = "Tracking number") @RequestParam(required = false) String trackingNumber,
            @ApiParam(required = false, value = "Remarks") @RequestParam(required = false) String remarks
    ) {
        HashMap<String, Object> map = new HashMap<>();
        Order originOrder = this.orderService.getOrder(orderId);
        if (originOrder == null) {
            map.put("code", 0);
            map.put("message", "Order does not exist");
            return map;
        }
        boolean updateFlag = false;
        Date now = new Date();
        Order order = new Order();
        HashMap<String, Object> updateMap = new HashMap<>();
        order.setId(orderId);
        if (expressStation != null) {
            order.setExpressStation(expressStation);
            order.setUpdateTime(now);
            updateMap.put("expressStation", expressStation);
            updateFlag = true;
        }
        if (expressCompany != null) {
            order.setExpressCompany(expressCompany);
            order.setUpdateTime(now);
            updateMap.put("expressCompany", expressCompany);
            updateFlag = true;
        }
        if (shelfNumber != null) {
            order.setShelfNumber(shelfNumber);
            order.setUpdateTime(now);
            updateMap.put("shelfNumber", shelfNumber);
            updateFlag = true;
        }
        if (daysToExpire != null) {
            Pattern pattern = Pattern.compile("^[1-9]d*$");
            Matcher matcher = pattern.matcher(daysToExpire);
            if (!matcher.find()) {
                map.put("code", 0);
                map.put("message", "Input invalid");
                return map;
            }
            order.setExpireTime(TimeUtils.addDays(originOrder.getCreateTime(), Integer.parseInt(daysToExpire)));
            order.setUpdateTime(now);
            updateMap.put("expireTime", order.getExpireTime());
            updateFlag = true;
        }
        if (trackingNumber != null) {
            order.setTrackingNumber(trackingNumber);
            order.setUpdateTime(now);
            updateMap.put("trackingNumber", trackingNumber);
            updateFlag = true;
        }
        if (remarks != null) {
            order.setRemarks(remarks);
            order.setUpdateTime(now);
            updateMap.put("remarks", remarks);
            updateFlag = true;
        }

        // the updateFlag is to solve a "Error updating database." problem which throws
        // "Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax;
        // check the manual that corresponds to your MySQL server version
        // for the right syntax to use near 'WHERE (id = 'xxx')'"
        // when all fields leave blank.
        if (!updateFlag) {
            map.put("code", 0);
            map.put("message", "Nothing changeed");
            return map;
        }

        int code = this.orderService.updateSelectiveOrder(order);
        String message = (code > 0) ? "success" : "failed";

        map.put("code", code);
        map.put("message", message);
        map.put("data", updateMap);

        return map;
    }

    @RequestMapping(value = "/order/getActive",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Get active order")
    @ResponseBody
    public HashMap<String, Object> getActiveOrderList() {
        List<Order> listOrder = this.orderService.getActiveOrderList();

        HashMap<String, Object> map = new HashMap<>();

        map.put("code", 1);
        map.put("message", "success");
        map.put("data", listOrder);

        return map;
    }

    @RequestMapping(value = "/order/getExpired",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Get expired order")
    @ResponseBody
    public HashMap<String, Object> getExpiredOrderList() {
        List<Order> listOrder = this.orderService.getExpiredOrderList();

        HashMap<String, Object> map = new HashMap<>();

        map.put("code", 1);
        map.put("message", "success");
        map.put("data", listOrder);

        return map;
    }

    @RequestMapping(value = "/order/getFinished",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Get finished order")
    @ResponseBody
    public HashMap<String, Object> getFinishedOrderList() {
        List<Order> listOrder = this.orderService.getFinishedOrderList();

        HashMap<String, Object> map = new HashMap<>();

        map.put("code", 1);
        map.put("message", "success");
        map.put("data", listOrder);

        return map;
    }

    @RequestMapping(value = "/order/getById",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Get order by Id")
    @ResponseBody
    public HashMap<String, Object> getOrderById(
            @ApiParam(required = true, value = "Order Id") @RequestParam(required = true) String orderId
    ) {
        Order order = this.orderService.getOrder(orderId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("message", "success");
        map.put("data", order);

        return map;
    }

    @RequestMapping(value = "/order/getActiveByUser",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Get active order by user")
    @ResponseBody
    public HashMap<String, Object> getActiveOrderListByUser(
            @ApiParam(required = true, value = "User Id") @RequestParam(required = true) String userId
    ) {
        List<Order> listOrder = this.orderService.getActiveOrderListByUserId(userId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("message", "success");
        map.put("data", listOrder);

        return map;
    }

    @RequestMapping(value = "/order/getExpiredByUser",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Get expired order by user")
    @ResponseBody
    public HashMap<String, Object> getExpiredOrderListByUser(
            @ApiParam(required = true, value = "User Id") @RequestParam(required = true) String userId
    ) {
        List<Order> listOrder = this.orderService.getExpiredOrderListByUserId(userId);

        HashMap<String, Object> map = new HashMap<>();

        map.put("code", 1);
        map.put("message", "success");
        map.put("data", listOrder);

        return map;
    }

    @RequestMapping(value = "/order/getFinishedByUser",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Get finished order by user")
    @ResponseBody
    public HashMap<String, Object> getFinishedOrderListByUser(
            @ApiParam(required = true, value = "User Id") @RequestParam(required = true) String userId
    ) {
        List<Order> listOrder = this.orderService.getFinishedOrderListByUserId(userId);

        HashMap<String, Object> map = new HashMap<>();

        map.put("code", 1);
        map.put("message", "success");
        map.put("data", listOrder);

        return map;
    }

    @RequestMapping(value = "/order/takeOrder",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Take order")
    @ResponseBody
    public HashMap<String, Object> takeOrder(
            @ApiParam(required = true, value = "User Id") @RequestParam(required = true) String userId,
            @ApiParam(required = true, value = "Order Id") @RequestParam(required = true) String orderId
    ) {
        HashMap<String, Object> map = new HashMap<>();
        Order order = this.orderService.getOrder(orderId);
        // User user = this.orderService.getUser(userId);
        if (order == null) {
            map.put("code", 0);
            map.put("message", "Order does not exist");
            return map;
        }
        // if (user == null) {
        //     map.put("code", 0);
        //     map.put("message", "User does not exist");
        //     return map;
        // }
        if (order.getUserId() == null) {
            map.put("code", 0);
            map.put("message", "Unknown error");
            return map;
        }
        if (order.getUserId().equals(userId)) {
            map.put("code", 0);
            map.put("message", "Not permitted");
            return map;
        }

        int code = this.orderService.setOrderOrderTakerId(orderId, userId);
        String message = (code > 0) ? "success" : "failed";
        order = this.orderService.getOrder(orderId);

        map.put("message", message);
        map.put("data", order);

        return map;
    }

    @RequestMapping(value = "/order/finishOrder",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "Finish order")
    @ResponseBody
    public HashMap<String, Object> finishOrder(
            @ApiParam(required = true, value = "User Id") @RequestParam(required = true) String userId,
            @ApiParam(required = true, value = "Order Id") @RequestParam(required = true) String orderId
    ) {
        HashMap<String, Object> map = new HashMap<>();
        Order order = this.orderService.getOrder(orderId);
        // User user = this.orderService.getUser(userId);
        if (order == null) {
            map.put("code", 0);
            map.put("message", "Order does not exist");
            return map;
        }
        // if (user == null) {
        //     map.put("code", 0);
        //     map.put("message", "User does not exist");
        //     return map;
        // }
        if (order.getUserId() == null) {
            map.put("code", 0);
            map.put("message", "Unknown error");
            return map;
        }

        if (order.getOrderTakerId() == null ||
                (!order.getOrderTakerId().equals(userId) && !order.getUserId().equals(userId))){
            map.put("code", 0);
            map.put("message", "Not permitted");
            return map;
        }

        int code = this.orderService.setOrderIsFinished(orderId);
        String message = (code > 0) ? "success" : "failed";
        order = this.orderService.getOrder(orderId);

        map.put("code", code);
        map.put("message", message);
        map.put("data", order);

        return map;
    }

    @RequestMapping(value = "/order/confirmTaker",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "User confirm order taker")
    @ResponseBody
    public HashMap<String, Object> confirmOrderTaker(
            @ApiParam(required = true, value = "User Id") @RequestParam(required = true) String userId,
            @ApiParam(required = true, value = "Order Id") @RequestParam(required = true) String orderId
    ) {
        HashMap<String, Object> map = new HashMap<>();
        Order order = this.orderService.getOrder(orderId);
        // User user = this.orderService.getUser(userId);
        if (order == null) {
            map.put("code", 0);
            map.put("message", "Order does not exist");
            return map;
        }
        // if (user == null) {
        //     map.put("code", 0);
        //     map.put("message", "User does not exist");
        //     return map;
        // }
        if (order.getUserId() == null) {
            map.put("code", 0);
            map.put("message", "Unknown error");
            return map;
        }
        if (!order.getUserId().equals(userId) || order.getOrderTakerId() == null){
            map.put("code", 0);
            map.put("message", "Not permitted");
            return map;
        }

        int code = this.orderService.setOrderIsConfirmed(orderId, true);
        String message = (code > 0) ? "success" : "failed";
        order = this.orderService.getOrder(orderId);

        map.put("code", code);
        map.put("message", message);
        map.put("data", order);

        return map;
    }

}
