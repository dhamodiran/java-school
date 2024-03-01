package com.ddz.j8features;



import com.ddz.j8features.model.Person;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Person person = new Person("Dhamo",30);
        Predicate<Person> agePredicate = p -> p.getAge() > 18;
        Predicate<Person> namePredicate = p -> p.getName().startsWith("D");
        Predicate<Person> ageNamePredicate = agePredicate.and(namePredicate);
        System.out.println("Eligibility:"+checkAgeEligibilty(person,ageNamePredicate)); // True
    }

    public  static boolean checkAgeEligibilty(Person person, Predicate<Person> predicate){
        return predicate.test(person);
    }
}
