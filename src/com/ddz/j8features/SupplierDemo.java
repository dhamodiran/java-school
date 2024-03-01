package com.ddz.j8features;

import com.ddz.j8features.model.Person;

import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<Person> supplier = ()-> new Person("Umesh",25);
        Person p = supplier.get();
        System.out.println("Name:"+p.getName());

    }

}
