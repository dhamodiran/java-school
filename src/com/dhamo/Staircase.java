package com.dhamo;

import java.util.Scanner;

// Define a class that contains the main method
public class Staircase {

  // Define a method that takes n as an argument
  public static int countWays(int n) {
    // Create an array of size n+1 to store the results
    int[] ways = new int[n+1];
    // Base case: if n is 0 or 1, return n
    if (n <= 1) {
      return n;
    }
    // Initialize the first two elements of the array
    ways[0] = 1;
    ways[1] = 1;
    // Loop from 2 to n and fill the array using the recurrence relation
    for (int i = 2; i <= n; i++) {
      ways[i] = ways[i-1] + ways[i-2];
      System.out.print(ways[i]+" "+ways[i-1] +" "+ways[i-2]+"->");
    }
    // Return the last element of the array
    return ways[n];
  }

  // Define the main method
  public static void main(String[] args) {
    // Ask the user to enter the number of steps
    System.out.print("Enter the number of steps: ");
    // Create a scanner object to read the input
    Scanner sc = new Scanner(System.in);
    // Read an integer from the user
    int n = sc.nextInt();
    // Close the scanner object
    sc.close();
    // Call the method and print the result
    System.out.println("Number of ways to reach the top: " + countWays(n));
  }
}
