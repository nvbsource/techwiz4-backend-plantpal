package vn.plantpal.mobile_backend.dtos.feedback;

import lombok.*;
import vn.plantpal.mobile_backend.dtos.UserDTO;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FeedbackBaseMasterDTO {
    private String id;
    private String content;
    private boolean status;
    private UserDTO user;
}
