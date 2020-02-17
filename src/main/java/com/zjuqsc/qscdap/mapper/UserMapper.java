package com.zjuqsc.qscdap.mapper;

import com.zjuqsc.qscdap.model.User;
import com.zjuqsc.qscdap.model.UserCriteria;
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

public interface UserMapper {
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    long countByExample(UserCriteria example);

    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserCriteria example);

    @Delete({
        "delete from cls_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into cls_user (id, nick_name, ",
        "name, card_id, phone_number)",
        "values (#{id,jdbcType=VARCHAR}, #{nickName,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{cardId,jdbcType=VARCHAR}, #{phoneNumber,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectByExample(UserCriteria example);

    @Select({
        "select",
        "id, nick_name, name, card_id, phone_number",
        "from cls_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(String id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserCriteria example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserCriteria example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update cls_user",
        "set nick_name = #{nickName,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "card_id = #{cardId,jdbcType=VARCHAR},",
          "phone_number = #{phoneNumber,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);
}