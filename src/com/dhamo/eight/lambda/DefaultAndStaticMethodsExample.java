package com.dhamo.eight.lambda;


import com.dhamo.eight.beans.Person;

import java.util.function.Function;
import java.util.function.Predicate;

interface I1 {
    default void method1(){
        System.out.println("I1 method1");
    }

    public static void method2(){
        System.out.println("Its static interface method which can't be override ");
    }

}

interface I2 {
    default void method1(){
        System.out.println("I2 method1");

    }
}

@FunctionalInterface // optional but if used only single abstract method should be used
interface functionalInterface {

    public void method3();
    //public void method4(); // can't declare because using @FunctionalInterface
}

class InterfaceDemo implements I1,I2,functionalInterface {

    @Override
    public void method1() {
        I2.super.method1();
    }

    @Override
    public void method3() {
        System.out.println("Functional Interface method");
    }
}
public class DefaultAndStaticMethodsExample implements I1,I2  {


    public static void main(String[] args) {
        InterfaceDemo demo = new InterfaceDemo();
        demo.method3();

        DefaultAndStaticMethodsExample demo1 = new DefaultAndStaticMethodsExample();
        demo1.method1();
        //demo1.method2();  // it will not compile and we can use object refernce to call static method
        I1.method2(); // compile without issue

        Predicate<Person> predicate = p -> p.getName().startsWith("D");
        validate(new Person(101,"Dhamo","Bangalore","KA"),predicate);

        Function<Person,Boolean> function = person -> person.getName().startsWith("D");
        validate1(new Person(101,"Dhamo","Bangalore","KA"),function);
    }

    public static void validate(Person person, Predicate predicate){

        if(predicate.test(person)){
            System.out.println("Valid");
        }else {
            System.out.println("In Valid");
        }

    }

    public static void validate1(Person person, Function<Person,Boolean>  function){

        System.out.println(function.apply(person));
        Boolean value = function.apply(person);
        if(function.apply(person)){
            System.out.println("Valid");
        }else {
            System.out.println("In Valid");
        }

    }

    @Override
    public void method1() {

        //Option 1 -> Provide our own implementation.
        System.out.println("I am inside Main class");

        //Option 2 -> Use existing implementation from I1 or I2 or both.
        I1.super.method1();
        I2.super.method1();
    }

  /* @Override
    public void method2() {
        System.out.println("I am inside Main class");
    }*/


}
