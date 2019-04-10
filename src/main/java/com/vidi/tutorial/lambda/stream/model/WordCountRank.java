package com.vidi.tutorial.lambda.stream.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vidi
 */
public class WordCountRank {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("www.oschina.net");
        list.add("www.cnblog.com");
        list.add("www.oschina.net");
        list.add("www.oschina.net");
        list.add("www.oschina.net");
        list.add("www.cnblog.com");
        list.add("www.baidu.com");
        list.add("www.baidu.com");
        list.add("www.baidu.com");
        list.add("www.oschina.net");
        printRange(list, 2);
    }

    /**
     * 降序排列取前 N 个 url 和个数
     * 包含一个 wordcount, 一个 sort, 一个 limit
     *
     * @param urls input urls list
     * @param N top N of the urls.
     */
    private static void printRange(List<String> urls, int N) {
        Map<String, Integer> allCount = urls.stream()
                .map(url -> {
                    Map<String, Integer> map = new HashMap<>();
                    map.put(url, 1);
                    return map;
                }).reduce(new HashMap<>(),
                        (map1, map2) -> {
                            String url2 = new ArrayList<>(map2.keySet()).get(0);
                            if (map1.size() == 0) {
                                map1.putAll(map2);
                            } else if (map1.containsKey(url2)) {
                                map1.put(url2, map1.get(url2) + 1);
                            } else if (!map1.containsKey(url2)) {
                                map1.put(url2, 1);
                            }
                            return map1;
                        });
        allCount.entrySet().stream().sorted((entry1, entry2) -> {
            if (entry1.getValue() > entry2.getValue()) {
                return -1;
            } else if (entry1.getValue().equals(entry2.getValue())) {
                return 0;
            } else {
                return 1;
            }
        }).limit(N).forEach(entry -> System.out.println(entry.getKey() + "   " + entry.getValue()));
    }
}
