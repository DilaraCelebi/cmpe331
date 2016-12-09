package com.example.ayberk.busreservationsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    EditText editPass;

    TextView signIn;
    TextView showBus;
    TextView createAccount;

    //To store the accounts
    HashMap<String, String> accounts = new HashMap<String, String>();
    Integer loginCounter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editName);
        editPass = (EditText) findViewById(R.id.editPass);
        signIn = (TextView) findViewById(R.id.signIn);
        showBus = (TextView) findViewById(R.id.showBuses);
        createAccount = (TextView) findViewById(R.id.createAccount);

        accounts.put("Mahmut", "1234");
        accounts.put("Yaralıkalp34", "5555");
        accounts.put("Dilara", "1111");
        accounts.put("Ayberk", "2222");
        accounts.put("Berkay", "3333");

    }

    public void login(View v){
        String name= editName.getText().toString();
        String password= editPass.getText().toString();
        if(loginCounter<3){

        if(name.equals("") || password.equals("")){
            Toast.makeText(getBaseContext(), "Fill the Details!", Toast.LENGTH_LONG).show();

        }
        else if ( accounts.get(name)==null){

            Toast.makeText(getBaseContext(), "There is no any account with this name", Toast.LENGTH_LONG).show();
        }
        else if( accounts.get(name)!=null && accounts.get(name).equals(password)){

            //intent ile otobus sayfasına baglanılacak...............................
            Toast.makeText(getBaseContext(), "Welcome", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getBaseContext(), "Wrong Password,Try Again", Toast.LENGTH_LONG).show();
            loginCounter++;
            editPass.getText().clear();
        }

      }
        else{
            Toast.makeText(getBaseContext(), "Many wrong attempt!", Toast.LENGTH_LONG).show();
        }


    }
}
