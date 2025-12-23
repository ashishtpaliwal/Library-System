package com.Library.Ex.BookRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Library.Ex.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByIsbn(String isbn);
}