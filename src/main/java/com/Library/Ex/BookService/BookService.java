package com.Library.Ex.BookService;



import java.util.*;

import org.springframework.data.domain.*;

import com.Library.Ex.Entity.Book;

public interface BookService {

    Book createBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
    List<Book> findByTitle(String titel);
    List<Book> findByAuthor(String Author);
    List<Book> findByCategory(String category);
    Book findbyIsbn(String Isbn);
   
    Page<Book> getAllBooks(Pageable pageable);
    
}
