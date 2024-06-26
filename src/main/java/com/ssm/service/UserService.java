package com.ssm.service;

import com.ssm.model.User;

public interface UserService {
    User validateUser(String username, String password);
}

