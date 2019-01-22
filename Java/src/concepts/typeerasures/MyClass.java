package concepts.typeerasures;

/**
 * Class
 * Created by wajahat
 */
public class MyClass<T extends String> {
    T obj;

    MyClass(T obj) {
        this.obj = obj;
    }

    T getObj() {
        return obj;
    }
}
