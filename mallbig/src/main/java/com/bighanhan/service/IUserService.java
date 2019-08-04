package com.bighanhan.service;

import com.bighanhan.common.ServerResponse;
import com.bighanhan.pojo.User;

public interface IUserService {
    ServerResponse<User> login(String username, String password);
    ServerResponse<String> register(User user);
    ServerResponse<String> checkValid(String str,String type);
}
