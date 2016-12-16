package com.example.ayberk.busreservationsystem;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ShowBoughtTicket extends AppCompatActivity {
    TextView id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bought_ticket);
        id = (TextView)findViewById(R.id.ticketId);

    }

    @Override
    protected void onStart()
    {
        // TODO Auto-generated method stub
        super.onStart();
        generateId();
        sendEmail();

    }

    public void generateId(){
        int passwordSize = 10;
        char[] chars = "ABCDEFGHIJKLMNOPRSTUVYZ0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < passwordSize; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        id.setText("Your ticket ID is :" + output);

    }

    public void sendEmail() {

        generateId();

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"celebi.dilara.95@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Fast Ticket");
        i.putExtra(Intent.EXTRA_TEXT,"Your ticket id is : 874JG34893. If you didn't buy a ticket. Please get in contact with customer service! Have a good day." );
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ShowBoughtTicket.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }



}
