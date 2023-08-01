/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author quang
 */
public class Customer implements Serializable {
    private String name;
    private int age;
    private String province;
    private int phone;
    private int room;
    private String date;
    private double hours;
    private double totalprice;

    public Customer() {
    }

    public Customer(String name, int age, String province, int phone,
            int room, String date, double hours, double totalprice) {
        this.name = name;
        this.age = age;
        this.province = province;
        this.phone = phone;
        this.room = room;
        this.date = date;
        this.hours = hours;
        this.totalprice = totalprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", age=" + age + ", province=" + province + ", phone=" + phone + ", room=" + room + ", date=" + date + ", hours=" + hours + ", totalprice=" + totalprice + '}';
    }
}
