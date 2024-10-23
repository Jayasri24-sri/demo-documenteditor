package com.example.demo.service;



import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DocumentService {

    @Autowired
    private AmazonS3 amazonS3;

    private final String bucketName = "YOUR_BUCKET_NAME";

    public String uploadDocument(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        amazonS3.putObject(bucketName, fileName, file.getInputStream(), null);
        return fileName;
    }

    public String getDocumentUrl(String fileName) {
        return amazonS3.getUrl(bucketName, fileName).toString();
    }
}

