package vn.plantpal.mobile_backend.dtos.feedback;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FeedbackBaseDTO {
    private String id;
    private String content;
    private boolean status;
}
