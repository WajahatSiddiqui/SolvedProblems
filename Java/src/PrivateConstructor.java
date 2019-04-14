/**
 * Class Check how private constructors can be accessed
 * Created by wajahat
 */
public class PrivateConstructor {

    static class A {
        private int a;
        private A() {

        }
    }

    static class B {
        public B() {
            A a = new A();
        }
    }

    public static void main(String args[]) {
        A a1 = new A();

        A a2 = new A();
    }
}
