package com.Library.Ex.BookServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Library.Ex.BookRepository.BookRepository;
import com.Library.Ex.BookService.BookService;
import com.Library.Ex.Entity.Book;
import com.Library.Ex.Exception.BookNotFoundException;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book createBook(Book book) {
        return repository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book existing = getBookById(id);
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setIsbn(book.getIsbn());
        existing.setPublishedDate(book.getPublishedDate());
        return repository.save(existing);
    }

    @Override
    public void deleteBook(Long id) {
        repository.delete(getBookById(id));
    }

	

	
}

