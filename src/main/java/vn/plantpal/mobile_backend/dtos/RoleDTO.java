package vn.plantpal.mobile_backend.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private String id;
    private String roleType;
}
