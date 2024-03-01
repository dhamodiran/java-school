package com.dhamo.prep;

import java.util.List;

public class Student {

    Integer id;
    String Name;
    List<String> subjects;

    public Student(Integer id, String name, List<String> subjects) {
        this.id = id;
        Name = name;
        this.subjects = subjects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
