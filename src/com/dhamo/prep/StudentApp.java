package com.dhamo.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentApp {

    public static void main(String[] args) {
        List<String> sub = new ArrayList<>(Arrays.asList("PH","CH","MT"));
        List<String> sub2 = new ArrayList<>(Arrays.asList("PH","MT"));
        Student s1 = new Student(1,"dha",sub);
        Student s2 = new Student(2,"tst",sub2);
        List<Student> studList = new ArrayList<>();
        studList.add(s1);
        studList.add(s2);
        System.out.println(s1);

        Map<String, Long> ch = studList.stream().collect(Collectors.groupingBy(s -> s.getSubjects().stream().filter(e -> e.equals("CH")).findFirst().orElseGet(() -> "Not Opted"), Collectors.counting()));

        Map<String, Long> ch2 = studList.stream().flatMap(s->s.getSubjects().stream()).collect(Collectors.groupingBy(s ->s, Collectors.counting()));
        System.out.println(ch2);
    }
}
