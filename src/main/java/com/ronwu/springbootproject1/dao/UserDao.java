package com.ronwu.springbootproject1.dao;

import com.ronwu.springbootproject1.dto.UserRegisterRequest;
import com.ronwu.springbootproject1.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    User getUserByEmail(String email);

    Integer createUser(UserRegisterRequest userRegisterRequest);

}
