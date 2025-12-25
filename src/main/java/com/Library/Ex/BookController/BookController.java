package com.Library.Ex.BookController;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Library.Ex.BookService.BookService;
import com.Library.Ex.Entity.Book;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }
    
    @Operation(summary = "Create a new book")
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(service.createBook(book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(service.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getBookById(id));
    }
    
    @GetMapping("search/{isbn}")
    public ResponseEntity<Book> findByIsbn(@PathVariable String isbn){
    	return ResponseEntity.ok(service.findbyIsbn(isbn));
    }
    
    @GetMapping("/search/aurthor/{author}")
    public ResponseEntity<List<Book>> findByaurthor(@PathVariable String aurthor){
    	return ResponseEntity.ok(service.findByAuthor(aurthor));
    }
    
    @GetMapping("/Search/title/{titel}")
    public ResponseEntity<List<Book>> findBytitel(@PathVariable String title){
    	return ResponseEntity.ok(service.findByTitle(title));
    	
    }
    
    @GetMapping("/search/category/{category}")
    public ResponseEntity<List<Book>> findBycategory(@PathVariable String category){
    	return ResponseEntity.ok(service.findByCategory(category));
    }

    
    
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(  @PathVariable Long id, @RequestBody Book book) {
        return ResponseEntity.ok(service.updateBook(id, book));
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/paged")
    public ResponseEntity<Page<Book>> getAllBooksPaged( @PageableDefault(size = 5) Pageable pageable) {

        return ResponseEntity.ok(service.getAllBooks(pageable));
    }
}