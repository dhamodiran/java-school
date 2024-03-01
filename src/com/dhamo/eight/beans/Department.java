package com.dhamo.eight.beans;

public class Department {

    int id;
    String deptName;
    String deptCde;

    public Department(int id, String deptName, String deptCde) {
        this.id = id;
        this.deptName = deptName;
        this.deptCde = deptCde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptCde() {
        return deptCde;
    }

    public void setDeptCde(String deptCde) {
        this.deptCde = deptCde;
    }
}
