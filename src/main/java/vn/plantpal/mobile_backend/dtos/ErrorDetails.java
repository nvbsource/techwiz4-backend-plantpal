package vn.plantpal.mobile_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private Date date;
    private String message;
    private String detail;
    private String status;
    private List<String> errors;

    public ErrorDetails(Date date, String message, String detail, String status) {
        this.date = date;
        this.message = message;
        this.detail = detail;
        this.status = status;
    }

    public ErrorDetails(Date date, List<String> errors, String detail, String status) {
        this.date = date;
        this.errors = errors;
        this.detail = detail;
        this.status = status;
    }
}
