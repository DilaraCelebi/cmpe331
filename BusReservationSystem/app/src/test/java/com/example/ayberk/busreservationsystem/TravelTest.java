package com.example.ayberk.busreservationsystem;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by x7evangelion on 12/15/16.
 */
public class TravelTest {

    Travel travel = new Travel("DestinationCity","OriginCity","Time",30.00,2016,02,01);

    @Test
    public void getDestinationCity() throws Exception {
        String result = travel.getDestinationCity();
        assertEquals("DestinationCity",result);
    }

    @Test
    public void getOriginCity() throws Exception {
        String result = travel.getOriginCity();
        assertEquals("OriginCity", result);
    }

    @Test
    public void getTime() throws Exception {
        String result = travel.getTime();
        assertEquals("Time", result);
    }

    @Test
    public void getPrice() throws Exception {
        Double result = travel.getPrice();
        assertEquals(30.00, result, 1);
    }


    @Test
    public void getYear() throws Exception {
        int result = travel.getYear();
        assertEquals(2016, result);
    }

    @Test
    public void getMonth() throws Exception {
        int result = travel.getMonth();
        assertEquals(02, result);
    }


    @Test
    public void getDay() throws Exception {
        int result = travel.getDay();
        assertEquals(01, result);
    }


}