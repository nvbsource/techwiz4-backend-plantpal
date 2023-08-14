package vn.plantpal.mobile_backend.services.feedback;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.feedback.FeedbackBaseDTO;
import vn.plantpal.mobile_backend.dtos.feedback.FeedbackBaseMasterDTO;
import vn.plantpal.mobile_backend.dtos.feedback.SendFeedbackDTO;
import vn.plantpal.mobile_backend.entities.Feedback;
import vn.plantpal.mobile_backend.entities.Users;
import vn.plantpal.mobile_backend.exceptions.DuplicateRecordException;
import vn.plantpal.mobile_backend.exceptions.ResourceNotFoundException;
import vn.plantpal.mobile_backend.exceptions.UserNotFoundException;
import vn.plantpal.mobile_backend.repositories.FeedbackRepository;
import vn.plantpal.mobile_backend.repositories.UserRepository;
import vn.plantpal.mobile_backend.utils.EntityMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImp implements FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EntityMapper entityMapper;
    @Override
    public FeedbackBaseDTO sendFeedback(SendFeedbackDTO feedback, String userId) {
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfDay = LocalDate.now().atTime(23, 59, 59);
        int feedbackToday = feedbackRepository.countByUserIdAndCreatedAtBetween(userId, startOfDay, endOfDay);
        if(feedbackRepository.existsByUser_IdAndContentIgnoreCase(userId, feedback.getContent())) {
            throw new DuplicateRecordException("You have already sent this feedback");
        }
        if(feedbackToday >= 5){
            throw new RuntimeException("You have already sent 5 feedback today");
        }
        Users user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));

        Feedback feedbackNew = modelMapper.map(feedback, Feedback.class);
        feedbackNew.setUser(user);
        feedbackNew.setStatus(false);
        feedbackRepository.save(feedbackNew);
        return modelMapper.map(feedbackNew, FeedbackBaseDTO.class);
    }

    @Override
    public List<FeedbackBaseDTO> findAllFeedbackByUser(String userId) {
        return entityMapper.mapList(feedbackRepository.findAllByUserId(userId), FeedbackBaseDTO.class);
    }

    @Override
    public List<FeedbackBaseMasterDTO> findAllFeedback() {
        return entityMapper.mapList(feedbackRepository.findAll(), FeedbackBaseMasterDTO.class);
    }

    @Override
    public FeedbackBaseDTO findFeedbackById(String id) {
        Optional<Feedback> feedback = feedbackRepository.findById(id);
        if(!feedback.isPresent()){
            throw new ResourceNotFoundException("Feedback not found");
        }
        return modelMapper.map(feedbackRepository.findById(id).get(), FeedbackBaseDTO.class);
    }

    @Override
    public void deleteFeedbackById(String id) {
        Optional<Feedback> feedback = feedbackRepository.findById(id);
        if(!feedback.isPresent()){
            throw new ResourceNotFoundException("Feedback not found");
        }
        feedbackRepository.delete(feedback.get());
    }

    @Override
    public void updateStatus(boolean status, String id) {
        Optional<Feedback> feedback = feedbackRepository.findById(id);
        if(!feedback.isPresent()){
            throw new ResourceNotFoundException("Feedback not found");
        }
        Feedback feedbackGet = feedback.get();
        feedbackGet.setStatus(status);
        feedbackRepository.save(feedbackGet);
    }
}
