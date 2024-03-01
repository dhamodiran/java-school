package com.dhamo.prep;

import java.util.ArrayList;
import java.util.List;

public class ListClass {

    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add( new Employee("Dhamo"));
        empList.add( new Employee("Sathish"));

        empList.forEach(e -> System.out.println("BEFORE:"+ e.getName()));
        mthd(empList);


        empList.forEach(e -> System.out.println("After:"+ e.getName()));
    }

    public static void mthd( List<Employee> list){
        for(int i =0 ;i< list.size();i++){
            Employee emp = list.get(i);
            emp.setName("D111");
            return;
        }
    }


}
