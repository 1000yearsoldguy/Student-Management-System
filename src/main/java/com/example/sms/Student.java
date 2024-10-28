package com.example.sms;

import java.time.LocalDate;

public class Student {
    public String id;

    public String name;
    public int classes;
    public int age;
    public String dob;

    public Student(String name, String id, LocalDate dob, int age, int classes) {
        this.id = id;
        this.name = name;
        this.dob = String.valueOf(dob);
        this.age = age;
        this.classes = classes;
    }
}