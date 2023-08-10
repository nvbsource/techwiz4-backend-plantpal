package vn.plantpal.mobile_backend.services.AmazonS3;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.plantpal.mobile_backend.configs.AmazonS3.AmazonS3Config;
import vn.plantpal.mobile_backend.configs.AmazonS3.AmazonS3Response;
import java.net.URL;
import java.util.UUID;
import java.io.IOException;

@Service
public class AmazonS3ServiceImp implements AmazonS3Service {
    @Autowired
    private AmazonS3 amazonS3;
    @Autowired
    private AmazonS3Config amazonS3Config;
    @Override
    public AmazonS3Response uploadFile(MultipartFile file) throws IOException {
        String key = UUID.randomUUID() + "-" + file.getOriginalFilename();
        try {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            objectMetadata.setContentLength(file.getSize());

            PutObjectRequest putObjectRequest = new PutObjectRequest(amazonS3Config.getBucketName(), key, file.getInputStream(), objectMetadata);
            PutObjectResult putObjectResult = amazonS3.putObject(putObjectRequest);
            String url = amazonS3.getUrl(amazonS3Config.getBucketName(), key).toString();
            return new AmazonS3Response(true, "Upload success", key, new URL(url));
        } catch (AmazonServiceException ase) {
            return new AmazonS3Response(false, "Upload failed: " + ase.getMessage(), null, null);
        } catch (AmazonClientException ace) {
            return new AmazonS3Response(false, "Upload failed: " + ace.getMessage(), null, null);
        }
    }

}