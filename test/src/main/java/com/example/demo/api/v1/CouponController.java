package com.example.demo.api.v1;

import com.example.demo.Service.CouponService;
import com.example.demo.model.Coupon;
import com.example.demo.vo.CouponPureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RequestMapping("coupon")
@RestController
public class CouponController {

    @Autowired
    private CouponService couponService;


    @GetMapping("/by/category/{cid}")
    public List<CouponPureVO> getCouponListByCategory(
            @PathVariable Long cid) {
        List<Coupon> coupons = couponService.getByCategory(cid);
        if (coupons.isEmpty()) {
            return Collections.emptyList();
        }
        List<CouponPureVO> vos = CouponPureVO.getList(coupons);
        return vos;
    }
//
    @GetMapping("/whole_store")
    public List<CouponPureVO> getWholeStoreCouponList(@Autowired CouponService couponService) {
        List<Coupon> coupons = this.couponService.getWholeStoreCoupons();
        if (coupons.isEmpty()) {
            return Collections.emptyList();
        }
        return CouponPureVO.getList(coupons);
    }
//
//    @ScopeLevel()
//    @PostMapping("/collect/{id}")
//    public void collectCoupon(@PathVariable Long id) {
//        Long uid = LocalUser.getUser().getId();
//        couponService.collectOneCoupon(uid, id);
//        UnifyResponse.createSuccess(0);
//    }
//
//    @ScopeLevel
//    @GetMapping("/myself/by/status/{status}")
//    public List<CouponPureVO> getMyCouponByStatus(@PathVariable Integer status) {
//        Long uid = LocalUser.getUser().getId();
//        List<Coupon> couponList;
//
//        //触发机制 时机 过期
//        switch (CouponStatus.toType(status)) {
//            case AVAILABLE:
//                couponList = couponService.getMyAvailableCoupons(uid);
//                break;
//            case USED:
//                couponList = couponService.getMyUsedCoupons(uid);
//                break;
//            case EXPIRED:
//                couponList = couponService.getMyExpiredCoupons(uid);
//                break;
//            default:
//                throw new ParameterException(40001);
//        }
//        return CouponPureVO.getList(couponList);
//    }
//
//    @ScopeLevel()
//    @GetMapping("/myself/available/with_category")
//    public List<CouponCategoryVO> getUserCouponWithCategory() {
//        User user = LocalUser.getUser();
//        List<Coupon> coupons = couponService.getMyAvailableCoupons(user.getId());
//        if (coupons.isEmpty()) {
//            return Collections.emptyList();
//        }
//        return coupons.stream().map(coupon -> {
//            CouponCategoryVO vo = new CouponCategoryVO(coupon);
//            return vo;
//        }).collect(Collectors.toList());
//    }
}