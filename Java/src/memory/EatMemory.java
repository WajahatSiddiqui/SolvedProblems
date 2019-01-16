package memory;

import java.util.UUID;

/**
 * Class Eating memory of the system
 * Created by wajahat
 */
public class EatMemory {

    public static void main(String args[]) {
        while (true) {
            System.out.println(new String(UUID.randomUUID().toString()));
        }
    }
}
