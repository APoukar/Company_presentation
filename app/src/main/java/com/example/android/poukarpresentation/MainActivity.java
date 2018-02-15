package com.example.android.poukarpresentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinkedHashMap<String, String> openingHours = new LinkedHashMap<String, String>();
        openingHours.put(getString(R.string.monday), "7:00 - 16:00");
        openingHours.put(getString(R.string.tuesday), "7:00 - 16:00");
        openingHours.put(getString(R.string.wednesday), "7:00 - 16:00");
        openingHours.put(getString(R.string.thursday), "7:00 - 16:00");
        openingHours.put(getString(R.string.friday), "7:00 - 16:00");
        openingHours.put(getString(R.string.saturday), "closed");
        openingHours.put(getString(R.string.sunday), "closed");

        Calendar calendar = Calendar.getInstance();


        //openingHours.values().toArray()[0];


        TextView executiveHead = (TextView) findViewById(R.id.executive_head_name);
        executiveHead.setText("Ing. Aleš Poukar");

        TextView phoneNumber = (TextView) findViewById(R.id.phone_number);
        phoneNumber.setText("+420 620 538 800");

        TextView openingDaysTextView = (TextView) findViewById(R.id.opening_days);
        TextView openingHoursTextView = (TextView) findViewById(R.id.opening_hours);
        for (String day : openingHours.keySet()) {
            openingDaysTextView.append(day + ":\n");
            openingHoursTextView.append(openingHours.get(day) + "\n");
        }


        TextView address = (TextView) findViewById(R.id.address);
        address.setText("28. října 3346/91\n"
                        + "702 00 Ostrava");


    }
}
