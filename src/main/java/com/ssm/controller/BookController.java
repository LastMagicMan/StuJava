package com.ssm.controller;

import com.ssm.model.Book;
import com.ssm.model.Category;
import com.ssm.service.BookService;
import com.ssm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService CategoryService; // 注入CategoryService

    @GetMapping("/search")
    public String searchBooks(@RequestParam("keyword") String keyword, Model model) {
        List<Book> books = bookService.searchBooks(keyword);
        model.addAttribute("books", books);
        return "showBooks";
    }

    @GetMapping("/showBooks")
    public String showBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "showBooks";
    }

    @GetMapping("/addBooks")
    public String addBookForm(Model model) {
        List<Category> categories = CategoryService.getAllCategories(); // 获取所有分类信息
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categories); // 添加分类信息到模型
        return "addBooks";
    }


    @PostMapping("/addBooks")
    public String addBook(@ModelAttribute("book") Book book, Model model) {
        bookService.addBook(book);
        return "redirect:/books/showBooks";
    }

    @GetMapping("/updateBooks/{id}")
    public String updateBookForm(@PathVariable("id") int id, Model model) {
        Book book = bookService.getBookById(id);
        List<Category> categories = CategoryService.getAllCategories();
        model.addAttribute("book", book);
        model.addAttribute("categories", categories);
        return "updateBooks";
    }

    @PostMapping("/updateBooks")
    public String updateBook(@ModelAttribute("book") Book book) {
        bookService.updateBook(book);
        return "redirect:/books/showBooks";
    }


    @PostMapping("/books/{id}/edit")
    public String editBook(@PathVariable("id") int id, @ModelAttribute("book") Book book) {
        book.setBook_id(id); // 设置图书的 ID
        bookService.updateBook(book); // 更新图书信息
        return "redirect:/books/showBooks"; // 重定向到显示图书的页面
    }

    @GetMapping("/deleteBooks/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return "redirect:/books/showBooks";
    }
}
