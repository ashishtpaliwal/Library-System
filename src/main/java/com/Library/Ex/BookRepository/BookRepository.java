package com.Library.Ex.BookRepository;

import java.awt.print.Pageable;
import java.util.List;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Library.Ex.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByIsbn(String isbn);
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByAuthorIgnoreCase(String author);
	Book findByIsbn(String isbn);
	List<Book> findByCategoryIgnoreCase(String category);
	
	
}