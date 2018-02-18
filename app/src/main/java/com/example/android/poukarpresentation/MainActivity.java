package com.example.android.poukarpresentation;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.views.BannerSlider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        HashMap of the information about company
         */
        final HashMap<String, String> poukar = new HashMap<>();
        poukar.put("Company Name", "Poukar - české šperky");
        poukar.put("Company Type", getString(R.string.wholesale));
        poukar.put("Executive Head", "Ing. Aleš Poukar");
        poukar.put("Phone number", "+420 602 538 800");
        poukar.put("Email Address", "obchod@ceskesperky.cz");
        poukar.put("Web Address", "www.ceskesperky.cz");
        poukar.put("Address first line", "28. října 3346/91");
        poukar.put("Address second line", "702 00 Ostrava");

        /*
        HashMap of the opening times of the office
         */
        LinkedHashMap<String, String> openingHours = new LinkedHashMap<String, String>();
        openingHours.put(getString(R.string.monday), "7:00 - 16:00");
        openingHours.put(getString(R.string.tuesday), "7:00 - 16:00");
        openingHours.put(getString(R.string.wednesday), "7:00 - 16:00");
        openingHours.put(getString(R.string.thursday), "7:00 - 16:00");
        openingHours.put(getString(R.string.friday), "7:00 - 16:00");
        openingHours.put(getString(R.string.saturday), "zavřeno");
        openingHours.put(getString(R.string.sunday), "zavřeno");

        /*
        Defines and sets the photo slider
        at the top of the app
         */
        BannerSlider bannerSlider = (BannerSlider) findViewById(R.id.banner_slider1);
        List<Banner> banners=new ArrayList<>();
        //add banner using resource drawable
        banners.add(new DrawableBanner(R.drawable.logo));
        banners.add(new DrawableBanner(R.drawable.shop2));
        for (int i=0; i < banners.size(); i++) {
            banners.get(i).setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        bannerSlider.setBanners(banners);

        /*
        Retrieves the information about the company
        from the HashMap poukar and passes the values
        to the relevant TextViews
         */
        TextView companyNameTextView = (TextView) findViewById(R.id.company_name);
        companyNameTextView.setText(poukar.get("Company Name"));

        TextView companyDescription = (TextView) findViewById(R.id.company_description);
        companyDescription.setText(poukar.get("Company Type"));

        TextView executiveHead = (TextView) findViewById(R.id.executive_head_name);
        executiveHead.setText(poukar.get("Executive Head"));

        TextView phoneNumberTextView = (TextView) findViewById(R.id.phone_number);
        phoneNumberTextView.setText(poukar.get("Phone number"));

        TextView emailAddressTextView = (TextView) findViewById(R.id.email_address);
        emailAddressTextView.setText(poukar.get("Email Address"));

        TextView webAddressTextView = (TextView) findViewById(R.id.web_address);
        webAddressTextView.setText(poukar.get("Web Address"));

        TextView address = (TextView) findViewById(R.id.address);
        address.setText(poukar.get("Address first line") +
                "\n" + poukar.get("Address second line"));

        /*
        Loops through openingHours HashMap
        and passes the days and opening times
        to the TextView
         */
        TextView openingDaysTextView = (TextView) findViewById(R.id.opening_days);
        TextView openingHoursTextView = (TextView) findViewById(R.id.opening_hours);
        for (String day : openingHours.keySet()) {
            openingDaysTextView.append(day + ":\n");
            openingHoursTextView.append(openingHours.get(day) + "\n");
        }

        /*
        Sets what should happen
        after clicking on the particular layouts
         */
        LinearLayout phoneNumberLayout = (LinearLayout) findViewById(R.id.phone_number_layout);
        phoneNumberLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber(poukar.get("Phone number"));
            }
        });

        LinearLayout emailAddressLayout = (LinearLayout) findViewById(R.id.email_address_layout);
        emailAddressLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail(poukar.get("Email Address"));
            }
        });

        LinearLayout webAddressLayout = (LinearLayout) findViewById(R.id.web_address_layout);
        webAddressLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage(poukar.get("Web Address"));
            }
        });

        LinearLayout addressLinearLayout = (LinearLayout) findViewById(R.id.address_layout);
        addressLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMap((poukar.get("Address first line")
                        + " " + poukar.get("Address second line")));
            }
        });


    }

    /*
    After calling this function it takes
    the phone number of the poukar HashMap
    and passes it to the phone dialer
     */
    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /*
    Opens e-mail app. Passes the email address
    from poukar HashMap & subject from strings.xml
     */
    public void sendEmail(String emailAddress) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + emailAddress +
                "?subject=" + getString(R.string.email_subject)));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /*
    Opens the web browser and passes
    the web address from poukar HashMap
     */
    public void openWebPage(String url) {
        Uri webpage = Uri.parse("http://" + url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /*
    Opens the navigation app and passes
    the address from poukar HashMap
     */
    public void showMap(String address) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=" + address));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
