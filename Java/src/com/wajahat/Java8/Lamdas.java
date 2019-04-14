package com.wajahat.Java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lamdas {

    private static class Emp {
        String name;
        String designation;
        Emp(String name, String designation) {
            this.name = name;
            this.designation = designation;
        }

        @Override
        public String toString() {
            return "name: " + name + " " + "design: " + designation;
        }
    }

    List<Emp> list = new ArrayList<>();

    public List<Emp> getByDesign(Predicate<Emp> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    @Test
    public void test() {
        list.add(new Emp("Ramana", "Manager"));
        list.add(new Emp("Santosh", "StaffEngr"));
        list.add(new Emp("Wajahat", "StaffEngr"));

        getByDesign(d->d.designation.equals("StaffEngr")).forEach(System.out::println);
    }
}
