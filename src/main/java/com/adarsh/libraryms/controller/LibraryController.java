package com.adarsh.libraryms.controller;

import com.adarsh.libraryms.config.LibraryProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    @Autowired
    private LibraryProperties libraryProperties;

    @GetMapping("/library/details")
    public LibraryProperties getDetails() {
        return libraryProperties;
    }
}