package vn.plantpal.mobile_backend.services.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Component
public class EmailSenderServiceImpl implements EmailSenderService {
    private static final Logger logger = LoggerFactory.getLogger(EmailSenderServiceImpl.class);
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailSenderServiceImpl(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    @Async
    public CompletableFuture<Boolean> sendEmail(String to, String subject, String templateName, Map<String, String> listVar) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);

            Context emailContext = new Context();
            if (listVar != null) listVar.forEach(emailContext::setVariable);
            String htmlContent = templateEngine.process(templateName, emailContext);

            helper.setText(htmlContent, true);
            mailSender.send(message);
            return CompletableFuture.completedFuture(true);
        } catch (MessagingException e) {
//          logger.error(e.getMessage());
            return CompletableFuture.completedFuture(false);
        }
    }

}
