package com.ssm.service;

import com.ssm.model.Book;
import java.util.List;

public interface BookService {
    void addBook(Book book);
    Book getBookById(int id);
    List<Book> getAllBooks();
    List<Book> searchBooks(String keyword); // 添加此方法
    void updateBook(Book book);
    void deleteBook(int id);
}