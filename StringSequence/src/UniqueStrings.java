import java.util.HashSet;
import java.util.Set;

// Created by Wajahat
public class UniqueStrings {

    // assuming string length never exceeds 128 chars
    private static boolean isUnique(String str) {
        if (str.length() > 128) return false;
        boolean []visited = new boolean[128];
        // assuming lower case letters only
        for (char c : str.toCharArray()) {
            if (visited[c]) return false;
            visited[c] = true;
        }
        return true;
    }

    // For any encoding
    private static boolean isUniqueAny(String str) {
        Set<Character> set = new HashSet<>(str.length());
        for (char c : str.toCharArray()) {
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }
    public static void main(String args[]) {
        String str = "abe";
        System.out.println(isUnique(str));
        str = "12345-;./[";
        System.out.println(isUniqueAny(str));
    }
}
