package org.besant;

import java.util.Arrays;
import java.util.List;

public class EvenNumbers {

    public static void findEvenNumber() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(list.stream().filter(num -> num % 2 == 0).toList());
    }

    public static void main(String[] args) {
        findEvenNumber();
    }
}
