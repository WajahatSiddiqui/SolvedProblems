package com.wajahat.problems;

import java.util.ArrayList;
import java.util.List;

public class TopKElements {
    private static class Element {
        String item;
        Integer value;
        public Element(String item, int value) {
            this.item = item;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "item='" + item + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    private static void printTop(int k, List<Element> elementList) {
        elementList.sort((o1, o2) -> {
            if (o1.value.equals(o2.value)) {
                return o1.item.compareTo(o2.item);
            }
            return o2.value.compareTo(o1.value);
        });

        for (int i = 0; i < k; i++) {
            System.out.println(elementList.get(i));
        }
    }

    public static void main(String args[]) {
        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Bat", 30));
        elementList.add(new Element("Wickets", 40));
        elementList.add(new Element("Ball", 10));
        elementList.add(new Element("Gloves", 15));
        elementList.add(new Element("Helmet", 40));

        printTop(3, elementList);
    }
}
