package com.dhamo.eight.collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample02 {

    public static void main(String[] args) {
        System.out.println("HashSet Example 02!");

        Set<Key> set = new HashSet<>();
        Key one = new Key("1");
        Key two = new Key("2");

        set.add(one);
        set.add(two);
        System.out.println("Set: "+set);
        System.out.println("hashcode of one (1): "+one.hashCode());
        one.setKey("3");
        System.out.println("hashcode of one (3): "+one.hashCode());
        System.out.println("Set -3 "+set);
        System.out.println("Set contains one: "+set.contains(one));
        boolean addedOne = set.add(one);
        System.out.println("addedOne: "+addedOne);
        System.out.println("Set: "+set);
    }


}
