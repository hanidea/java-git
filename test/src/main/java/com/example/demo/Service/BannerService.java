package com.example.demo.Service;

import com.example.demo.model.Banner;
import org.springframework.stereotype.Service;

public interface BannerService {
    Banner getByName(String name);
}
