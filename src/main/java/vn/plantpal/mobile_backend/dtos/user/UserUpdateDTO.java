package vn.plantpal.mobile_backend.dtos.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateDTO {
    @NotBlank(message = "Full name cannot be blank")
    private String fullName;
    private String email;
    @NotBlank(message = "Phone cannot be blank")
    private String phone;
    @NotNull(message = "Gender cannot null")
    private Boolean gender;
    private String avatar;
    private Date dob;
    private String address;
}
