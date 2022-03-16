package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerService extends ServiceImpl<BannerMapper, BannerDO> {
    @Autowired
    private BannerMapper bannerMapper;

    public void delete(Long id) {
        BannerDO banner = this.getById(id);
        if (banner == null) {
            throw new NotFoundException(20000);
        }
        this.getBaseMapper().deleteById(id);
    }


    public void update(BannerDTO dto, Long id){
        BannerDO bannerDO = this.getById(id);
        if (bannerDO == null){
            throw new NotFoundException(20000);
        }
        BeanUtils.copyProperties(dto, bannerDO);
        this.updateById(bannerDO);
    }
//    public void getBanners(){
//       // bannerMapper.selectPage();
//    }
}
