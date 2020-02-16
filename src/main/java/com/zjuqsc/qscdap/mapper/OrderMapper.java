package com.zjuqsc.qscdap.mapper;

import com.zjuqsc.qscdap.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface OrderMapper {
    String TABLE_NAME = " order ";
    String INSERT_FIELDS = " create_time, update_time, user, " +
            "express_station, express_company, shelf_number, tracking_number, remarks ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Select({"select",
            SELECT_FIELDS,
            "from",
            TABLE_NAME,
            "order by id desc limit #{offset}, #{limit}"})
    List<Order> getLastOrder(@Param("offset") int offset,@Param("limit") int limit);

    @Insert({"insert into",
            TABLE_NAME,
            "(", INSERT_FIELDS, ")" +
            " values (#{create_time},#{update_time}," +
                     "#{express_station},#{express_company}," +
                     "#{shelf_number},#{tracking_number}," +
                    " #{remarks})"})
    int insertOrder(Order order);
}
