package com.ssm.service.impl;

import com.ssm.mapper.CategoryMapper;
import com.ssm.model.Category;
import com.ssm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    @Transactional
    public void addCategory(Category category) {
        categoryMapper.insertCategory(category);
    }

    @Override
    @Transactional(readOnly = true)
    public Category getCategoryById(int id) {
        return categoryMapper.selectCategoryById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> getAllCategories() {
        return categoryMapper.selectAllCategories();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> searchCategories(String keyword) {
        return categoryMapper.searchCategories(keyword); // 添加此方法
    }

    @Override
    @Transactional
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }

    @Override
    @Transactional
    public void deleteCategory(int id) {
        categoryMapper.deleteCategory(id);
    }
}
