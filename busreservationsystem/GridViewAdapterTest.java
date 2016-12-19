package com.example.ayberk.busreservationsystem;

import android.app.Activity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by x7evangelion on 12/19/16.
 */
public class GridViewAdapterTest {

    String[] testArray = {"test1","test2","test3","test4","test5"};
    Activity ac;
    GridViewAdapter gva = new GridViewAdapter(testArray, ac);

    @Test
    public void getCount() throws Exception {
        int result = gva.getCount();
        assertEquals(5,result);
    }

    @Test
    public void getItem() throws Exception {
        Object result = gva.getItem(2);
        assertEquals("test3",result);
    }

    @Test
    public void getItemId() throws Exception {
        Long result = gva.getItemId(2);
        assertSame(2L,result);
    }


}