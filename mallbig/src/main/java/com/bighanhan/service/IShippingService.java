package com.bighanhan.service;

import com.bighanhan.common.ServerResponse;
import com.bighanhan.pojo.Shipping;
import com.github.pagehelper.PageInfo;

public interface IShippingService {
    ServerResponse add(Integer userId, Shipping shipping);
    ServerResponse<String> del(Integer userId,Integer shippingId);
    ServerResponse update(Integer userId, Shipping shipping);
    ServerResponse<Shipping> select(Integer userId, Integer shippingId);
    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);
}
