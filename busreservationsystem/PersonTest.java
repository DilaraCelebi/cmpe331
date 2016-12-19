package com.example.ayberk.busreservationsystem;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by x7evangelion on 12/19/16.
 */
public class PersonTest {


    Person person = new Person("Name", "Surname", "Email", "Pass");


    @Test
    public void getName() throws Exception {
        String result =person.getName();
        assertEquals("Name", result);
    }

    @Test
    public void getSurname() throws Exception {
        String result =person.getSurname();
        assertEquals("Surname", result);
    }

    @Test
    public void getEmail() throws Exception {
        String result =person.getEmail();
        assertEquals("Email", result);
    }

    @Test
    public void getPass() throws Exception {
        String result =person.getPass();
        assertEquals("Pass", result);
    }

}