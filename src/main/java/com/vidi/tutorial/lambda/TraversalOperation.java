package com.vidi.tutorial.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tanleiNUAA
 */
public class TraversalOperation {
    public static void main(String[] args) {
        // list.forEach()
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(System.out::println);
        // map.forEach()
        System.out.println("map.forEach() function");
        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        map.put("k4", "v4");
        map.put("k5", "v5");
        map.forEach((k, v) -> System.out.println(k + "-" + v));

        // a list of string combine
        String connection = Stream.of("a", "b", "c", "d").reduce("_", String::concat);
        // a list of string combining, with some specific string.
        String connection1 = Stream.of("a", "b", "c", "d").collect(Collectors.joining("_"));
        System.out.println(connection);
        System.out.println(connection1);
    }
}
