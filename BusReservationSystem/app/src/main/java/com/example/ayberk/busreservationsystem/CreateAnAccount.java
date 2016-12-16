package com.example.ayberk.busreservationsystem;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static com.example.ayberk.busreservationsystem.MainActivity.Accounts;

public class CreateAnAccount extends AppCompatActivity {

    String personAdd;
    EditText nameNewAccount;
    EditText surnameNewAccount;
    EditText emailNewAcocunt;
    EditText passwordFirst;
    EditText passwordSecond;
    TextView createBttn;

    String name;
    String surname;
    String email;
    String password1;
    String password2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        nameNewAccount=(EditText)findViewById(R.id.editTextName);
        surnameNewAccount=(EditText)findViewById(R.id.editTextSurname);
        emailNewAcocunt=(EditText)findViewById(R.id.editTextEmail);
        passwordFirst=(EditText)findViewById(R.id.editTextPassword);
        passwordSecond=(EditText)findViewById(R.id.editTextPasword2);
        createBttn=(TextView) findViewById(R.id.accountCreate);



    }

    public void createButtonActivity(View v){
        name=nameNewAccount.getText().toString();
        surname=surnameNewAccount.getText().toString();
        email=emailNewAcocunt.getText().toString();
        password1=passwordFirst.getText().toString();
        password2=passwordSecond.getText().toString();

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

            Toast.makeText(getBaseContext(), "Fill Details or exist account ", Toast.LENGTH_LONG).show();

        }

        else{

            if (password1.equals(password2) ) {

                Toast.makeText(getBaseContext(), " Account Saved", Toast.LENGTH_LONG).show();
                personAdd=name+ ","+ surname + ","+email +","+ password1;
                writeData();
                Person p1=new Person(name,surname,email,password1);
                MainActivity.Accounts.add(p1);
                finish();
            }
            else {

                Toast.makeText(getBaseContext(), "Passwords are not same", Toast.LENGTH_LONG).show();

            }
        }

    }

    public void writeData(){

        try {
            FileOutputStream fos = openFileOutput("deneme", Context.MODE_PRIVATE);
            String str=nameNewAccount.getText().toString() +","+ surnameNewAccount.getText().toString()+","+ emailNewAcocunt.getText().toString()+","+ passwordFirst.getText().toString() + "\n";
            fos.write(str.getBytes()   );
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
/*
    public void ReadData(View v) {
        try {
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(
                    openFileInput("DayTwentyTwoFile")));
            String inputString;
            StringBuffer stringBuffer = new StringBuffer();
            while ((inputString = inputReader.readLine()) != null) {
                stringBuffer.append(inputString + "\n");
            }
            nameNewAccount.setText(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

}
