package vn.plantpal.mobile_backend.configs.AmazonS3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
@AllArgsConstructor
public class AmazonS3Response {
    private boolean success;
    private String message;
    private String key;
    private URL url;
}