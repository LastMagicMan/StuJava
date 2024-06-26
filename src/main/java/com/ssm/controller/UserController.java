package com.ssm.controller;

import com.ssm.model.User;
import com.ssm.service.UserService;
import com.ssm.service.BookService;
import com.ssm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.ssm.model.Book;
import com.ssm.model.Category;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model) {
        User validatedUser = userService.validateUser(user.getUsername(), user.getPassword());
        if (validatedUser != null) {
            model.addAttribute("user", validatedUser);
            return "managementSystem";
        } else {
            model.addAttribute("error", "用户名或密码错误！");
            return "index";
        }
    }

    @GetMapping("/managementSystem")
    public String showManagementSystem(Model model) {
        return "managementSystem";
    }

    @GetMapping("/showBooks")
    public String showBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "showBooks";
    }

    @GetMapping("/showCategories")
    public String showCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "showCategories";
    }

    @GetMapping("/searchBooks")
    public String searchBooks(@RequestParam("keyword") String keyword, Model model) {
        List<Book> books = bookService.searchBooks(keyword);
        model.addAttribute("books", books);
        return "showBooks";
    }

    @GetMapping("/searchCategories")
    public String searchCategories(@RequestParam("keyword") String keyword, Model model) {
        List<Category> categories = categoryService.searchCategories(keyword);
        model.addAttribute("categories", categories);
        return "showCategories";
    }
}
