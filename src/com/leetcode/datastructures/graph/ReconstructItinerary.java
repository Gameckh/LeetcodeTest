package com.leetcode.datastructures.graph;

import java.util.*;

public class ReconstructItinerary {

    /*
    * https://leetcode.com/problems/reconstruct-itinerary/
    *
    * 思路：
    * */

    public static void main(String[] args) {
        String[][] tickets = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
        List<List<String>> listTickets = new ArrayList<>();
        for (String[] strings : tickets) {
            List<String> ticket = new ArrayList<>();
            ticket.add(strings[0]);
            ticket.add(strings[1]);
            listTickets.add(ticket);
        }
        findItinerary(listTickets);
        System.out.println(res);
    }

    static Map<String, PriorityQueue<String>> map = new HashMap<>();
    static List<String> res = new ArrayList<>();

    public static List<String> findItinerary(List<List<String>> tickets) {
        buildMap(tickets);
        dfs("JFK");
        return res;
    }

    static void dfs(String node) {
        PriorityQueue<String> clone = map.get(node);
        while (clone != null && !clone.isEmpty()) {
            dfs(clone.poll());
        }
        res.add(0, node);
    }

    static void buildMap(List<List<String>> tickets) {
        for (List<String> list: tickets){
            PriorityQueue<String> val = map.getOrDefault(list.get(0), new PriorityQueue<>());
            val.add(list.get(1));
            map.put(list.get(0), val);
        }
    }
}
