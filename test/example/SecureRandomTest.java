package example;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class SecureRandomTest {
    public static void main(String[] args){
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            sr = new SecureRandom();
        }
        byte[] buffer = new byte[16];
        sr.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));
    }
}
