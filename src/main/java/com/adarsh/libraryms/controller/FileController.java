package com.adarsh.libraryms.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileController {

    private static final String UPLOAD_DIR =
            System.getProperty("user.dir") + File.separator +
                    "uploads" + File.separator +
                    "images";

@PostMapping("/upload")
public String uploadFile(@RequestParam("file") MultipartFile file)
        throws IOException {

    if (file.isEmpty()) {
        return "Please select a file.";
    }

    String fileName = file.getOriginalFilename();

    if (!(fileName.endsWith(".jpg")
            || fileName.endsWith(".jpeg")
            || fileName.endsWith(".png")
            || fileName.endsWith(".pdf"))) {

        return "Only JPG, JPEG, PNG and PDF files are allowed.";
    }

    File directory = new File(UPLOAD_DIR);

    if (!directory.exists()) {
        directory.mkdirs();
    }

    File destination = new File(directory, file.getOriginalFilename());

    file.transferTo(destination);

    return "File uploaded successfully!"+ destination.getAbsolutePath();
  }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName)
            throws MalformedURLException {

        Path path = Paths.get(UPLOAD_DIR).resolve(fileName);

        Resource resource = new UrlResource(path.toUri());

        if (!resource.exists() || !resource.isReadable()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}