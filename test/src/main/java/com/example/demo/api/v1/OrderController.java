package com.example.demo.api.v1;

import com.example.demo.Service.OrderService;
import com.example.demo.core.LocalUser;
import com.example.demo.core.interceptors.ScopeLevel;
import com.example.demo.dto.OrderDTO;
import com.example.demo.logic.OrderChecker;
import com.example.demo.vo.OrderIdVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@Validated
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("")
    @ScopeLevel()
    public OrderIdVO placeOrder(@RequestBody OrderDTO orderDTO) {
        Long uid = LocalUser.getUser().getId();
        OrderChecker orderChecker = this.orderService.isOk(uid, orderDTO);
        Long oid = this.orderService.placeOrder(uid, orderDTO, orderChecker);
        return new OrderIdVO(oid);
    }

}
