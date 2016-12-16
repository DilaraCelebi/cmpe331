package com.example.ayberk.busreservationsystem;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {

    EditText editName;
    EditText editPass;

    TextView signIn;
    TextView showBus;
    TextView createAccount;

    //To store the accounts
    public static HashMap<String, String> accounts = new HashMap<String, String>();
    public static ArrayList accountList= new ArrayList();
    Integer loginCounter=0;
    public static boolean isLoginTrue =false;
    StringBuffer buf = new StringBuffer();
    static final int READ_BLOCK_SIZE = 100;

    static ArrayList<Person> Accounts   = new ArrayList<>();
    ArrayList<String> soyisim = new ArrayList<String>();
    ArrayList<String> mail = new ArrayList<String>();
    ArrayList<String> sifre = new ArrayList<String>();

    private final static String FILE_NAME = "notes.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editName);
        editPass = (EditText) findViewById(R.id.editPass);
        signIn = (TextView) findViewById(R.id.signIn);
        showBus = (TextView) findViewById(R.id.showBuses);
        createAccount = (TextView) findViewById(R.id.createAccount);
        ReadData();

    }
    boolean accountCheck=false;
    public void login(View v){
        int id=999;
        String name= editName.getText().toString();
        String password= editPass.getText().toString();


        for (int i=0;i<Accounts.size();i++){
            if (Accounts.get(i).getName().equals(name)){
                id=i;
                accountCheck=true;

            }

        }

       if(loginCounter<3 ){

        if(name.equals("") || password.equals("")){
            Toast.makeText(getBaseContext(), "Fill the Details!", Toast.LENGTH_LONG).show();

        }
        else if (accountCheck==false){
                Toast.makeText(getBaseContext(), "Unsaved Account", Toast.LENGTH_LONG).show();

            }
        /*else if ( accounts.get(name)==null){

            Toast.makeText(getBaseContext(), "There is no any account with this name", Toast.LENGTH_LONG).show();
        }*/


        else if(Accounts.get(id).getPass().equals(password)){

            //intent ile otobus sayfasına baglanılacak...............................
            Toast.makeText(getBaseContext(), "Welcome", Toast.LENGTH_LONG).show();
            isLoginTrue=true;
        }
        else if(!Accounts.get(id).getPass().equals(password)){
            Toast.makeText(getBaseContext(), "Wrong Password,Try Again", Toast.LENGTH_LONG).show();
            loginCounter++;
            editPass.getText().clear();
        }

      }
        else{
            Toast.makeText(getBaseContext(), "Many wrong attempt!", Toast.LENGTH_LONG).show();
        }



    }
    public void ReadData() {

            try {
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(
                        openFileInput("deneme")));
                String inputString;
                StringBuffer stringBuffer = new StringBuffer();
                while ((inputString = inputReader.readLine()) != null) {
                    String[]a =inputString.split(",");
                    //trims the ","
                    //trims the line and set them in to array
                    String aisim = a[0].trim();
                    String asoyisim = a[1].trim();
                    String amail = a[2].trim();
                    String apassword = a[3].trim();

                    Person p1=new Person(aisim,asoyisim,amail,apassword);

                    Accounts.add(p1);
                    stringBuffer.append(inputString + "\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }




    public  void createAccount(View v){

        Intent intent = new Intent(this, CreateAnAccount.class);
        startActivity(intent);
    }


    public  void showBusesPage(View v){

        Intent intent = new Intent(this, BusPage.class);
        startActivity(intent);
    }




}
