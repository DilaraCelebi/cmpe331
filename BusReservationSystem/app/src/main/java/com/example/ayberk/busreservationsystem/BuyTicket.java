package com.example.ayberk.busreservationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BuyTicket extends AppCompatActivity {


    TextView textOrigin;
    TextView textDesti;
    TextView textPrice,textDate,textTime,textCross;
    EditText textMaster,visaCardEdit,valid;
    RadioGroup rgCard;
    RadioButton radioVisa;
    RadioButton radioMaster;
    ImageView masterCard,visaCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);

        textOrigin=(TextView)findViewById(R.id.textOrigin);
        textDesti=(TextView)findViewById(R.id.textDesti);
        textDate=(TextView)findViewById(R.id.textDate);
        textPrice=(TextView)findViewById(R.id.textPrice);
        textTime=(TextView)findViewById(R.id.textTime);
        textCross=(TextView)findViewById(R.id.textCross);
        textMaster=(EditText)findViewById(R.id.textMaster);
        visaCardEdit=(EditText)findViewById(R.id.visaCardEdit);
        rgCard=(RadioGroup)findViewById(R.id.rgCard);
        radioMaster=(RadioButton)findViewById(R.id.radioButtonMaster);
        radioVisa=(RadioButton)findViewById(R.id.radioButtonVisa);
        masterCard=(ImageView)findViewById(R.id.masterCard);
        visaCard=(ImageView)findViewById(R.id.visaCard);
        valid=(EditText)findViewById(R.id.valid);

        rgCard.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i== R.id.radioButtonMaster){
                    textMaster.setVisibility(View.VISIBLE);
                    visaCardEdit.setVisibility(View.INVISIBLE);
                    masterCard.setVisibility(View.VISIBLE);
                    visaCard.setVisibility(View.INVISIBLE);
                }
                else if (i== R.id.radioButtonVisa){
                    textMaster.setVisibility(View.INVISIBLE);
                    visaCardEdit.setVisibility(View.VISIBLE);
                    masterCard.setVisibility(View.INVISIBLE);
                    visaCard.setVisibility(View.VISIBLE);
                }

            }
        });



        String secilen=ListTravel.secilenOtobus;
        String[]ticketInfo =secilen.split(" ");
        //trims the ","
        //trims the line and set them in to array
        String time = ticketInfo[0].trim();
        String origin = ticketInfo[1].trim();
        String destination = ticketInfo[2].trim();
        String price = ticketInfo[3].trim();
        String date = ticketInfo[4].trim();

        Double total=  SeatSelection.counter * Double.parseDouble(price);

        textTime.setText("Time: "+ time);
        textOrigin.setText("Origin: " + origin);
        textDesti.setText("Destination: "+ destination);
        textCross.setText("X "+SeatSelection.counter );
        textPrice.setText("Price: " + total);

        textDate.setText("Date: "+ date);



    }


    public void  buyTicketPay(View v){
        if (textMaster.getText().toString().equals("") && visaCardEdit.getText().toString().equals("")){
            Toast.makeText(BuyTicket.this, "Fill Details", Toast.LENGTH_LONG).show();
        }
        else if(valid.getText().toString().equals("")){
            Toast.makeText(BuyTicket.this, "Fill Details", Toast.LENGTH_LONG).show();
        }
        else{

            Toast.makeText(BuyTicket.this, "Ticket ", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, ShowBoughtTicket.class);
                startActivity(intent);
        }


    }





}
