package references;

import org.junit.Test;

/**
 * Class Swap two values inside a variable
 * Created by wajahat
 */
public class Swap {

    public void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    public void swapModified(Integer a, Integer b) {
        Integer tmp = a;
        a = b;
        b = a;
    }

    @Test
    public void testSwap() {
        int a = 10;
        int b = 20;
        System.out.println("a = " + a + " b = " + b);
        swap(a, b);
        System.out.println("a = " + a + " b = " + b);

        Integer i1 = new Integer(1);
        Integer i2 = new Integer(2);
        swapModified(i1, i2);
        System.out.println("a = " + a + " b = " + b);

    }
}
