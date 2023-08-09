package vn.plantpal.mobile_backend.services;

import jakarta.mail.MessagingException;

public interface EmailSenderService {
    void sendEmail(String toEmail,
                   String subject,
                   String body);
    void sendEmailWithAttachment(String toEmail,
                                 String subject,
                                 String body,String pathToFile) throws MessagingException;
}
