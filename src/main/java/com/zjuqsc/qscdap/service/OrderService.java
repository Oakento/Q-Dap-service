package com.zjuqsc.qscdap.service;

import com.zjuqsc.qscdap.mapper.OrderMapper;
import com.zjuqsc.qscdap.model.Order;
import com.zjuqsc.qscdap.model.OrderCriteria;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@MapperScan(basePackages = {"com.zjuqsc.qscdap.mapper"})
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public List<Order> getOrderByStatus(Boolean is_expired, Boolean is_finished){

        OrderCriteria orderCriteria = new OrderCriteria();
        orderCriteria.createCriteria().andIsExpiredEqualTo(is_expired).andIsFinishedEqualTo(is_finished);
        orderCriteria.setOrderByClause("create_time desc");

        List<Order> orderList = this.orderMapper.selectByExample(orderCriteria);
        return orderList;
    }

    public List<Order> getOrderByUserId(String userId) {
        OrderCriteria orderCriteria = new OrderCriteria();
        orderCriteria.createCriteria().andUserIdEqualTo(userId);
        orderCriteria.setOrderByClause("create_time desc");

        List<Order> orderList = this.orderMapper.selectByExample(orderCriteria);
        return orderList;
    }

    public Order getOrder(String orderId) {
        return this.orderMapper.selectByPrimaryKey(orderId);
    }

    public int insertOrder(Order order) {

        return this.orderMapper.insert(order);

    }


}
