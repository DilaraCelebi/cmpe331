package com.example.ayberk.busreservationsystem;

/**
 * Created by ayberk on 9.12.2016.
 */

public class Person {

    String name;
    String surname;
    String email;
    String pass;


    public Person(String name, String surname, String email, String pass) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.pass = pass;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass1) {
        this.pass = pass;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", pass1='" + pass + '\'' +
                '}';
    }
}
