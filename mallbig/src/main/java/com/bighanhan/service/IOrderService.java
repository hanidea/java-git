package com.bighanhan.service;

import com.bighanhan.common.ServerResponse;

public interface IOrderService {
    ServerResponse pay(Long orderNo, Integer userId, String path);
}
