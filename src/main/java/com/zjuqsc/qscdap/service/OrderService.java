package com.zjuqsc.qscdap.service;

import com.zjuqsc.qscdap.mapper.OrderMapper;
import com.zjuqsc.qscdap.model.Order;
import com.zjuqsc.qscdap.model.OrderCriteria;
import com.zjuqsc.qscdap.util.TimeUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public Order getOrder(String orderId) {
        return this.orderMapper.selectByPrimaryKey(orderId);
    }

    public int insertOrder(Order order) {
        return this.orderMapper.insert(order);
    }

    public int deleteOrder(String orderId) {
        return this.orderMapper.deleteByPrimaryKey(orderId);
    }

    public Order setOrderExpireTime(String orderId, int daysToExpire) {

        Order order = this.getOrder(orderId);
        order.setExpireTime(
                TimeUtils.addDays(order.getCreateTime(), daysToExpire));
        this.orderMapper.updateByPrimaryKeySelective(order);
        return order;
    }

    public Order setOrderIsExpired(String orderId) {
        Order order = this.getOrder(orderId);
        order.setIsExpired(
                TimeUtils.isExpired(order.getExpireTime()));
        this.orderMapper.updateByPrimaryKeySelective(order);
        return order;
    }

    public Order setOrderIsFinished(String orderId, boolean isFinished) {
        Order order = this.getOrder(orderId);
        order.setIsFinished(isFinished);
        this.orderMapper.updateByPrimaryKeySelective(order);
        return order;
    }

    public Order setOrderExpressStation(String orderId, String expressStation) {
        Order order = this.getOrder(orderId);
        order.setExpressStation(expressStation);
        this.orderMapper.updateByPrimaryKeySelective(order);
        return order;
    }

    public Order setOrderExpressCompany(String orderId, String expressCompany) {
        Order order = this.getOrder(orderId);
        order.setExpressCompany(expressCompany);
        this.orderMapper.updateByPrimaryKeySelective(order);
        return order;
    }

    public Order setOrderShelfNumber(String orderId, String shelfNumber) {
        Order order = this.getOrder(orderId);
        order.setShelfNumber(shelfNumber);
        this.orderMapper.updateByPrimaryKeySelective(order);
        return order;
    }

    public Order setOrderTrackingNumber(String orderId, String trackingNumber) {
        Order order = this.getOrder(orderId);
        order.setTrackingNumber(trackingNumber);
        this.orderMapper.updateByPrimaryKeySelective(order);
        return order;
    }

    public Order setOrderRemarks(String orderId, String remarks) {
        Order order = this.getOrder(orderId);
        order.setRemarks(remarks);
        this.orderMapper.updateByPrimaryKeySelective(order);
        return order;
    }

    public Order setOrderOrderTakerId(String orderId, String orderTakerId) {
        Order order = this.getOrder(orderId);
        order.setOrderTakerId(orderTakerId);
        this.orderMapper.updateByPrimaryKeySelective(order);
        return order;
    }

}
