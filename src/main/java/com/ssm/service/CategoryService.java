package com.ssm.service;

import com.ssm.model.Category;
import java.util.List;

public interface CategoryService {
    void addCategory(Category category);
    Category getCategoryById(int id);
    List<Category> getAllCategories();
    List<Category> searchCategories(String keyword); // 添加此方法
    void updateCategory(Category category);
    void deleteCategory(int id);
}

