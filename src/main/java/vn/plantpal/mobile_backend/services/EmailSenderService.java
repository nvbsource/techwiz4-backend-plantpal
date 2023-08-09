package vn.plantpal.mobile_backend.services;

import jakarta.mail.MessagingException;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface EmailSenderService {
    public CompletableFuture<Boolean> sendEmail(String to, String subject, String templateName, Map<String, String> listVar);
}
