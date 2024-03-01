package com.dhamo.eight.strings;

public class StringsApp {
    public static void main(String[] args) {

        String s = "abc";
        String s2 = s;
        s = s.concat("def");

        String s1 = "xyz";
        String s12 = new String("xyz");//.intern();
        String s13 = s12;
        System.out.println(s1 == s13);  //true
        System.out.println( s12 == s13); //true

        // S1 refers to Object in the Heap Area
        // Line-1
        String s11 = new String("GFG");

        // S2 now refers to Object in SCP Area
        // Line-2
        String s21 = "GFG";//s11.concat("GFG");//s11;

        // S3 refers to Object in SCP Area
        // Line-3
        String s31 = s11.intern();

        System.out.println(s21 == s31);

        // S4 refers to Object in the SCP Area
        // Line-4
        String s4 = "GFGGFG";//"GFG";

        System.out.println(s31 == s4);

        //String Builder
        /**
         *  3 ways to create
         *  1. default no arguments which has initial 16 char capacity
         *  2. passing String argument capacity is 16 + length of argument
         *  3. pasing Integer values which is created using mentioned capacity.
         */

        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder("abc");
        StringBuilder sb2 = new StringBuilder(10);

        sb.append("xyz");
        sb.append(10);
        sb.charAt(1);
        sb.length();
        System.out.println(sb.indexOf("x"));
        sb.insert(5,"A");  // offset should be within the string length
        sb.insert(6,"ABC");
        sb.delete(5,6);  // start is zero based end is one's based
        sb.deleteCharAt(4); // index should be zero based
        System.out.println(sb.substring(2)); // start is zero based
        System.out.println(sb.substring(2,5)); // start is zero based end is one's based
        System.out.println(sb);
        sb.replace(0,2,"X"); // start inclusive and end will be excluded.
        System.out.println(sb);
        sb.replace(0,2,"AAA");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);

        //Strings

        String str = new String();

        str= str.concat("12345");
        str = str.replace("1","A");
        str.toUpperCase();
        str.toLowerCase();
        System.out.println(str);
        System.out.println(str.contentEquals("A2345"));
        str.equalsIgnoreCase("ABC");
        str.toString();


    }
}
