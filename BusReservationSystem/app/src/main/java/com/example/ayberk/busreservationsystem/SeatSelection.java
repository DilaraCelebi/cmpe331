package com.example.ayberk.busreservationsystem;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.ArrayList;

public class SeatSelection extends Activity {

    private GridView gridView;
    private View btnGo;
    private ArrayList<String> selectedStrings;
    public static int counter=0;
    private static final String[] numbers = new String[]{
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection);

        gridView = (GridView) findViewById(R.id.gridView1);
        btnGo = findViewById(R.id.button);

        selectedStrings = new ArrayList<>();

        final GridViewAdapter adapter = new GridViewAdapter(numbers, this);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                int selectedIndex = adapter.selectedPositions.indexOf(position);
                if (selectedIndex > -1) {
                    adapter.selectedPositions.remove(selectedIndex);
                    ((GridItemView) v).display(false);
                    selectedStrings.remove((String) parent.getItemAtPosition(position));
                    counter--;
                } else {
                    adapter.selectedPositions.add(position);
                    ((GridItemView) v).display(true);
                    selectedStrings.add((String) parent.getItemAtPosition(position));
                    counter++;
                }
                String yazdır="";
                for(int i =0 ; i<selectedStrings.size();i++){
                    yazdır= yazdır + " " +selectedStrings.get(i).toString();
                }
                Toast.makeText(SeatSelection.this, "Selected Seats: "+ yazdır, Toast.LENGTH_LONG).show();

            }
        });

        //set listener for Button event



    }

    public void buyTicket(View v) {
        Toast.makeText(SeatSelection.this, "Please fill the details and accept the accept the agreement", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(SeatSelection.this,BuyTicket.class);
        startActivity(intent);
        /*
        if (MainActivity.isLoginTrue==false){
            Toast.makeText(SeatSelection.this, " Login to buy the Ticket ", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(SeatSelection.this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(SeatSelection.this, "Please fill the details and accept the accept the agreement", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(SeatSelection.this,BuyTicket.class);
            startActivity(intent);
        }
*/



    }
}