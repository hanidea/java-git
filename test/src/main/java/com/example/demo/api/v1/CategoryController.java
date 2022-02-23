package com.example.demo.api.v1;

import com.example.demo.Service.CategoryService;
import com.example.demo.Service.GridCategoryService;
import com.example.demo.exception.http.NotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.GridCategory;
import com.example.demo.vo.CategoriesAllVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/category")
@RestController
@ResponseBody
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private GridCategoryService gridCategoryService;
    @GetMapping("/all")
    public CategoriesAllVO getAll(){
        Map<Integer, List<Category>> categories = categoryService.getAll();
        return new CategoriesAllVO(categories);
    }
    @GetMapping("/grid/all")
    public List<GridCategory> getGridCategoryList() {
        List<GridCategory> gridCategoryList = gridCategoryService.getGridCategoryList();
        if (gridCategoryList.isEmpty()) {
            throw new NotFoundException(30009);
        }
        return gridCategoryList;
    }
}
