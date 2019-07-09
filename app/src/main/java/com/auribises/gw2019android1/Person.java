package com.auribises.gw2019android1;

import java.io.Serializable;

//Serializable is a Marker Interface

public class Person implements Serializable {

    public String name;
    public String phone;
    public int age;

    public Person(){

    }

    public Person(String name, String phone, int age) {
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }
}
