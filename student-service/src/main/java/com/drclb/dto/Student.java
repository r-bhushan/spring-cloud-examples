package com.drclb.dto;

public class Student {
    private String _name;
    private int _rollNumber;

    public String getName() {
        return _name;
    }

    public Student setName(String name) {
        _name = name;
        return this;
    }

    public int getRollNumber() {
        return _rollNumber;
    }

    public Student setRollNumber(int rollNumber) {
        _rollNumber = rollNumber;
        return this;
    }
}
