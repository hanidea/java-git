package com.bighanhan.service;

import com.bighanhan.common.ServerResponse;
import com.bighanhan.pojo.Product;
import com.bighanhan.vo.ProductDetailVo;

public interface IProductService {
    ServerResponse saveOrUpdateProduct(Product product);
    ServerResponse<String> setSaleStatus(Integer productId,Integer status);
    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);
}
