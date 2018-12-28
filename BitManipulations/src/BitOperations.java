/**
 * Class Common bit operations
 * Created by wajahat
 */
public class BitOperations {

    private static int setBit(int num, int i) {
        return num | (1 << i);
    }

    private static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    private static int clearBit(int num, int i) {
        return num & (~(1 << i));
    }

    private static int clearBitMSBThroughI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    private static int clearBitIThrough0(int num, int i) {
        int mask = (-1 << (i+1));
        return num & mask;
    }

    private static int repeatedArithmeticShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>= 1;
        }
        return x;
    }

    private static int updateBit(int num, int i, boolean bitIs1) {
        int val = bitIs1 ? 1 : 0;
        int mask = ~(1 << i);
        return num & mask | val << i;
    }

    private static int repeatedLogicalShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>>= 1;
        }
        return x;
    }

    public static void main(String args[]) {
        int num = 7;
        System.out.println(setBit(num, 3));
        System.out.println(getBit(num, 0));
        System.out.println(clearBit(num, 2));
        System.out.println(clearBitMSBThroughI(num, 2));
        System.out.println(clearBitIThrough0(num, 1));
        System.out.println(updateBit(num, 3, true));


        // arithmetic right shift
        int val = -75 >> 1; // divides by 2 retaining the sign
        System.out.println(val);

        // logical right shift
        int v = -75 >>> 1;
        System.out.println(v);

        System.out.println(repeatedArithmeticShift(-93242, 100));
        System.out.println(repeatedLogicalShift(-93242, 100));

        System.out.println("Size of byte: " + Byte.SIZE/8 + " bytes");
        System.out.println("Size of short: " + Short.SIZE/8 + " bytes");
        System.out.println("Size of character: " + Character.SIZE/8 + " bytes");
        System.out.println("Size of int: " + Integer.SIZE/8 + " bytes");
        System.out.println("Size of float: " + Float.SIZE/8 + " bytes");
        System.out.println("Size of long: " + Long.SIZE/8 + " bytes");
        System.out.println("Size of Double: " + Double.SIZE/8 + " bytes");

    }
}
