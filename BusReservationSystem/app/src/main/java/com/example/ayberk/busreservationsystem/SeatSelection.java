package com.example.ayberk.busreservationsystem;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class SeatSelection extends Activity {
    GridView gridView;
     public CharSequence seatNo;
    static final String[] numbers = new String[] {
            "1", "3", "5", "7", "9",
            "11", "2", "4", "6", "8",
            "10", "12", "13", "15", "17",
            "19", "21", "23", "14", "16",
            "18", "20", "22", "24"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_seat_selection);

        gridView = (GridView) findViewById(R.id.gridView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, numbers);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                seatNo=((TextView) v).getText();
              /*  if()*/
                    /*Bu koltuk arraylistte varsa*/
                        {

                    Toast.makeText(getApplicationContext(),
                          "This seat has been already sold,change the seat", Toast.LENGTH_SHORT).show();
                }

          /*  else{
                Toast.makeText(getApplicationContext(),
                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
            }*/
            }
        });



    }

}