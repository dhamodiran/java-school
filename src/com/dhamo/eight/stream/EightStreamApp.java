package com.dhamo.eight.stream;

import com.dhamo.eight.beans.Department;
import com.dhamo.eight.beans.Employee;
import com.dhamo.eight.beans.Person;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class EightStreamApp {

    public static void main(String[] args) {
        System.out.println("Java 8 Stream API");

        /**
         * It groups the strings by their length with groupingBy(String::length)
         * It counts the number of strings for each length with counting()
         * It then creates a Map<Integer, Long> to store the result
         */
        List<String> list = List.of("one","two","three","four");
        var map = list.stream().collect(Collectors.groupingBy(String::length,counting()));
        System.out.println(map);
        map.forEach((k,v)-> System.out.println("Key:"+k +" Value:"+v));

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Dhamo","Bangalore", "KA"));
        persons.add(new Person(2,"Sujith","Bangalore", "KA"));
        persons.add(new Person(3,"Umesh","Bangalore", "KA"));
        persons.add(new Person(4,"Shakthi","Chennai", "TN"));
        persons.add(new Person(5,"Dhamo","Chennai", "TN"));

        // Accumulate person name into list
        List<String> names = persons.stream().map(Person::getName).collect(Collectors.toList());
        names.forEach(System.out::println);
        System.out.println("-".repeat(10)+"End "+"-".repeat(10));

        // Accumulate person name into tree set
        Set<String> names2 = persons.stream().map(Person::getName).map(s->s+" CPF").collect(Collectors.toCollection(TreeSet::new));
        names2.forEach(System.out::println);
        System.out.println("-".repeat(10)+"End "+"-".repeat(10));

        // update list of persons
        int count=0;
        List<Person> updatedList = persons.stream().map(p->{
            //int i=1;
            String str = p.getName()+" 000"+count+1;
            p.setName(str);
            return p;
        }).collect(Collectors.toList());
        updatedList.forEach(e-> System.out.println(e.getId()+":"+e.getName()));
        System.out.println("-".repeat(10)+"End "+"-".repeat(10));

        //Joining names
        String names3 = persons.stream().map(Person::getName).collect(joining(","));
        System.out.println("Name Joining:"+ names);

        String s= null;
        testStringOrNull(s);
        Department dev = new Department(100,"Dev","D");
        Department qa = new Department(100,"Qa","Q");

        // Employee
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1,"abc",10000,dev));
        empList.add(new Employee(6,"abc",11000,dev));
        empList.add(new Employee(2,"xyz",20000,qa));
        empList.add(new Employee(3,"pqr",30000,dev));
        empList.add(new Employee(1,"lmn",25000,dev));
        empList.add(new Employee(5,"aaa",12000,qa));

        empList.forEach(e-> System.out.println());

        getSecondHighestSalary(empList);
        empList.stream().peek(e ->System.out.println("name:"+e.getName()+" Salary:"+e.getSalary())).map(Employee::getSalary).map(Object::toString).collect(joining(","));

        System.out.println("-".repeat(10)+"End "+"-".repeat(10));
        // Employee -- sum salary
        var sum = empList.stream().collect(Collectors.summingInt(Employee::getSalary));
        System.out.println("Sum Salary: "+sum);

        var intSummaryStatistics = empList.stream().collect(Collectors.summarizingInt(Employee::getSalary));
        System.out.println("Max Salary: "+intSummaryStatistics.getMax());
        System.out.println("Min Salary: "+intSummaryStatistics.getMin());
        System.out.println("Avg Salary: "+intSummaryStatistics.getAverage());
        System.out.println("Count Salary: "+intSummaryStatistics.getCount());

        var intSummaryStatistics1 = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summarizingInt(Employee::getSalary)));
        System.out.println("Count Salary: "+intSummaryStatistics.getCount());
        intSummaryStatistics1.forEach((e,v)-> System.out.println(e.getDeptName()+ " "+v.getMax()));
        //Group Employee by dept
        Map<Department,List<Employee>> dept = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        dept.forEach((k,v)-> System.out.println("Dept: "+k.getDeptName()+" Employee Names: "+v.stream().map(Employee::getName).collect(joining(","))));

        //Group Employee names by dept
        Map<Department,List<String>> namesByDept = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName,toList())));
        namesByDept.forEach((k,v)-> System.out.println("Dept:"+k.getDeptName() +" Names :"+v));

        //Sum employee salary by department
        var departmentSalSum = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));
        departmentSalSum.forEach((k,v)-> System.out.println("Dept:"+k.getDeptName()+" salary sum:"+v));

        //max employee salary by department
      /*  Comparator<Employee> salaryComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                 if(e1.getSalary()== e2.getSalary() ) {
                     return 0;
                 }
                       else {
                           return e1.getSalary()>e2.getSalary()?  1: -1;
                       }
            }
        };*/

        //Max employee salary by department
        Comparator<Employee> salaryComparator = (e1,e2)-> Integer.valueOf(e1.getSalary()).compareTo( e2.getSalary());
        var departmentSalMax = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy((e1,e2)->
                {
            if(e1.getSalary()== e2.getSalary() ) {
                return 0;
            }else {
                return e1.getSalary()>e2.getSalary()?  1: -1;
            }
        })));
        departmentSalMax.forEach((k,v)-> System.out.println("Dept:"+k.getDeptName()+" salary max:"+v.get().getSalary()));

        Map<Department, Employee> maxSal = empList.stream().collect(groupingBy(Employee::getDepartment, collectingAndThen(maxBy(salaryComparator), Optional::get)));
        maxSal.forEach((k,v) -> System.out.println("###Department:"+k.getDeptName() +" Max Salary:"+v.getSalary()));

        //Partition employee names base on department code
        var employeePartition = empList.stream().collect(Collectors.partitioningBy(e -> e.getDepartment().getDeptCde().equals("D")));
        employeePartition.forEach((k,v)->System.out.println("K:"+k+" V:"+v.stream().map(Employee::getName).collect(Collectors.toList())));

        listToMap(empList);
    }

    static void testStringOrNull(Object obj) {
        switch (obj) {
            case null, String s -> System.out.println("String: " + s);
            default             -> System.out.println("Something else");
        }
    }

    public static void getSecondHighestSalary(List<Employee> list){

        //Optional<Employee> opt = list.stream().min(Comparator.comparing(Employee::getSalary));
        //Optional<Employee> opt = list.stream().sorted((e1,e2)->e2.getSalary().compareTo(e1.getSalary())).skip(1).findFirst();
        Optional<Employee> opt = list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst();
        System.out.println("Second Highest Salary :"+ opt.get().getSalary());

        Employee opt1 = list.stream().min(Comparator.comparing(Employee::getSalary)).get();
        var collect = list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).collect(toCollection(LinkedList::new));
        System.out.println("Top 3 List :");
        collect.forEach(e-> System.out.println(e.getSalary()));

        List<Integer> numList = List.of(1,5,3,4,6,10);
        var collect1 = numList.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).limit(3).collect(toList());
        collect1.forEach(e-> System.out.println(e));
    }

    public static void listToMap(List<Employee> list){
        // Map<String,List<Employee>> listToMap = list.stream().collect(groupingBy(Employee::getName));
        Map<String,List<Employee>> listToMap = new HashMap<>();
        List<Employee> empList = null;

        for( Employee e : list){
                   if( empList != null && empList.contains(e.getName())){
                       listToMap.get(e.getName()).add(e);
                   }else{
                       empList = new ArrayList<>();
                       empList.add(e);
                   }

                   listToMap.put(e.getName(),empList);
        }

        System.out.println("List to Map:" + listToMap);
    }
}
