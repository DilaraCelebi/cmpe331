package com.example.ayberk.busreservationsystem;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by x7evangelion on 12/19/16.
 */
public class MainActivityTest {



    boolean accountCheck = false;
    int loginCounter = 0;
    boolean isLoginTrue =false;
    ArrayList<Person> Accounts = new ArrayList<Person>();


    public String login() {
        Person p1 = new Person("Name1", "Surname1", "Email1", "Pass1");
        Person p2 = new Person("Name3", "Surname2", "Email2", "Pass2");
        Person p3 = new Person("Name2", "Surname3", "Email3", "Pass3");
        Person p4 = new Person("Name4", "Surname4", "Email4", "Pass4");
        Accounts.add(p1);
        Accounts.add(p2);
        Accounts.add(p3);
        Accounts.add(p4);
        String name = "Name1";
        String password = "Pass1";
        String result = "";
        int id = 3;
        for (int i = 0; i < Accounts.size(); i++) {
            if (Accounts.get(i).getName().equals(name)) {
                accountCheck = true;
                id = i;
            }
        }
        if(Accounts.get(id).getPass().equals(password)) {
            result = name+" "+password;
        }
        return result;
    }





    @Test
    public void testLogin() throws Exception {
        String result = login();
        assertEquals("Name1 Pass1", result);
    }


}