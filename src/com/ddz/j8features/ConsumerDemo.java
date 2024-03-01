package com.ddz.j8features;

import com.ddz.j8features.model.Person;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<Person> consumer = p -> System.out.println(p.getAge());

        consumer.accept(new Person("test",12));
        Consumer<String> consumer1 = (arg) -> System.out.println(arg + "My name is Jane.");
        Consumer<String> consumer2 = (arg) -> System.out.println(arg + "I am from Canada.");
        consumer1.andThen(consumer2).accept("Hello. ");

        //either not taken any argument(Supplier), not returned any value(Consumer), or returned only a boolean(Predicate).
    }
}
