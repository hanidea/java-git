package com.example.demo.Service;

import com.example.demo.model.Banner;
import com.example.demo.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerRepository bannerRepository;
    public Banner getByName(String name){
        return bannerRepository.findOneByName(name);
    }
}
