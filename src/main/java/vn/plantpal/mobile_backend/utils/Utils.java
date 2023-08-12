package vn.plantpal.mobile_backend.utils;

import java.util.Random;

public class Utils {
    public static String generateCode() {
        int lengthCode = 10;
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(lengthCode);
        for (int i = 0; i < lengthCode; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }
}
