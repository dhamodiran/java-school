package com.dhamo;

public class TestApp {
    public static void main(String[] args) {
        method1(null);
    }

    public static void method1(Object obj){
        System.out.println("test1");
    }

    public static void method1(String str){
        System.out.println("test2");

        try
        {
            System.out.println("test2");
        }
        catch (ArithmeticException e )
        {
        }
        catch (Exception e)
        {
        }

    }
}
