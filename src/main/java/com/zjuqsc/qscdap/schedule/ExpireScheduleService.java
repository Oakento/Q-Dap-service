package com.zjuqsc.qscdap.schedule;


import com.zjuqsc.qscdap.mapper.OrderMapper;
import com.zjuqsc.qscdap.model.Order;
import com.zjuqsc.qscdap.model.OrderCriteria;
import com.zjuqsc.qscdap.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@EnableScheduling
@Component
@Slf4j
public class ExpireScheduleService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderService orderService;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void doOrderAutoExpire() {
        Order order = new Order();
        OrderCriteria orderCriteria = new OrderCriteria();

        orderCriteria.createCriteria()
                .andIsFinishedNotEqualTo(true)
                .andIsExpiredNotEqualTo(true)
                .andExpireTimeLessThanOrEqualTo(new Date());

        order.setIsExpired(true);

        this.orderMapper.updateByExampleSelective(order, orderCriteria);
    }
}
