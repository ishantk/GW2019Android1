package com.auribises.gw2019android1;

public class Customer {

    public int image;
    public String name;
    public String phone;

    public Customer(){

    }

    public Customer(int image, String name, String phone) {
        this.image = image;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "image=" + image +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
