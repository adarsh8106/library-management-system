package com.adarsh.libraryms.repository;

import com.adarsh.libraryms.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<BorrowRecord, Integer> {

}
