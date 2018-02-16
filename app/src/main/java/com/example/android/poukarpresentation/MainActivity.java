package com.example.android.poukarpresentation;

import android.content.Intent;
import android.net.Uri;
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

        Company poukar = new Company("Poukar - české šperky",
                                     "Ing. Aleš Poukar",
                                     "+420602538800",
                                     "28. října 3346/91",
                                     "702 00 Ostrava")


        LinkedHashMap<String, String> openingHours = new LinkedHashMap<String, String>();
        openingHours.put(getString(R.string.monday), "7:00 - 16:00");
        openingHours.put(getString(R.string.tuesday), "7:00 - 16:00");
        openingHours.put(getString(R.string.wednesday), "7:00 - 16:00");
        openingHours.put(getString(R.string.thursday), "7:00 - 16:00");
        openingHours.put(getString(R.string.friday), "7:00 - 16:00");
        openingHours.put(getString(R.string.saturday), "closed");
        openingHours.put(getString(R.string.sunday), "closed");


        TextView executiveHead = (TextView) findViewById(R.id.executive_head_name);
        executiveHead.setText(getString(R.string.executive_head_name));

        TextView phoneNumberTextView = (TextView) findViewById(R.id.phone_number);
        phoneNumberTextView.setText(getString(R.string.phone_number));

        TextView openingDaysTextView = (TextView) findViewById(R.id.opening_days);
        TextView openingHoursTextView = (TextView) findViewById(R.id.opening_hours);
        for (String day : openingHours.keySet()) {
            openingDaysTextView.append(day + ":\n");
            openingHoursTextView.append(openingHours.get(day) + "\n");
        }


        TextView address = (TextView) findViewById(R.id.address);
        address.setText(poukar.getFirstLineOfAddress()
                "\n" + poukar.getSecondLineOfAddress());


    }

    public void dialPhoneNumber() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + getString(R.string.phone_number)));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
