package com.adarsh.libraryms.service;

import com.adarsh.libraryms.entity.Book;
import com.adarsh.libraryms.entity.BorrowRecord;
import com.adarsh.libraryms.entity.User;
import com.adarsh.libraryms.enums.BorrowStatus;
import com.adarsh.libraryms.exception.BookAlreadyReturnedException;
import com.adarsh.libraryms.exception.BookNotFoundException;
import com.adarsh.libraryms.exception.UserNotFoundException;
import com.adarsh.libraryms.repository.BookRepository;
import com.adarsh.libraryms.repository.BorrowRepository;
import com.adarsh.libraryms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    // Borrow a book
    @Transactional
    public BorrowRecord borrowBook(Integer userId, Integer bookId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new BookNotFoundException("Book not found"));

        if (!book.getAvailable()) {
            throw new RuntimeException("Book is already borrowed");
        }

        BorrowRecord record = new BorrowRecord();

        record.setUser(user);
        record.setBook(book);
        record.setBorrowDate(LocalDate.now());
        record.setStatus(BorrowStatus.BORROWED);

        book.setAvailable(false);

        bookRepository.save(book);

        return borrowRepository.save(record);
    }

    // Get all borrow records
    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRepository.findAll();
    }

    // Get borrow record by id
    public BorrowRecord getBorrowRecordById(Integer id) {
        return borrowRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Borrow record not found"));
    }

    @Transactional
    public BorrowRecord returnBook(Integer borrowId) {

        BorrowRecord record = borrowRepository.findById(borrowId)
                .orElseThrow(() ->
                        new RuntimeException("Borrow record not found"));

        // Check if the book is already returned
        if (record.getStatus() == BorrowStatus.BORROWED) {
            throw new BookAlreadyReturnedException("Book is already returned");
        }

        Book book = record.getBook();

        record.setReturnDate(LocalDate.now());

        record.setStatus(BorrowStatus.RETURNED);

        book.setAvailable(true);

        bookRepository.save(book);

        return borrowRepository.save(record);
    }

}