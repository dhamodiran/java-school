package com.dhamo.eight;

import java.util.*;
import java.util.stream.Collectors;

public class DemoAICode {
    public static void main(String[] args) {


        // create a map of strings as values and integers as keys
        Map<Integer, String> map = new HashMap<>();
        // add values to the map
        map.put(2, "one");
        map.put(1, "two");
        map.put(3, "three");
        map.put(4, "four");
        // print the map using stream
        map.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));

        //print and sort map using key
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        //print and sort map using value
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        //print and sort map using key in reverse order
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(System.out::println);
        //print and sort map using value in reverse order
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);





       // create 10 random integers in int array
         int[] intArray = new int[10];
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = (int) (Math.random() * 100);
            }
            // print the array
            for (int i = 0; i < intArray.length; i++) {
                System.out.print(intArray[i] + " ");
            }
            System.out.println();
            bubbleSort(intArray);
          //  selectionSort(intArray);
          //  insertionSort(intArray);


    }
// bubble sort
public static void bubbleSort(int []arr){
        int swapCount =0;
    // sort the array using bubble sort
    for (int i=0;i< arr.length;i++)
    {
        for (int j =0;j< arr.length-i-1;j++){

            if(arr[j] > arr[j+1]){
                int temp = arr[j];
                arr[j]=arr[j+1];
                arr[j+1] = temp;
                swapCount++;
            }
        }
    }

    // print the array
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
    }
    System.out.print(" --> swap count :"+swapCount);
    System.out.println();
}


public static void selectionSort(int []arr){

    int swapCount=0;
        for(int i =0 ;i<arr.length;i++){
            int min_idx = i;
            for(int j =i+1 ;j<arr.length;j++){
                if(arr[min_idx]> arr[j]){
                    min_idx = j;
                }
            }
            //if(j == arr.length-1){
                int temp = arr[min_idx];
                arr[min_idx] = arr[i] ;
                arr[i] = temp;
                swapCount++;
           // }

        }
    Arrays.stream(arr).forEach(e -> System.out.print(e+ " "));
    System.out.print(" --> swap count :"+swapCount);
    System.out.println();

}

public static void insertionSort(int []arr){
        int swapCount=0;
        for(int i =0 ; i< arr.length-1; i++){
            int key = i+1;

            for(int j =key-1;j>=0;j--){

                if(arr[j] > arr[key]){
                    int temp = arr[j];
                    arr[j]= arr[key];
                    arr[key] = temp;
                    swapCount++;
                }

            }

        }

        Arrays.stream(arr).forEach(e->System.out.print(e+" "));
        System.out.print(" --> Insertion swap count :"+swapCount);
        System.out.println();

}

}