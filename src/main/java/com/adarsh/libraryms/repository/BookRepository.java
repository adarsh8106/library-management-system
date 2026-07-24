package com.adarsh.libraryms.repository;

import com.adarsh.libraryms.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM Book b WHERE b.author = :author")
    List<Book> getBooksByAuthor(@Param("author") String author);

     List<Book> findByTitle(String title);
     List<Book> findByAuthor(String author);
     List<Book> findByAuthorAndTitle(String author, String title);
    List<Book> findByAuthorOrTitle(String author, String title);
    List<Book> findByTitleContaining(String title);

    }

