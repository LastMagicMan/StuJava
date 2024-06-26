package com.ssm.mapper;

import com.ssm.model.Book;
import java.util.List;

public interface BookMapper {
    void insertBook(Book book);
    Book selectBookById(int id);
    List<Book> selectAllBooks();
    void updateBook(Book book);
    void deleteBook(int id);
    List<Book> searchBooks(String keyword);
}
