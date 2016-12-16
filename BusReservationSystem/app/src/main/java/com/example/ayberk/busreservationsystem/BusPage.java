package com.example.ayberk.busreservationsystem;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class BusPage extends Activity {

    EditText date;
    DatePickerDialog datePickerDialog;
    Spinner origin,destination;
    public static String selectedOrigin;
    public static int mYear;
    public static int mMonth;
    public static int mDay;
    public static int sYear;
    public static int sMonth;
    public static int sDay;
    public static String selectedDestination;

    List<String> originValues=Arrays.asList("Istanbul","Ankara", "Bolu", "İzmir", "Kocaeli", "Eskişehir", "Nevşehir", "Antalya","Muğla");
    List<String> destinationValues=Arrays.asList("Istanbul","Ankara", "Bolu", "İzmir", "Kocaeli", "Eskişehir", "Nevşehir", "Antalya","Muğla");


    Travel travel1=new Travel("Istanbul","Ankara","19:10",70.00,2017,01,02);
    Travel travel2=new Travel("Istanbul","Ankara","19:20",80.00,2017,01,02);
    Travel travel3=new Travel("Istanbul","Ankara","19:30",60.00,2017,01,02);
    Travel travel4=new Travel("Istanbul","Ankara","19:40",100.00,2017,01,02);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_page);
        origin = (Spinner)findViewById(R.id.spOrigin);
        destination=(Spinner)findViewById(R.id.spDest);
        // initiate the date picker and a button
        date = (EditText) findViewById(R.id.date);
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR); // current year
                mMonth = c.get(Calendar.MONTH); // current month
                mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(BusPage.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                                sDay=dayOfMonth;
                                sMonth=monthOfYear;
                                sYear=year;

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });

        final SpinnerAdapter adapter = new SpinnerAdapter(BusPage.this, android.R.layout.simple_list_item_1);
        adapter.addAll(originValues);
        adapter.add("Origin");
        origin.setAdapter(adapter);
        origin.setSelection(adapter.getCount());

        origin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                selectedOrigin =origin.getSelectedItem().toString();

                if(origin.getSelectedItem() == "Origin")
                {


                    //Do nothing.
                }
                else{

                    //Toast.makeText(MainActivity.this, origin.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub


            }
        });

        final SpinnerAdapter adapter2 = new SpinnerAdapter(BusPage.this, android.R.layout.simple_list_item_1);
        adapter.addAll(destinationValues);
        adapter.add("Destination");
        destination.setAdapter(adapter);
        destination.setSelection(adapter.getCount());

        destination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // TODO Auto-generated method stub

               selectedDestination= destination.getSelectedItem().toString();
                if(destination.getSelectedItem().toString().equals(selectedOrigin)){
                    Toast.makeText(BusPage.this, "You can not choose the same city ", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub



            }
        });



    }
    public  void searchBusButton(View v){

        Intent intent = new Intent(this, ListTravel.class);
        startActivity(intent);
    }




}