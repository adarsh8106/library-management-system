package com.adarsh.libraryms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adarsh.libraryms.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
