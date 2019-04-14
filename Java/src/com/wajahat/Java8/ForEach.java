package com.wajahat.Java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ForEach {
    private static List<String> teamMembers = Arrays.asList("ramana", "santosh", "wajahat", "esha", "keerthana");

    @Test
    public void testJava7() {
        for(String s : teamMembers) {
            if (s.startsWith("san"))
            System.out.println(s);
        }
    }

    public void print(Predicate<String> str) {
        teamMembers.stream().filter(str).collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void testJava8() {
        teamMembers.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        print(s -> s.endsWith("ana"));
    }
}
