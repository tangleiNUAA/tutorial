package com.vidi.tutorial.concurrent.algorithm;

import java.util.*;

/**
 * @author vidi
 */
public class ConsistentHashingWithVirtualNode {
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"};

    /**
     * Real node. Considering adding and deleting node, using {@link LinkedList} is better in this case.
     */
    private static List<String> realNodes = new LinkedList<>();

    /**
     * Virtual nodes in a {@link TreeMap}, which key means hash value of virtual node and value means virtual node name.
     */
    private static SortedMap<Integer, String> virtualNodes = new TreeMap<>();

    /**
     * Count of virtual node.
     */
    private static final int VIRTUAL_NODES = 5;

    static {
        realNodes.addAll(Arrays.asList(servers));
        for (String str : realNodes) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                String virtualNodeName = str + "&&VN" + i;
                int hash = getHash(virtualNodeName);
                virtualNodes.put(hash, virtualNodeName);
            }
        }
    }

    /**
     * FNV1_32_HASH
     *
     * @param str input.
     * @return hash result.
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
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
        Integer i = subMap.firstKey();
        String virtualNode = subMap.get(i);
        return virtualNode.substring(0, virtualNode.indexOf("&&"));
    }

    public static void main(String[] args) {
        String[] nodes = {"127.0.0.1:1111", "221.226.0.1:2222", "10.211.0.1:3333"};
        for (String node : nodes) {
            System.out.println("[" + node + "] hash = " + getHash(node) + ", rote to [" + getServer(node) + "]");
        }
        virtualNodes.forEach((key, value) -> {
            if (380278925 < key) {
                System.out.println(value);
            }
        });
    }
}
