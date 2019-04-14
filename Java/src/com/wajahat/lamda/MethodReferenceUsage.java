package com.wajahat.lamda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceUsage {
    private static String prefix = "MR. ";
    public static void main(String[] args) {
        lambdaExpressions();
        methodReference();
        sortUsage();
    }

    private static void lambdaExpressions() {
        System.out.println("Lambda Expressions");
        System.out.println(process1("Hello World", str->str.toLowerCase()));
        System.out.println(process2("Hello World", 5, (str, i)->str.substring(0, i)));
        System.out.println(process1("Hello World", str->String.valueOf(3)));
        System.out.println(process1("Hello World", str->prefix.concat(str)));
    }

    private static void methodReference() {
        System.out.println("Method References");
        System.out.println(process1("Hello World", String::toLowerCase));
        System.out.println(process2("Hello World", 5, String::substring));
        System.out.println(process1("3", String::valueOf));
        System.out.println(process1("Hello World", prefix::concat));
    }

    private static String process1(String str, Function<String, String> processor) {
        return processor.apply(str);
    }

    private static String process2(String str, int i, BiFunction<String, Integer, String> processor) {
        return processor.apply(str, i);
    }

    private static void sortUsage() {
        String[] names1 = {"Dr. Wajahat", "Ms. Lorence", "Mr. Ali"};
        System.out.println("Strings: " + Arrays.toString(names1));
        Arrays.sort(names1, new Comparator<String>() {
            @Override
            public int compare(String name1, String name2) {
                System.out.println(name1 + name2);
                return name1.split(" ")[1].compareTo(name2.split(" ")[1]);
            }
        });

        System.out.println("Sorted Strings: " + Arrays.toString(names1));

        String[] names2 = {"Dr. Wajahat", "Ms. Lorence", "Mr. Ali"};
        System.out.println("Strings: " + Arrays.toString(names2));
        Arrays.sort(names2, (name1, name2) -> name1.split(" ")[1].compareTo(name2.split(" ")[1]));
        System.out.println("Sorted Strings using lambda: " + Arrays.toString(names2));

        String[] names3 = {"Dr. Wajahat", "Ms. Lorence", "Mr. Ali"};
        System.out.println("Strings: " + Arrays.toString(names3));
        Arrays.sort(names3, Comparator.comparing(name->name.split(" ")[1]));
        System.out.println("Sorted Strings using comparing: " + Arrays.toString(names3));

        String[] names4 = {"Dr. Wajahat", "Ms. Lorence", "Mr. Ali"};
        System.out.println("Strings: " + Arrays.toString(names4));
        Arrays.sort(names4, Comparator.comparing(MethodReferenceUsage::firstName));
        System.out.println("Sorted Strings using Method Reference: " + Arrays.toString(names4));

        String[] names5 = {"Dr. Wajahat", "Ms. Lorence", "Mr. Ali"};
        System.out.println("Strings: " + Arrays.toString(names5));
        Arrays.sort(names5, Comparator.comparing(MethodReferenceUsage::firstName).reversed());
        System.out.println("Sorted Strings using Method Reference with reverse: " + Arrays.toString(names5));

        String[] names6 = {"Dr. Wajahat", "Ms. Lorence", "Mr. Ali"};
        System.out.println("Strings: " + Arrays.toString(names6));
        Arrays.sort(names6, Comparator.comparing(MethodReferenceUsage::firstName).reversed().thenComparing(MethodReferenceUsage::title));
        System.out.println("Sorted Strings using Method Reference with reverse and then with title: " + Arrays.toString(names6));
    }

    private static String title(String name) {
        return name.split(" ")[0];
    }

    private static String firstName(String name) {
        return name.split(" ")[1];
    }
}
