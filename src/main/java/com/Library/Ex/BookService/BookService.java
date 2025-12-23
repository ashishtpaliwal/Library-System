package com.Library.Ex.BookService;

import java.util.*;

import com.Library.Ex.Entity.Book;

public interface BookService {

    Book createBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
}
