package com.zjuqsc.qscdap.service;

import com.zjuqsc.qscdap.mapper.OrderMapper;
import com.zjuqsc.qscdap.model.Order;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@MapperScan(basePackages = {"com.zjuqsc.qscdap.mapper"})
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public Order getOrder(String orderId) {
        return this.orderMapper.selectByPrimaryKey(orderId);
    }

}
