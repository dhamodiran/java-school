package com.dhamo.eight.collections;


import java.util.*;
public class MapExample01 {

// create method for map creation and print
    public void createMapAndPrint(Map<Integer, String> map) {
        // add values to the map
        map.put(2, "one");
        map.put(1, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        // print the map using stream
        map.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
        System.out.println("*".repeat(25));
    }

}
