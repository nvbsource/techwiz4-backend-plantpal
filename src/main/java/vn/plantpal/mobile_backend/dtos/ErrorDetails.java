package vn.plantpal.mobile_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private Date date;
    private String message;
    private HttpStatusCode status;
    private int statusCode;
    private Map<String, ?> errors;

    public ErrorDetails(Date date, String message, HttpStatusCode status) {
        this.date = date;
        this.message = message;
        this.status = status;
        this.statusCode = status.value();
    }

    public ErrorDetails(Date date, Map<String, ?> errors, HttpStatusCode status) {
        this.date = date;
        this.errors = errors;
        this.status = status;
        this.statusCode = status.value();
    }

    public ErrorDetails(Date date, String message, Map<String, ?> errors, HttpStatusCode status) {
        this.date = date;
        this.message = message;
        this.errors = errors;
        this.status = status;
        this.statusCode = status.value();
    }
}