package com.zjuqsc.qscdap.mapper;

import com.zjuqsc.qscdap.model.Order;
import com.zjuqsc.qscdap.model.OrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    @SelectProvider(type=OrderSqlProvider.class, method="countByExample")
    long countByExample(OrderCriteria example);

    @DeleteProvider(type=OrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderCriteria example);

    @Delete({
        "delete from cls_order",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into cls_order (id, create_time, ",
        "update_time, user, ",
        "express_station, express_company, ",
        "shelf_number, tracking_number, ",
        "remarks)",
        "values (#{id,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{user,jdbcType=VARCHAR}, ",
        "#{expressStation,jdbcType=VARCHAR}, #{expressCompany,jdbcType=VARCHAR}, ",
        "#{shelfNumber,jdbcType=VARCHAR}, #{trackingNumber,jdbcType=VARCHAR}, ",
        "#{remarks,jdbcType=VARCHAR})"
    })
    int insert(Order record);

    @InsertProvider(type=OrderSqlProvider.class, method="insertSelective")
    int insertSelective(Order record);

    @SelectProvider(type=OrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user", property="user", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_station", property="expressStation", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_company", property="expressCompany", jdbcType=JdbcType.VARCHAR),
        @Result(column="shelf_number", property="shelfNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="tracking_number", property="trackingNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR)
    })
    List<Order> selectByExample(OrderCriteria example);

    @Select({
        "select",
        "id, create_time, update_time, user, express_station, express_company, shelf_number, ",
        "tracking_number, remarks",
        "from cls_order",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user", property="user", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_station", property="expressStation", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_company", property="expressCompany", jdbcType=JdbcType.VARCHAR),
        @Result(column="shelf_number", property="shelfNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="tracking_number", property="trackingNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR)
    })
    Order selectByPrimaryKey(String id);

    @UpdateProvider(type=OrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderCriteria example);

    @UpdateProvider(type=OrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Order record, @Param("example") OrderCriteria example);

    @UpdateProvider(type=OrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Order record);

    @Update({
        "update cls_order",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "user = #{user,jdbcType=VARCHAR},",
          "express_station = #{expressStation,jdbcType=VARCHAR},",
          "express_company = #{expressCompany,jdbcType=VARCHAR},",
          "shelf_number = #{shelfNumber,jdbcType=VARCHAR},",
          "tracking_number = #{trackingNumber,jdbcType=VARCHAR},",
          "remarks = #{remarks,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Order record);
}