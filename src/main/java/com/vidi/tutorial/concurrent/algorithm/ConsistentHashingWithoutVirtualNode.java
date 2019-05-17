package com.vidi.tutorial.concurrent.algorithm;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author vidi
 */
public class ConsistentHashingWithoutVirtualNode {
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"};
    private static SortedMap<Integer, String> sortedMap = new TreeMap<>();

    static {
        for (String server : servers) {
            int hash = getHash(server);
            sortedMap.put(hash, server);
        }
    }

    /**
     * FNV1_32_HASH
     */
    static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;

        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    private static String getServer(String node) {
        int hash = getHash(node);
        SortedMap<Integer, String> subMap =
                sortedMap.tailMap(hash);
        Integer i = subMap.firstKey();
        return subMap.get(i);
    }

    public static void main(String[] args) {
        String[] nodes = {"127.0.0.1:1111", "221.226.0.1:2222", "10.211.0.1:3333"};
        for (String node : nodes) {
            System.out.println("[" + node + "]的hash值为" + getHash(node));
            System.out.println("[" + node + "]的hash值为" + getHash(node) + ", 被路由到结点[" + getServer(node) + "]");
        }
    }
}
