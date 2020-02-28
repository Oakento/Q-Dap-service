package com.zjuqsc.qscdap.service;

import com.zjuqsc.qscdap.mapper.OrderMapper;
import com.zjuqsc.qscdap.model.Order;
import com.zjuqsc.qscdap.model.OrderCriteria;
import com.zjuqsc.qscdap.util.SnowFlake;
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

    public List<Order> getAllOrder(){

        OrderCriteria orderCriteria = new OrderCriteria();
        orderCriteria.setOrderByClause("create_time desc");

        return this.orderMapper.selectByExample(orderCriteria);
    }

    public List<Order> getActiveOrderList() {
        OrderCriteria orderCriteria = new OrderCriteria();
        orderCriteria.createCriteria().andIsExpiredNotEqualTo(true).andIsFinishedNotEqualTo(true);
        orderCriteria.setOrderByClause("create_time desc");

        return this.orderMapper.selectByExample(orderCriteria);
    }

    public List<Order> getExpiredOrderList() {
        OrderCriteria orderCriteria = new OrderCriteria();
        orderCriteria.createCriteria().andIsExpiredEqualTo(true);
        orderCriteria.setOrderByClause("create_time desc");

        return this.orderMapper.selectByExample(orderCriteria);
    }

    public List<Order> getFinishedOrderList() {
        OrderCriteria orderCriteria = new OrderCriteria();
        orderCriteria.createCriteria().andIsFinishedEqualTo(true);
        orderCriteria.setOrderByClause("create_time desc");

        return this.orderMapper.selectByExample(orderCriteria);
    }

    public List<Order> getActiveOrderListByUserId(String userId) {
        OrderCriteria orderCriteria = new OrderCriteria();
        orderCriteria.createCriteria()
                .andUserIdEqualTo(userId)
                .andIsExpiredNotEqualTo(true)
                .andIsFinishedNotEqualTo(true);
        orderCriteria.setOrderByClause("create_time desc");

        return this.orderMapper.selectByExample(orderCriteria);
    }

    public List<Order> getExpiredOrderListByUserId(String userId) {
        OrderCriteria orderCriteria = new OrderCriteria();
        orderCriteria.createCriteria()
                .andUserIdEqualTo(userId)
                .andIsExpiredEqualTo(true);
        orderCriteria.setOrderByClause("create_time desc");

        return this.orderMapper.selectByExample(orderCriteria);
    }

    public List<Order> getFinishedOrderListByUserId(String userId) {
        OrderCriteria orderCriteria = new OrderCriteria();
        orderCriteria.createCriteria()
                .andUserIdEqualTo(userId)
                .andIsFinishedEqualTo(true);
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

    public int updateSelectiveOrder(Order order) {
        return this.orderMapper.updateByPrimaryKeySelective(order);
    }


    public int setOrderIsFinished(String orderId) {
        Order order = this.getOrder(orderId);
        order.setIsFinished(true);

        return this.orderMapper.updateByPrimaryKeySelective(order);
    }

    public int setOrderIsConfirmed(String orderId, boolean isConfirmed) {
        Order order = this.getOrder(orderId);
        order.setIsConfirmed(isConfirmed);
        return this.orderMapper.updateByPrimaryKeySelective(order);
    }

    public int setOrderIsTaken(String orderId, boolean isTaken) {
        Order order = this.getOrder(orderId);
        order.setIsTaken(isTaken);
        return this.orderMapper.updateByPrimaryKeySelective(order);
    }

    public int setOrderOrderTakerId(String orderId, String orderTakerId) {
        Order order = this.getOrder(orderId);
        order.setOrderTakerId(orderTakerId);

        return this.orderMapper.updateByPrimaryKeySelective(order);
    }

}
