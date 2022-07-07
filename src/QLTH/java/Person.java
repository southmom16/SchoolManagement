/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLTH.java;

/**
 *
 * @author southmom16
 */
public abstract class Person {
     private String id;
     private String name;
     private String address;
     private String email;
     private String phoneNumber;
     private String nationality;

    public Person() {
    }

    public Person(String id, String name, String address, String email, String phone_number, String nationality) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phone_number;
        this.nationality = nationality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}

