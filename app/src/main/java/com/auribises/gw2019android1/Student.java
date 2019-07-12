package com.auribises.gw2019android1;

import java.io.Serializable;

public class Student implements Serializable {

    // Attributes : Property of Object
    public String name;
    public String phone;
    public String email;
    public char gender;
    public String city;
    public float rating;


    public Student() {
    }

    public Student(String name, String phone, String email, char gender, String city, float rating) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.city = city;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                ", rating=" + rating +
                '}';
    }
}
