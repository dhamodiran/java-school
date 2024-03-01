package com.dhamo.eight.stream;

import com.dhamo.eight.beans.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonExample {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Dhamo","Bangalore", "KA"));
        persons.add(new Person(2,"Sujith","Delhi", "DL"));
        persons.add(new Person(3,"Umesh","Bangalore", "KA"));
        persons.add(new Person(4,"Shakthi","Chennai", "TN"));
        persons.add(new Person(5,"Dhamo","Chennai", "TN"));

        var listMap = persons.stream().collect(Collectors.groupingBy(Person::getState,Collectors.groupingBy(Person::getCity)));

        listMap.forEach((k,v) -> {
            System.out.print("State:"+k+"-->");
            v.forEach((k1,v1)->{
                System.out.print("City:"+k1+"-->");
                v1.forEach(e-> System.out.print(e.getName()+","));
            });
            System.out.println("\n---------------------------------");
        });
        String date = "20230101";
        Integer i =202301;
        String res = i+date.substring(6,8);
        System.out.println( "sample:"+res);
        String str1 = "-";
        Map<Character,Integer> map = new HashMap<>();
        persons.forEach(e-> System.out.println(map.put(e.getName().charAt(0),map.getOrDefault(e.getName().charAt(0),0)+1)));
        System.out.println(map);
        System.out.println("------------------------------------------------");
        //Collectors - Grouping 1 - map returns list Persons
        Map<String,List<Person>> grpByState1 = persons.stream().collect(Collectors.groupingBy(Person::getState));
        System.out.println(grpByState1);

        //Collectors - Grouping 2 - map returns list String(persons name) - want to get list of names from Persons
        Map<String,List<String>> grpByState2 = persons.stream().collect(Collectors.groupingBy(Person::getState,Collectors.mapping(Person::getName,Collectors.toList())));
        System.out.println(grpByState2);

        //Collectors - Grouping 3 - 
        Map<String,Long> grpByState3 = persons.stream().collect(Collectors.groupingBy(Person::getState, HashMap::new, Collectors.counting()));
        System.out.println(grpByState3);
    }
}
