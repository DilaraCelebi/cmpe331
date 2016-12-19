package com.example.ayberk.busreservationsystem;

import android.view.View;
import android.widget.Toast;

import org.junit.Test;

import java.util.ArrayList;

import static com.example.ayberk.busreservationsystem.MainActivity.Accounts;
import static org.junit.Assert.*;

/**
 * Created by x7evangelion on 12/19/16.
 */
public class CreateAnAccountTest {
    ArrayList<Person> Accounts = new ArrayList<Person>();

    public String createButtonActivity(){
        String name = "Name";
        String surname = "Surname";
        String email = "Email";
        String password1 = "Pass1";
        String password2 = "Pass1";
        Person p1 = new Person("Name1", "Surname1", "Email1", "Pass1");
        Person p2 = new Person("Name3", "Surname2", "Email2", "Pass2");
        Person p3 = new Person("Name2", "Surname3", "Email3", "Pass3");
        Person p4 = new Person("Name4", "Surname4", "Email4", "Pass4");
        Accounts.add(p1);
        Accounts.add(p2);
        Accounts.add(p3);
        Accounts.add(p4);
        String result = "";
        boolean isTherePerson=false;

        for (int i =0;i<Accounts.size();i++) {
            Person person = (Person) Accounts.get(i);
            String namePerson = person.getName();
            String emailPerson = person.getEmail();


            if (
                    namePerson.equals(name) || emailPerson.equals(email)
                    ) {
                isTherePerson=true;

            }

        }

        if (name.equals("") || surname.equals("") || email.equals("") || password1.equals("") || password2.equals("") || isTherePerson==true){

            result = "Failed";

        }

        else{

            if (password1.equals(password2) ) {

                result = name+","+surname+","+email+","+password1;
                Person p5=new Person(name,surname,email,password1);
                Accounts.add(p5);

            }

        }
        return result;
    }



    @Test
    public void testCreateButtonActivity() throws Exception {
        String result = createButtonActivity();
        assertEquals("Name,Surname,Email,Pass1",result);
    }

}