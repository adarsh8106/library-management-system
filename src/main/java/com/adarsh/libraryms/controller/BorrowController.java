package com.adarsh.libraryms.controller;

import com.adarsh.libraryms.entity.BorrowRecord;
import com.adarsh.libraryms.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowService service;

    // Borrow a book
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public BorrowRecord borrowBook(@RequestParam Integer userId,
                                   @RequestParam Integer bookId) {

        return service.borrowBook(userId, bookId);
    }

    // Get all borrow records
    @GetMapping
    public List<BorrowRecord> getAllBorrowRecords() {
        return service.getAllBorrowRecords();
    }

    // Get borrow record by id
    @GetMapping("/{id}")
    public BorrowRecord getBorrowRecordById(@PathVariable Integer id) {
        return service.getBorrowRecordById(id);
    }

    // return a book
    @PutMapping("/return/{borrowId}")
    @PreAuthorize("hasRole('USER')")
    public BorrowRecord returnBook(@PathVariable Integer borrowId){
        return service.returnBook(borrowId);
    }

}