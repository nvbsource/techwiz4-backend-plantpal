package vn.plantpal.mobile_backend.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    @NotEmpty(message = "Email is required")
    @Email
    private String email;
    @NotEmpty(message = "Password is required")
    private String password;
    @NotEmpty(message = "Password is required")
    private String fullName;
    @NotEmpty(message = "Username is required")
    private String username;
    @NotEmpty(message = "Gender is required")
    private String gender;
    @NotEmpty(message = "Phone is required")
    private String phone;
    @DateTimeFormat
    private Date dob;
    @NotEmpty(message = "Address is required")
    private String address;
    private String avatar;

}
