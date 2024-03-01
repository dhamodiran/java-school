package com.ddz.j8features;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapUpgrades {
  
  public static void main(String args[]){
    Map<String , Integer> fruits = new HashMap<>();
    fruits.put("apple", 20);

    // We need to add 20 bananas in map.
    // Below line will throw NullPointerException if banana 
    //is already not present in the map.
    
    //fruits.put("banana", fruits.get("banana") + 20);

    System.out.println(fruits);
    //This is the correct way to update map value before Java 8
    if (fruits.containsKey("banana")) {
      fruits.put("banana", fruits.get("banana") + 20);
    } else {
      fruits.put("banana", 20);
    }
    System.out.println(fruits);

    //Java8
    //getOrDefault
    fruits.put("banana",fruits.getOrDefault("banana",0)+20);

    //putIfAbsent
    fruits.putIfAbsent("Grapes",10);
    fruits.putIfAbsent("Grapes",20); //it will not update if already present
    System.out.println(fruits);

    //compute
    int val = fruits.compute("Grapes",(k,v)->v+10); // updates the value of given value if exisit else null pointer exception
    System.out.println("Value: "+val);
    System.out.println(fruits);

    fruits.computeIfPresent("Grapes",(k,v)->v+10);//updates if present else A null value if the key is not present in the map
    System.out.println(fruits);

    fruits.computeIfAbsent("Grapes1",v->10); //original value if the key is already present in the map else computed value
    System.out.println(fruits);

    Map<Character,Integer> countMap = new HashMap<>();

   // fruits.forEach((k,v)->countMap.putIfAbsent(k,countMap.getOrDefault(k,1)));
   // System.out.println(countMap);

    String str = "Dhaamodiran D";

    //char []c = str.toCharArray();


    List<Character> list = str.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
    //list.forEach(e -> countMap.put(e,countMap.getOrDefault(e,0)+1));
    list.forEach(e -> countMap.put(e, countMap.getOrDefault(e,0)+1));
    System.out.println(countMap);
  }
}