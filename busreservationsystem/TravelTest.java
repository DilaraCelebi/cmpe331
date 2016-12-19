package com.example.ayberk.busreservationsystem;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by x7evangelion on 12/19/16.
 */
public class TravelTest {


    Travel travel = new Travel("Destination", "Origin", "Time", 70.00, 2017, 01, 02);



    @Test
    public void getDestinationCity() throws Exception {
        String result = travel.getDestinationCity();
        assertEquals("Destination", result);
    }

    @Test
    public void getOriginCity() throws Exception {
        String result = travel.getOriginCity();
        assertEquals("Origin", result);
    }

    @Test
    public void getTime() throws Exception {
        String result = travel.getTime();
        assertEquals("Time", result);
    }

    @Test
    public void getPrice() throws Exception {
        double result = travel.getPrice();
        assertEquals(70.00, result,1);
    }

    @Test
    public void getYear() throws Exception {
        int result = travel.getYear();
        assertEquals(2017, result);
    }

    @Test
    public void getMonth() throws Exception {
        int result = travel.getMonth();
        assertEquals(01, result);
    }

    @Test
    public void getDay() throws Exception {
        int result = travel.getDay();
        assertEquals(02, result);
    }



}