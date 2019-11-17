package com.deezboiz.blackjack;

import java.util.HashMap;

public class Rank {

    private static HashMap<Integer, RankInfo> rankMapping = new HashMap<>();
    static {
        rankMapping.put(1, new RankInfo("Ace", new int[]{1, 11}));
        rankMapping.put(2, new RankInfo("Two", new int[]{2}));
        rankMapping.put(3, new RankInfo("Three", new int[]{3}));
        rankMapping.put(4, new RankInfo("Four", new int[]{4}));
        rankMapping.put(5, new RankInfo("Five", new int[]{5}));
        rankMapping.put(6, new RankInfo("Six", new int[]{6}));
        rankMapping.put(7, new RankInfo("Seven", new int[]{7}));
        rankMapping.put(8, new RankInfo("Eight", new int[]{8}));
        rankMapping.put(9, new RankInfo("Nine", new int[]{9}));
        rankMapping.put(10, new RankInfo("Ten", new int[]{10}));
        rankMapping.put(11, new RankInfo("Jack", new int[]{10}));
        rankMapping.put(12, new RankInfo("Queen", new int[]{10}));
        rankMapping.put(13, new RankInfo("King", new int[]{10}));

    }

    private String name;
    private int[] values;

    public Rank(int index){
        name = rankMapping.get(index).getName();
        values = rankMapping.get(index).getValues();
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isSingleValued(){
        return values.length == 1;
    }
}
