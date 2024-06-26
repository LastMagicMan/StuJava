package com.ssm.mapper;

import com.ssm.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User validateUser(@Param("username") String username, @Param("password") String password);
}
