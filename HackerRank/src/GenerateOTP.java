import java.util.Random;


public class GenerateOTP {

    private static int randomInt(int min, int max) {
        return new Random().ints(min, (max + 1)).limit(1).findFirst().getAsInt();
    }

    private static String generateOTP(int n) {
        String str = "abcdefghijklmnopqrstuvwxyzABCD" +
                "EFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sb = new StringBuffer();
        int len = str.length();
        for (int i = 1; i <= n; i++) {
            sb.append(str.charAt(randomInt(1, len) % len));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(generateOTP(6));
    }

}
