package com.dhamo.eight.other;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        Integer []nums = new Integer[]{2,3,1,6,5};
        //1,2,4,5,5,7
        //
        System.out.println("Second Max Element : "+ findSecondMaxItem(nums));

        int []nums1 = new int[4];
        nums1[0] =10;
        nums1[1]=12;
        nums1[2]=5;
        nums1[3]=5;
        System.out.println("Nums1:"+nums1.length);

      // List<Integer> list
               long c = Arrays.stream(nums1).boxed().filter(e->e>=10).count();
      int []nums2 =nums1;


       List<Integer> lst = new ArrayList<>();
               Arrays.stream(nums1).boxed().reduce((e,e1)-> {
            if(e!=e1){
                lst.add(e);

            }else {
                lst.add(e1);
            }
            return e;
        });
        System.out.println("Count 2:"+lst);

        Predicate<String> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNullOrEmpty = isNull.or(isEmpty);
        Predicate<String> isNotNullNorEmpty = isNullOrEmpty.negate();
        Predicate<String> shorterThan5 = s -> s.length() < 5;

        Predicate<String> p = isNotNullNorEmpty.and(shorterThan5);

        String str= null;
        System.out.println("Combine predicate:"+p.test(str));


    }

    public static Integer findSecondMaxItem(Integer arr[]){
        Integer secondMax = null;
        System.out.println("length:"+arr.length);
        if(arr.length == 1 || arr.length == 0)
         return null;
        else{
                Arrays.sort(arr);

                int length = arr.length;
                int j=1;

                for(int i= length-1;i>0;i--) {

                    if(arr[i] ==arr[i-1]){
                        System.out.println("j:"+j);
                        j++;
                    }else if(arr[length-(j)] == arr[length-(j+1)]){
                        return null;
                    }else{
                        secondMax = arr[length-(j+1)];

                    }

                }
            return secondMax;
        }

    }

    public static Integer findSecondMaxItem2(Integer arr[]){
        Integer secondMax = null;
        //2,4,1,5,7
        if(arr.length == 1 || arr.length == 0){
            return null;
        }
        else{
           Arrays.sort(arr);
        }
        //int max = Arrays.stream(arr).max(Comparator.comparing(i.co);
       // return Arrays.stream(arr);
        return null;
    }
}