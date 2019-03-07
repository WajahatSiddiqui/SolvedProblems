package com.wajahat.lamda;

import java.util.function.Function;

public class InbuiltFunctionalInterfaceUsage {
    public static void main(String[] args) {
        System.out.println(process("Hello World", str->str.toLowerCase()));
    }

    private static String process(String str, Function<String, String> processor) {
        return processor.apply(str);
    }

}
