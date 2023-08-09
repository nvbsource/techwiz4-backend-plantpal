package vn.plantpal.mobile_backend.utils;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class GoogleValidator {
    private static final JsonFactory gsonFactory = GsonFactory.getDefaultInstance();

    public GoogleIdToken.Payload validateToken(String tokenId){
        GoogleIdToken.Payload payload = null;
        try {
            final NetHttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, gsonFactory)
                    .setAudience(Collections.singletonList("1013626667939-u0cl17aik3n48fjl1p8q454upl2g60rb.apps.googleusercontent.com"))
                    .build();
            GoogleIdToken idToken = verifier.verify(tokenId);
            if(idToken != null){
                payload = idToken.getPayload();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return payload;
    }
}
