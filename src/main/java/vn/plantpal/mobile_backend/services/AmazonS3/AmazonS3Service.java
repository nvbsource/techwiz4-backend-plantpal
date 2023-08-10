package vn.plantpal.mobile_backend.services.AmazonS3;

import org.springframework.web.multipart.MultipartFile;
import vn.plantpal.mobile_backend.configs.AmazonS3.AmazonS3Response;

import java.io.IOException;

public interface AmazonS3Service {
    public AmazonS3Response uploadFile(MultipartFile file) throws IOException;
}
