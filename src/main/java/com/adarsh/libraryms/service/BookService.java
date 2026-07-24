package com.adarsh.libraryms.service;

import com.adarsh.libraryms.dto.BookDto;
import com.adarsh.libraryms.entity.Book;
import com.adarsh.libraryms.exception.BookNotFoundException;
import com.adarsh.libraryms.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class BookService
 {

     private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository repository;

  //    private final BookRepository repository;
  //    public BookService(BookRepository repository) {this.repository = repository;}

    public Page<Book> getBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    @CacheEvict(value = "books", allEntries = true)
    public Book addBook(Book book) {
        logger.info("Adding new book: {}", book.getTitle());
        Book savedBook = repository.save(book);
        logger.info("Book added successfully with id: {}", savedBook.getId());
        return savedBook;
    }

    public List<Book> addBooks(List<Book> books) {
        logger.info("Adding new books: {}", books);
        return repository.saveAll(books);
    }

    @Cacheable("books")
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

//    public Book getBookById(Integer id) {
//        return repository.findById(id).orElseThrow(()-> new BookNotFoundException(
//                "Book not found with id " + id));
//    }

     public Book getBookById(Integer id) {
         logger.info("Getting book with id: {}", id);
         Book book = repository.findById(id).orElse(null);
         if (book == null) {
             logger.warn("Book not found with id: {}", id);
             throw new BookNotFoundException("Book not found with id: " + id);
         }
         return book;
     }

     @CacheEvict(value = "books", allEntries = true)
    public Book updateBook(int id,Book updateBook) {
        logger.info("Updating book with id: {}", id);
        Book existingBook = repository.findById(id).orElse(null);
        if (existingBook == null) {
            return null;
        }
        existingBook.setTitle(updateBook.getTitle());
        existingBook.setAuthor(updateBook.getAuthor());
        logger.info("Book updated successfully with id: {}", id);
         return repository.save(existingBook);
    }

     @CacheEvict(value = "books", allEntries = true)
    public String deleteBook(Integer id) {
        logger.info("Deleting book with id: {}", id);
        if (!repository.existsById(id)) {
            logger.warn("Book not found for delete with id: {}", id);
            return "Book not found";
        }
        repository.deleteById(id);
        logger.info("Book deleted successfully with id: {}", id);
        return "Book deleted successfully";
    }

    public List <Book> getBookByTitle(String title) {
        List <Book> books = repository.findByTitle(title);
        if(books.isEmpty()) {
          throw new BookNotFoundException("Book not found with title " + title);
      }
        return books;
    }

    public List <Book> getBookByAuthor(String author) {
        List <Book> books = repository.findByAuthor(author);
        return books;
    }

    public List <Book> searchBooks(String author, String title) {
        List <Book> books = repository.findByAuthorAndTitle(author, title);
        return books;
    }

    public List <Book> searchBook(String keyword, String s) {
        List <Book> books = repository.findByAuthorOrTitle(keyword,keyword);
        return books;
    }

    public List <Book> searchByTitle(String title) {
        List <Book> books = repository.findByTitleContaining(title);
        return books;
    }

    public List <Book> getBooksByAuthor(String author) {
        List <Book> books = repository.getBooksByAuthor(author);
        return books;
    }

    public List <Book> getAllBooksSorted(String field) {
        List <Book> books = repository.findAll(Sort.by(field));
        return books;
    }

    public List<Book> getBooksDescending(String field) {
        List <Book> books = repository.findAll(Sort.by(field).descending());
        return books;
    }

    @Autowired
    private ModelMapper modelMapper;

    public BookDto getBookDtoById(Integer id) {
        Book book = repository.findById(id).orElseThrow(()-> new BookNotFoundException(
                "Book not found with id "));
        BookDto Dto = modelMapper.map(book,BookDto.class);
        return Dto;
    }

     public BookDto addBook(BookDto dto) {
         Book book = modelMapper.map(dto, Book.class);
         Book savedBook = repository.save(book);
         return new BookDto(
                 savedBook.getTitle(),
                 savedBook.getAuthor()
         );
     }

 }