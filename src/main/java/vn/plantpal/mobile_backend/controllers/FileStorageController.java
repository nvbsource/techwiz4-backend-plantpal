package vn.plantpal.mobile_backend.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vn.plantpal.mobile_backend.configs.AmazonS3.AmazonS3Response;
import vn.plantpal.mobile_backend.exceptions.BadRequestException;
import vn.plantpal.mobile_backend.services.AmazonS3.AmazonS3Service;

import java.io.IOException;

@RestController
@RequestMapping("/api/file")
public class FileStorageController {
    private static final Logger logger = LoggerFactory.getLogger(FileStorageController.class);
    @Autowired
    private AmazonS3Service amazonS3Service;

    @RequestMapping(value = "/upload" , method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        try {
            // Check file is an image file
            String contentType = multipartFile.getContentType();
            if(contentType == null || !contentType.startsWith("image/")) {
                throw new BadRequestException("Invalid file type. Please upload an image file.");
            }
            AmazonS3Response amazonS3Response = amazonS3Service.uploadFile(multipartFile);
            if (amazonS3Response.isSuccess()) {
                return ResponseEntity.ok().body(amazonS3Response.getUrl().toString());
            }
            throw new BadRequestException(amazonS3Response.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new BadRequestException("File upload failed");
        }
    }
}
