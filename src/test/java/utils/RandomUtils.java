package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomString(2));
        System.out.println(getRandomInt(2, 500));
        System.out.println(getRandomEmail());

        String[] names = {"a", "b", "c", "d", "e"};
        System.out.println(getRandomItemFromArray(names));
    }

    public static int getRandomInt (int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);

    }

    public static String getRandomEmail() {
        return getRandomString(8) + "@gmail.com";
    }


    public static String getRandomItemFromArray(String [] values) {
        int index = getRandomInt(0, values.length -1);

        return values[index];
    }

    public static String getRandomString(int length) {

        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
            for(int i = 0; i < length; i++)
                sb.append(AB.charAt(rnd.nextInt(AB.length())));
            return sb.toString();
        }

}
