package com.example.ayberk.busreservationsystem;

import android.widget.Toast;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by x7evangelion on 12/19/16.
 */
public class ListTravelTest {

    String travelString;
    ArrayList<Travel> travels = new ArrayList<Travel>();
    ArrayList<String> travelsWillBeListed = new ArrayList<>();
    Travel tr1=new Travel("destinationCity","originCity","time",10.00,2016,01,01);
    Travel tr2=new Travel("destinationCity2","originCity2","time2",20.00,2016,01,01);
    Travel tr3=new Travel("destinationCity3","originCity3","time3",30.00,2018,01,03);
    Travel tr4=new Travel("destinationCity4","originCity4","time4",40.00,2017,01,04);
    ListTravel lt = new ListTravel();
    BusPage bp = new BusPage();


    public ArrayList<String> travelDetails(){

        int year = 2016;
        int day =01;
        int mounth= 01;
        String destination= "destinationCity";
        String origin= "originCity";

        for(int i =0; i<travels.size(); i++){

            travelString= travels.get(i).getTime() +" "+travels.get(i).getOriginCity()+" "+travels.get(i).getDestinationCity()+" "+travels.get(i).getPrice()+" "+travels.get(i).getDay()+"/"+travels.get(i).getMonth()+"/"+travels.get(i).getYear();
            if((travels.get(i).getDay())==day && travels.get(i).getYear()==year && travels.get(i).getMonth()==mounth && travels.get(i).getDestinationCity().equals(destination )&&travels.get(i).getOriginCity().equals(origin)){
                travelsWillBeListed.add(travels.get(i).getTime() +" "+travels.get(i).getDestinationCity()+" "+travels.get(i).getOriginCity()+" "+travels.get(i).getPrice()+" "+travels.get(i).getDay()+"/"+travels.get(i).getMonth()+"/"+travels.get(i).getYear());
            }

        }
        return travelsWillBeListed;
    }

    @Test
    public void testTravelDetails() throws Exception {
        travels.add(tr1);
        travels.add(tr2);
        travels.add(tr3);
        travels.add(tr4);
        ArrayList<String> result = new ArrayList<String>();
        result.add("time destinationCity originCity 10.0 1/1/2016");
        assertEquals(result, travelDetails());


    }

}