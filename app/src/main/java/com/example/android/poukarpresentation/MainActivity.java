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
import java.util.LinkedHashMap;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.views.BannerSlider;

public class MainActivity extends AppCompatActivity {

    Company poukar = new Company("Poukar - české šperky",
            "Velkoobchod",
            "Ing. Aleš Poukar",
            "+420 602 538 800",
            "obchod@ceskesperky.cz",
            "www.ceskesperky.cz",
            "28. října 3346/91",
            "702 00 Ostrava");

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
        openingHours.put(getString(R.string.saturday), "zavřeno");
        openingHours.put(getString(R.string.sunday), "zavřeno");

        BannerSlider bannerSlider = (BannerSlider) findViewById(R.id.banner_slider1);
        List<Banner> banners=new ArrayList<>();
        //add banner using resource drawable
        banners.add(new DrawableBanner(R.drawable.logo));
        banners.add(new DrawableBanner(R.drawable.shop2));
        for (int i=0; i < banners.size(); i++) {
            banners.get(i).setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        bannerSlider.setBanners(banners);

        //Sets the
        TextView companyNameTextView = (TextView) findViewById(R.id.company_name);
        companyNameTextView.setText(poukar.getCompanyName());

        TextView companyDescription = (TextView) findViewById(R.id.company_description);
        companyDescription.setText(poukar.getCompanyType());

        TextView executiveHead = (TextView) findViewById(R.id.executive_head_name);
        executiveHead.setText(poukar.getExecutiveHeadName());

        LinearLayout phoneNumberLayout = (LinearLayout) findViewById(R.id.phone_number_layout);
        phoneNumberLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber(poukar.getPhoneNumber());
            }
        });

            TextView phoneNumberTextView = (TextView) findViewById(R.id.phone_number);
        phoneNumberTextView.setText(poukar.getPhoneNumber());

        LinearLayout emailAddressLayout = (LinearLayout) findViewById(R.id.email_address_layout);
        emailAddressLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail(poukar.getEmailAddress());
            }
        });

        TextView emailAddressTextView = (TextView) findViewById(R.id.email_address);
        emailAddressTextView.setText(poukar.getEmailAddress());

        LinearLayout webAddressLayout = (LinearLayout) findViewById(R.id.web_address_layout);
        webAddressLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage(poukar.getWebAddress());
            }
        });

        TextView webAddressTextView = (TextView) findViewById(R.id.web_address);
        webAddressTextView.setText(poukar.getWebAddress());

        TextView openingDaysTextView = (TextView) findViewById(R.id.opening_days);
        TextView openingHoursTextView = (TextView) findViewById(R.id.opening_hours);
        for (String day : openingHours.keySet()) {
            openingDaysTextView.append(day + ":\n");
            openingHoursTextView.append(openingHours.get(day) + "\n");
        }

        LinearLayout addressLinearLayout = (LinearLayout) findViewById(R.id.address_layout);
        addressLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMap(poukar.getFirstLineOfAddress()
                        + " " + poukar.getSecondLineOfAddress());
            }
        });

        TextView address = (TextView) findViewById(R.id.address);
        address.setText(poukar.getFirstLineOfAddress() +
                "\n" + poukar.getSecondLineOfAddress());


    }

    /*
    After calling this function it takes
    the phone number of the object
    and pass it to the phone dialer
     */
    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void sendEmail(String emailAddress) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + emailAddress +
                "?subject=" + getString(R.string.email_subject)));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse("http://" + url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showMap(String address) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=" + address));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
