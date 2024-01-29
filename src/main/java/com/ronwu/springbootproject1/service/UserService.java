package com.ronwu.springbootproject1.service;

import com.ronwu.springbootproject1.dto.UserRegisterRequest;
import com.ronwu.springbootproject1.model.User;

public interface UserService {

    Integer register(UserRegisterRequest userRegisterRequest);
    User getUserById(Integer userId);


}
