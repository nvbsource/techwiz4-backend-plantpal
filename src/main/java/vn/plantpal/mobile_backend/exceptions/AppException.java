package vn.plantpal.mobile_backend.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@EqualsAndHashCode(callSuper = true)
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Data
public class AppException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public AppException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }
}
