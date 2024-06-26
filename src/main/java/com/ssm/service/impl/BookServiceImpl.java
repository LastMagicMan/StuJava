package com.ssm.service.impl;

import com.ssm.mapper.BookMapper;
import com.ssm.model.Book;
import com.ssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    @Transactional
    public void addBook(Book book) {
        bookMapper.insertBook(book);
    }

    @Override
    @Transactional(readOnly = true)
    public Book getBookById(int id) {
        return bookMapper.selectBookById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookMapper.selectAllBooks();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> searchBooks(String keyword) {
        return bookMapper.searchBooks(keyword); // 添加此方法
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        bookMapper.deleteBook(id);
    }
}