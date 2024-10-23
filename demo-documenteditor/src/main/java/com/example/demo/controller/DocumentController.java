package com.example.demo.controller;



import com.example.demo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/")
    public String index() {
        return "index"; // return the HTML page
    }

    @PostMapping("/upload")
    @ResponseBody
    public String uploadDocument(@RequestParam("file") MultipartFile file) {
        try {
            return documentService.uploadDocument(file);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error uploading file";
        }
    }

    @GetMapping("/document/{fileName}")
    @ResponseBody
    public String getDocumentUrl(@PathVariable String fileName) {
        return documentService.getDocumentUrl(fileName);
    }
}

