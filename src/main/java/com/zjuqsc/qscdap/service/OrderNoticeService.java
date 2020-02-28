package com.zjuqsc.qscdap.service;

import com.zjuqsc.qscdap.mapper.OrderNoticeMapper;
import com.zjuqsc.qscdap.model.OrderNotice;
import com.zjuqsc.qscdap.model.OrderNoticeCriteria;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@MapperScan(basePackages = {"com.zjuqsc.qscdap.mapper"})
public class OrderNoticeService {

    @Autowired
    OrderNoticeMapper orderNoticeMapper;

    public List<OrderNotice> getOrderNoticeByMainUserId(String userId) {
        OrderNoticeCriteria orderNoticeCriteria = new OrderNoticeCriteria();
        orderNoticeCriteria.createCriteria().andMainUserIdEqualTo(userId);
        orderNoticeCriteria.setOrderByClause("create_time desc");

        return  this.orderNoticeMapper.selectByExample(orderNoticeCriteria);
    }

    public OrderNotice getOrderNotice(String orderNoticeId) {
        return this.orderNoticeMapper.selectByPrimaryKey(orderNoticeId);
    }

    public int insertOrderNotice(OrderNotice orderNotice) {
        return this.orderNoticeMapper.insert(orderNotice);
    }

    public int setOrderNoticeIsRead(String orderNoticeId, boolean isRead) {
        OrderNotice orderNotice = this.getOrderNotice(orderNoticeId);
        orderNotice.setIsRead(isRead);
        return this.orderNoticeMapper.updateByPrimaryKeySelective(orderNotice);
    }
}
