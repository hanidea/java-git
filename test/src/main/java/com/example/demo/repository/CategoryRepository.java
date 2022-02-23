package com.example.demo.repository;

import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Locale;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByIsRootOrderByIndexAsc(Boolean isRoot);

}
