package com.zjuqsc.qscdap.service;

import com.zjuqsc.qscdap.mapper.OrderMapper;
import com.zjuqsc.qscdap.model.Order;
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

        return this.orderMapper.selectByStatus(is_expired, is_finished);
    }

    public List<Order> getOrderByUserId(String userId) {
        return this.orderMapper.selectByUserId(userId);
    }

    public Order getOrder(String orderId) {
        return this.orderMapper.selectByPrimaryKey(orderId);
    }

    


}
