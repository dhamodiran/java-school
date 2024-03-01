package com.ddz.j8features;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public  class IteratorDemo {

    public static void main(String args[]) {

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Grapes");
        fruits.add("Orange");

        Iterator<String> iterator = fruits.iterator();
        //prior to java8
       // while(iterator.hasNext()){
           // System.out.println(iterator.next());
       // }

        //java 8 using iterator
        iterator.forEachRemaining((fruit) -> System.out.println("j8:"+fruit));
    }
}
