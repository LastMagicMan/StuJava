package com.ssm.service.impl;

import com.ssm.mapper.UserMapper;
import com.ssm.model.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public User validateUser(String username, String password) {
        return userMapper.validateUser(username, password);
    }
}
