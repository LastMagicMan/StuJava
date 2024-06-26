package com.ssm.mapper;

import com.ssm.model.Category;
import java.util.List;

public interface CategoryMapper {
    void insertCategory(Category category);
    Category selectCategoryById(int id);
    List<Category> selectAllCategories();
    void updateCategory(Category category);
    void deleteCategory(int id);
    List<Category> searchCategories(String keyword);
}
