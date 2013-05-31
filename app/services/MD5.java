package services;

/**
 * Created with IntelliJ IDEA.
 * User: Alina
 * Date: 29.05.13
 * Time: 20:47
 * To change this template use File | Settings | File Templates.
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public static String getHash(String string) {
        MessageDigest md5;
        StringBuilder hexString = new StringBuilder();

        try {
            md5 = MessageDigest.getInstance("md5");

            md5.reset();
            md5.update(string.getBytes());

            byte messageDigest[] = md5.digest();

            for(int i = 0; i < messageDigest.length; i++)
            {
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }
        }catch (NoSuchAlgorithmException e) {
            return  e.toString();
        }

        return  hexString.toString();
    }
}
