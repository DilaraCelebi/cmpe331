package com.example.ayberk.busreservationsystem;

/**
 * Created by ayberk on 10.12.2016.
 */

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by dilaracelebi on 9.12.2016.
 */

public class SpinnerAdapter extends ArrayAdapter<String> {
    public SpinnerAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        // TODO Auto-generated constructor stub

    }

    @Override
    public int getCount() {

        // TODO Auto-generated method stub
        int count = super.getCount();

        return count>0 ? count-1 : count ;


    }

}
