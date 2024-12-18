package org.besant.stream;

import java.util.Arrays;
import java.util.List;

public class findSum {
    public static void findSum(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }

    public static void main(String[] args) {
        findSum();
    }
}
