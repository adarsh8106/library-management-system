package com.adarsh.libraryms.controller;

import com.adarsh.libraryms.dto.BookDto;
import com.adarsh.libraryms.entity.Book;
import com.adarsh.libraryms.repository.BookRepository;
import com.adarsh.libraryms.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService service;

//    private final BookService service;
//    public BookController(BookService service) {this.service = service;}

    @GetMapping("/books/page")
    public Page<Book> getbooks(@RequestParam int page, @RequestParam int size) {
        return service.getBooks(page, size);
    }

    @PostMapping("/books")
    @PreAuthorize("hasRole('ADMIN')")
    public Book addBook(@Valid @RequestBody Book book) {
        return service.addBook(book);
    }

    @PostMapping("/books/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Book> addBooks(@Valid @RequestBody List<Book> books) {
        return service.addBooks(books);
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return service.getBookById(id);
    }

    @GetMapping("/books/title/{title}")
    public List<Book> getBookByTitle(@PathVariable String title) {
        return service.getBookByTitle(title);
    }

    @GetMapping("/books/author/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author) {return service.getBookByAuthor(author);}

    @GetMapping("/books/searchboth")
    public List<Book> searchBooks(@RequestParam String author,@RequestParam String title ) {return service.searchBooks(author,title); }

    @GetMapping("/books/search")
    public List<Book> searchBook(@RequestParam String keyword) {return service.searchBook(keyword,keyword);}

    @GetMapping("/books/search/title")
    public List<Book> searchByTitle(@RequestParam String title) {return service.searchByTitle(title);}

    @GetMapping("/books/query/author")
    public List<Book> getBooksByAuthor(@RequestParam String author) {return service.getBooksByAuthor(author);}

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        return service.updateBook(id, book);
    }

    @DeleteMapping("/books/{id}")
    @PreAuthorize("hasRole('USER')")
    public String deleteBook(@PathVariable int id) {
        return service.deleteBook(id);
    }

    @GetMapping("/books/sort")
    public List<Book> sortBooks(@RequestParam String field) {
        return service.getAllBooksSorted(field);
    }

    @GetMapping("/books/sort/desc")
    public List<Book> sortDescending(@RequestParam String field) {
        return service.getBooksDescending(field);
    }

    @GetMapping("/books/dto/{id}")
    public BookDto getBookByIdDto(@PathVariable Integer id) {
        return service.getBookDtoById(id);
    }

    @PostMapping("/books/dto")
    public BookDto addBookUsingDto(@RequestBody BookDto dto) {
        return service.addBook(dto);
    }

}