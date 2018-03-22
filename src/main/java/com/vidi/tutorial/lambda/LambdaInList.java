package com.vidi.tutorial.lambda;

import java.util.*;

/**
 * This demo just show the form to use lambda.
 */
public class LambdaInList {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("peter", "anna", "mike", "xenia");

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        // 3 different way to write the same function using the lambda as the before code block.
        list.sort((String a, String b) -> {
            return b.compareTo(a);
        });
        list.sort((String a, String b) -> b.compareTo(a));
        list.sort((a, b) -> b.compareTo(a));

        System.out.println(list);

        list.sort(Collections.reverseOrder());
        System.out.println(list);

        List<String> list1 = Arrays.asList("peter", null, "anna", "mike", "xenia");
        list.sort(Comparator.nullsLast(String::compareTo));
        System.out.println(list);

    }
}
