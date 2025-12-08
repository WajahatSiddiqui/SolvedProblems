package com.wajahat.linkedin;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SolveArray {
    static int findLargest(int []numbers) {
        return Arrays.stream(numbers).max().getAsInt();
    }

    static void printGreeting(Optional<String> name) {
        System.out.println("Hi " + name.orElse(""));
    }

    public static void main(String args[]) {
        int [] test = {1,2,3,4,5};

        System.out.println("Max value from array = " + findLargest(test));

        Optional<String> emptyOpt = Optional.empty();
        Optional<String> nameOpt = Optional.of("Wajahat");

        printGreeting(nameOpt);
        printGreeting(emptyOpt);

        List<String> students = Arrays.asList("Sally", "Molly", "Polly" ,"dolly");

        //students.forEach(n->System.out.println(n));

        // Consumer
        Consumer<String> print = n->System.out.println(n);
        students.forEach(print);

        // Function
        Function<Integer, Integer> doubly = n -> n*n;
        System.out.println(doubly.apply(7));

        // Predicate
        IntPredicate isDivByThree = n -> n % 3 == 0;
        System.out.println(isDivByThree.test(3));

        // Supplier
        Supplier<Double> randomNumUnder100 = () -> Math.random() * 100;
        System.out.println(randomNumUnder100.get());

        students.forEach(System.out::println);

        students.parallelStream().forEach(System.out::println);

        System.out.println("Molly exists " + students.stream().anyMatch(n->n.contains("Molly")));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        numbers.forEach(n->System.out.println("Double of (" + n + ") = " + n*n));

        List<String> animals = Arrays.asList("   fish  ", "cat   ", "HORSE  ", "    ");
        List<String> normalizedStringList = animals.stream()
                                                    .map(n -> n.trim().toLowerCase())
                                                    .filter(n -> !n.isEmpty())
                                                    .collect(Collectors.toList());

        normalizedStringList.forEach(System.out::println);
    }
}
