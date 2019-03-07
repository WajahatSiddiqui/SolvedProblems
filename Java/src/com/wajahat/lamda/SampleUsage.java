package com.wajahat.lamda;

public class SampleUsage {

    public static void main(String[] args) {
        System.out.println(process("Hello World", new Processor() {

            @Override
            public String process(String str) {
                return str.toUpperCase();
            }
        }));
    }

    private static String process(String str, Processor processor) {
        return processor.process(str);
    }
}
