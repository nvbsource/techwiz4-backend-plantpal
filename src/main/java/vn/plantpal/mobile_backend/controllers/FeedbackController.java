package vn.plantpal.mobile_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.AuthUserDTO;
import vn.plantpal.mobile_backend.dtos.feedback.FeedbackBaseDTO;
import vn.plantpal.mobile_backend.dtos.feedback.SendFeedbackDTO;
import vn.plantpal.mobile_backend.securities.CustomUserDetails.CustomUserDetails;
import vn.plantpal.mobile_backend.services.feedback.FeedbackService;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<FeedbackBaseDTO> sendFeedback(@RequestBody SendFeedbackDTO feedback, Authentication authentication) {
        AuthUserDTO user = ((CustomUserDetails) authentication.getPrincipal()).getAuthUser();
        FeedbackBaseDTO feedbackResponse = feedbackService.sendFeedback(feedback, user.getUserID());
        return new ResponseEntity<>(feedbackResponse, HttpStatus.OK);
    }

    @GetMapping("/allFeedbackByUser")
    public ResponseEntity<List<FeedbackBaseDTO>> findAllFeedbackByUser(Authentication authentication) {
        AuthUserDTO user = ((CustomUserDetails) authentication.getPrincipal()).getAuthUser();
        List<FeedbackBaseDTO> feedbacks = feedbackService.findAllFeedbackByUser(user.getUserID());
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @GetMapping("/getAllFeedback")
    public ResponseEntity<List<FeedbackBaseDTO>> findAllFeedback() {
        List<FeedbackBaseDTO> feedbacks = feedbackService.findAllFeedback();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedbackById(@PathVariable String id) {
        feedbackService.deleteFeedbackById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStatus(@RequestParam boolean status, @PathVariable String id) {
        feedbackService.updateStatus(status, id);
        return new ResponseEntity<>("Update success", HttpStatus.OK);
    }
}