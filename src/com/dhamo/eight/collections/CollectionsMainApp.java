package com.dhamo.eight.collections;

import java.util.HashMap;
import java.util.Map;

public class CollectionsMainApp {

    public static void main(String[] args) {
        System.out.println("Map Examples!");
        MapExample01 mapExample01 = new MapExample01();
        Map<Integer,String> map = new HashMap<>();
        mapExample01.createMapAndPrint(map);

        Map<Key,String> map1 = new HashMap<>();
         Key key1 = new Key("k1");
         Key key2 = new Key("k2");
         Key key3 = new Key("k3");

        map1.put(key1,"V01");
        map1.put(key2,"V02");
        map1.put(key3,"V03");
        System.out.println("Map1: "+map1);
        System.out.println("map1.get(k1) : "+map1.get(key1));
        System.out.println("map1.get(k2) : "+map1.get(key2));
        System.out.println("map1.get(k3) : "+map1.get(key3));
        System.out.println("*".repeat(25));

        System.out.println("key1.hashCode() : "+key1.hashCode());
        System.out.println("key2.hashCode() : "+key2.hashCode());
        System.out.println("key3.hashCode() : "+key3.hashCode());
        System.out.println("*".repeat(25));
        //key1.setKey("k5");
        key2.setKey("k1");
       key3.setKey("k2");
        System.out.println("Map1: "+map1);
        System.out.println("key1.hashCode() : "+key1.hashCode());
        System.out.println("key2.hashCode() : "+key2.hashCode());
        System.out.println("key3.hashCode() : "+key3.hashCode());
        System.out.println("*".repeat(25));

        System.out.println("map1.get(k1) : "+map1.get(key1));
        System.out.println("map1.get(k2) : "+map1.get(key2));
        System.out.println("map1.get(k3) : "+map1.get(key3));
        System.out.println("*".repeat(25));

        map1.forEach((k,v)-> System.out.println("Key: "+k+" Value: "+v));

    }


}
