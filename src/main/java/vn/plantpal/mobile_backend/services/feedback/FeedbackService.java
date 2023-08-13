package vn.plantpal.mobile_backend.services.feedback;

import vn.plantpal.mobile_backend.dtos.feedback.FeedbackBaseDTO;
import vn.plantpal.mobile_backend.dtos.feedback.SendFeedbackDTO;
import vn.plantpal.mobile_backend.entities.Feedback;

import java.util.List;

public interface FeedbackService {
    FeedbackBaseDTO sendFeedback(SendFeedbackDTO feedback, String userId);
    List<FeedbackBaseDTO> findAllFeedbackByUser(String userId);
    List<FeedbackBaseDTO> findAllFeedback();
    FeedbackBaseDTO findFeedbackById(String id);
    void deleteFeedbackById(String id);
    void updateStatus(boolean status, String id);
}
