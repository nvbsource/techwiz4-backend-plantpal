package vn.plantpal.mobile_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String fullName;
    private String email;
    private String phone;
    private Boolean gender;
    private String avatar;
    private Date dob;
    private String address;
    private String accountId;
    private Boolean isDeleted;
}
