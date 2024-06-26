package com.ssm.controller;

import com.ssm.model.Category;
import com.ssm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/search")
    public String searchCategories(@RequestParam("keyword") String keyword, Model model) {
        List<Category> categories = categoryService.searchCategories(keyword);
        model.addAttribute("categories", categories);
        return "showCategories";
    }

    @GetMapping("/showCategories")
    public String showCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "showCategories";
    }

    @GetMapping("/addCategories")
    public String addCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addCategories";
    }

    @PostMapping("/addCategories")
    public String addCategory(@ModelAttribute("category") Category category, Model model) {
        categoryService.addCategory(category);
        return "redirect:/categories/showCategories";
    }

    @GetMapping("/updateCategories/{id}")
    public String updateCategoryForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("category", categoryService.getCategoryById(id));
        return "updateCategories";
    }

    @PostMapping("/updateCategories")
    public String updateCategory(@ModelAttribute("category") Category category) {
        categoryService.updateCategory(category);
        return "redirect:/categories/showCategories";
    }

    @GetMapping("/deleteCategories/{id}")
    public String deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories/showCategories";
    }
}
