package vn.plantpal.mobile_backend.dtos.feedback;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SendFeedbackDTO {
    private String content;
}
