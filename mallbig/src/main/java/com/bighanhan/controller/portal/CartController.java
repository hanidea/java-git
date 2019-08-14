package com.bighanhan.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart/")
public class CartController {

//    @RequestMapping("add.do")
////    @ResponseBody
////    public ServerResponse<CartVo> add(HttpSession session, Integer count, Integer productId){
////        User user = (User)session.getAttribute(Const.CURRENT_USER);
////        if(user ==null){
////            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
////        }
////        return iCartService.add(user.getId(),productId,count);
////    }
}
