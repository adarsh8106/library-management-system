package com.adarsh.libraryms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.Flow;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book
  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Title cannot be empty")
    @Size(min = 2, message = "Title must be contain at least 2 characters")
    private String title;

    @NotBlank(message = "Author cannot be empty")
    private String author;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private List<BorrowRecord> borrowRecords;

    @Column(nullable = false)
    private Boolean available = true;

  }

