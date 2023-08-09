package vn.plantpal.mobile_backend.services.OusideService;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SendSms {
    @Value("${sms.twilio.accounnt-sid}")
    private String ACCOUNT_SID;
    @Value("${sms.twilio.auth-token}")
    private String AUTH_TOKEN;
    @Value("${sms.twilio.phone-seeder}")
    private String PHONE_SEEDER;

    public void sendSms(String phoneNumber, String message) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message.creator(
                        new com.twilio.type.PhoneNumber(phoneNumber),
                        new com.twilio.type.PhoneNumber(PHONE_SEEDER),
                        message)
                .create();
    }
}
