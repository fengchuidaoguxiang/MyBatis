package com.mapper;

import com.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("SELECT u_id,u_name,u_salary FROM t_user WHERE u_id=#{id}")
    @ResultMap("userResultMap")
    public User get(long id);


    @Select("SELECT u_id,u_name,u_salary FROM t_user")
    @Results(id="userResultMap",value={
            @Result(column = "u_id", property = "id"),
            @Result(column = "u_name", property = "name"),
            @Result(column = "u_salary", property = "salary")
    })
    public List<User> getAll();

    @Insert({"insert into t_user(u_name,u_salary)",
            "values(#{name},#{salary})"})
    @Options(keyProperty="id",useGeneratedKeys=true)
    public void save(User user);
}
