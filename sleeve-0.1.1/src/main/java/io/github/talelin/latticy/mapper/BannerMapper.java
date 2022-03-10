package io.github.talelin.latticy.mapper;

import io.github.talelin.latticy.model.BannerDO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BannerMapper {
    List<BannerDO> getAllBanners();
    @Select("SELECT * FROM banner")
    List<BannerDO> getAllBanners1();
    long insertBanner(BannerDO bannerDO);
}
