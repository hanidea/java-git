package com.bighanhan.service;

import com.bighanhan.common.ServerResponse;
import com.bighanhan.vo.CartVo;

public interface ICartService {
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);
}
