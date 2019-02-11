package com.wajahat.immutability;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class
 * Created by wajahat
 */
public class EmployeeApp {

    public static void main(String args[]) {
        Address address = new Address("BLR");
        List<Integer> list = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        Age age = new Age(1, 2, 1987);

        Employee employee = new Employee("anc", address, list, age);

        // before modification
        System.out.println(employee.getAddress());
        System.out.println(employee.getName());
        employee.getList().forEach(System.out::print);
        System.out.println(employee.getAge());


        employee.getAddress().setCity("Chennai");
        employee.getList().add(200);
        employee.getAge().setYear(1993);

        System.out.println();

        // after modification
        System.out.println(employee.getAddress());
        System.out.println(employee.getName());
        employee.getList().forEach(System.out::print);
        System.out.println(employee.getAge());
    }
}
