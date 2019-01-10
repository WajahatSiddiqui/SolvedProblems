package classloaders;

import java.util.HashMap;

/**
 * Class Check how class loader works
 * Created by wajahat
 */
public class ClassLoaderTest {
    static HashMap map = new HashMap();
    public static void main(String args[]) {
        System.out.println("Class loader for HashMap: " + java.util.HashMap.class.getClassLoader());
        System.out.println("Class loader for HashMap: " + map.getClass().getClassLoader());
        System.out.println("Class loader for String: " + String.class.getClassLoader());
        System.out.println("Class loader for DNSNameService: " + sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        System.out.println("Class loader for ClassLoaderTest: " + ClassLoaderTest.class.getClassLoader());
    }
}
