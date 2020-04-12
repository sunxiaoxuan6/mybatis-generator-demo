package com.mybatis.generator.demo.mapper.generator;

import com.mybatis.generator.demo.model.generator.Users;
import com.mybatis.generator.demo.model.generator.UsersExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface UsersMapper {

    long countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    @Delete({
            "delete from users",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into users (id, user_name, ",
            "sex, note)",
            "values (#{id,jdbcType=BIGINT}, #{userName,jdbcType=VARCHAR}, ",
            "#{sex,jdbcType=INTEGER}, #{note,jdbcType=VARCHAR})"
    })
    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExampleWithRowbounds(UsersExample example, RowBounds rowBounds);

    List<Users> selectByExample(UsersExample example);

    @Select({
            "select",
            "id, user_name, sex, note",
            "from users",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.mybatis.generator.mapper.generator.UsersMapper.BaseResultMap")
    Users selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    @Update({
            "update users",
            "set user_name = #{userName,jdbcType=VARCHAR},",
            "sex = #{sex,jdbcType=INTEGER},",
            "note = #{note,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Users record);
}