package com.example.demo.Service;

import com.example.demo.model.GridCategory;
import com.example.demo.repository.GridCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GridCategoryService {
    @Autowired
    private GridCategoryRepository gridCategoryRepository;
    public List<GridCategory> getGridCategoryList() {
        return gridCategoryRepository.findAll();
    }
}
