package com.zjuqsc.qscdap.mapper;

import com.zjuqsc.qscdap.model.OrderNotice;
import com.zjuqsc.qscdap.model.OrderNoticeCriteria;
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
public interface OrderNoticeMapper {
    @SelectProvider(type=OrderNoticeSqlProvider.class, method="countByExample")
    long countByExample(OrderNoticeCriteria example);

    @DeleteProvider(type=OrderNoticeSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderNoticeCriteria example);

    @Delete({
        "delete from order_notice",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into order_notice (id, type, ",
        "create_time, order_id, ",
        "main_user_id, sub_user_id, ",
        "is_read)",
        "values (#{id,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{orderId,jdbcType=VARCHAR}, ",
        "#{mainUserId,jdbcType=VARCHAR}, #{subUserId,jdbcType=VARCHAR}, ",
        "#{isRead,jdbcType=BIT})"
    })
    int insert(OrderNotice record);

    @InsertProvider(type=OrderNoticeSqlProvider.class, method="insertSelective")
    int insertSelective(OrderNotice record);

    @SelectProvider(type=OrderNoticeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="main_user_id", property="mainUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_user_id", property="subUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_read", property="isRead", jdbcType=JdbcType.BIT)
    })
    List<OrderNotice> selectByExample(OrderNoticeCriteria example);

    @Select({
        "select",
        "id, type, create_time, order_id, main_user_id, sub_user_id, is_read",
        "from order_notice",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="main_user_id", property="mainUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_user_id", property="subUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_read", property="isRead", jdbcType=JdbcType.BIT)
    })
    OrderNotice selectByPrimaryKey(String id);

    @UpdateProvider(type=OrderNoticeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OrderNotice record, @Param("example") OrderNoticeCriteria example);

    @UpdateProvider(type=OrderNoticeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OrderNotice record, @Param("example") OrderNoticeCriteria example);

    @UpdateProvider(type=OrderNoticeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderNotice record);

    @Update({
        "update order_notice",
        "set type = #{type,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "order_id = #{orderId,jdbcType=VARCHAR},",
          "main_user_id = #{mainUserId,jdbcType=VARCHAR},",
          "sub_user_id = #{subUserId,jdbcType=VARCHAR},",
          "is_read = #{isRead,jdbcType=BIT}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(OrderNotice record);
}