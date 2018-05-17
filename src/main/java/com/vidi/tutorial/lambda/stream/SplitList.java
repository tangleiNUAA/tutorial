package com.vidi.tutorial.lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Split list
 * @author vidi
 */
public class SplitList {
    public static void main(String[] args) {
        List<String> source = new ArrayList<>();
        source.add("a");
        source.add("b");
        source.add("c");
        source.add("e");
        source.add("f");
        source.add("g");
        source.add("h");
        source.add("i");
        source.add("j");
        source.add("k");
        source.add("l");
        source.add("m");
        source.add("n");
        // ...
        System.out.println(source);

        int skipNum = 2;
        int newLength = source.size() / skipNum;
        if (source.size() % skipNum != 0) {
            newLength += 1;
        }
        List<String> result = Stream.iterate(0, n -> n + 1)
                .limit(newLength).parallel()
                .map(a -> source.stream().skip(a * skipNum).findFirst().get())
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
