package com.example.sqliteexample;

public class Student {
    private String Name ,Dept;
    int  Id;

    public Student(String name, int id, String dept) {
        this.Name = name;
        this.Id = id;
        this.Dept = dept;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDept() {
        return Dept;
    }

    public void setDept(String dept) {
        Dept = dept;
    }
}
