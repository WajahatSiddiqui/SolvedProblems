
// Created by Wajahat
public class RealBinary {
    private static final String ERROR = "ERROR";

    private static String convert(Double real) {
        if (real >= 1 || real <= 0) return ERROR;
        StringBuffer binary = new StringBuffer();
        binary.append(".");
        while (real > 0) {
            if (binary.length() >= 32) return ERROR;
            real = real*2;

            if (real >= 1) {
                binary.append("1");
                real -= 1;
            } else {
                binary.append("0");
            }
        }
        return binary.toString();
    }


    public static void main(String args[]) {
        System.out.println(convert(0.390625));
        System.out.println(convert(0.15628789632453));
    }
}
