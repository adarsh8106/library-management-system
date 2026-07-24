package com.adarsh.libraryms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "library")
public class LibraryProperties {

    private String name;
    private int fine;
    private String city;
    private String phone;
    private String email;


}