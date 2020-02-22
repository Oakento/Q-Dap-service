package com.zjuqsc.qscdap.service;

import com.zjuqsc.qscdap.mapper.OrderMapper;
import com.zjuqsc.qscdap.model.Order;
import com.zjuqsc.qscdap.model.OrderCriteria;
import com.zjuqsc.qscdap.util.SnowFlake;
import com.zjuqsc.qscdap.util.TimeUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@MapperScan(basePackages = {"com.zjuqsc.qscdap.mapper"})
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public List<Order> getOrderByStatus(Boolean isExpired, Boolean isFinished){

        OrderCriteria orderCriteria = new OrderCriteria();
        orderCriteria.createCriteria().andIsExpiredEqualTo(isExpired).andIsFinishedEqualTo(isFinished);
        orderCriteria.setOrderByClause("create_time desc");

        return this.orderMapper.selectByExample(orderCriteria);
    }

    public List<Order> getOrderByUserId(String userId) {
        OrderCriteria orderCriteria = new OrderCriteria();
        orderCriteria.createCriteria().andUserIdEqualTo(userId);
        orderCriteria.setOrderByClause("create_time desc");

        return this.orderMapper.selectByExample(orderCriteria);
    }

    public List<Order> getOrderByUserIdAndStatus(String userId, Boolean isExpired, Boolean isFinished) {
        OrderCriteria orderCriteria = new OrderCriteria();
        orderCriteria.createCriteria()
                .andUserIdEqualTo(userId)
                .andIsExpiredEqualTo(isExpired)
                .andIsFinishedEqualTo(isFinished);
        orderCriteria.setOrderByClause("create_time desc");

        return this.orderMapper.selectByExample(orderCriteria);
    }


    public Order getOrder(String orderId) {
        return this.orderMapper.selectByPrimaryKey(orderId);
    }

    public int insertOrder(Order order) {
        return this.orderMapper.insert(order);
    }

    public int deleteOrder(String orderId) {
        return this.orderMapper.deleteByPrimaryKey(orderId);
    }

    public int setOrderExpireTime(String orderId, int daysToExpire) {

        Order order = this.getOrder(orderId);
        order.setExpireTime(
                TimeUtils.addDays(order.getCreateTime(), daysToExpire));

        return this.orderMapper.updateByPrimaryKeySelective(order);
    }

    public int setOrderUpdateTime(String orderId) {
        Date now = new Date();
        Order order = this.getOrder(orderId);
        order.setUpdateTime(now);

        return this.orderMapper.updateByPrimaryKeySelective(order);
    }

    public int setOrderIsFinished(String orderId, boolean isFinished) {
        Order order = this.getOrder(orderId);
        order.setIsFinished(isFinished);

        return this.orderMapper.updateByPrimaryKeySelective(order);
    }

    public int setOrderIsConfirmed(String orderId, boolean isConfirmed) {
        Order order = this.getOrder(orderId);
        order.setIsConfirmed(isConfirmed);

        return this.orderMapper.updateByPrimaryKeySelective(order);
    }
    public int setOrderExpressStation(String orderId, String expressStation) {
        Order order = this.getOrder(orderId);
        if (order.getExpressStation().equals(expressStation))
            return 0;
        else {
            order.setExpressStation(expressStation);
            return this.orderMapper.updateByPrimaryKeySelective(order);
        }
    }

    public int setOrderExpressCompany(String orderId, String expressCompany) {
        Order order = this.getOrder(orderId);
        if (order.getExpressCompany().equals(expressCompany))
            return 0;
        else {
            order.setExpressCompany(expressCompany);
            return this.orderMapper.updateByPrimaryKeySelective(order);
        }
    }

    public int setOrderShelfNumber(String orderId, String shelfNumber) {
        Order order = this.getOrder(orderId);
        if (order.getShelfNumber().equals(shelfNumber))
            return 0;
        else {
            order.setShelfNumber(shelfNumber);
            return this.orderMapper.updateByPrimaryKeySelective(order);
        }
    }


    public int setOrderTrackingNumber(String orderId, String trackingNumber) {
        Order order = this.getOrder(orderId);
        String currentTrackingNumber = order.getTrackingNumber();
        if (currentTrackingNumber == null && trackingNumber == null)
            return 0;
        else if (currentTrackingNumber != null && currentTrackingNumber.equals(trackingNumber))
            return 0;
        else {
            order.setTrackingNumber(trackingNumber);
            return this.orderMapper.updateByPrimaryKeySelective(order);
        }
    }

    public int setOrderRemarks(String orderId, String remarks) {
        Order order = this.getOrder(orderId);
        String currentRemarks = order.getRemarks();
        if (currentRemarks == null && remarks == null)
            return 0;
        else if (currentRemarks != null && order.getRemarks().equals(remarks))
            return 0;
        else {
            order.setRemarks(remarks);
            return this.orderMapper.updateByPrimaryKeySelective(order);
        }
    }

    public int setOrderOrderTakerId(String orderId, String orderTakerId) {
        Order order = this.getOrder(orderId);
        order.setOrderTakerId(orderTakerId);

        return this.orderMapper.updateByPrimaryKeySelective(order);
    }

    public String generateOrderId() {
        return Long.toString(new SnowFlake(0, 0).nextId());
    }

}
