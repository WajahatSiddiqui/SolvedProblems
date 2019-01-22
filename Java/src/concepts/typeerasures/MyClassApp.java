package concepts.typeerasures;

/**
 * Class use MyClass
 * Created by wajahat
 */
public class MyClassApp {

    public static void main(String args[]) {
        MyClass<String> obj = new MyClass<>("anc");
        System.out.println(obj.getObj());
    }
}
