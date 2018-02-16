package com.example.android.poukarpresentation;

import java.util.HashMap;

/**
 * Created by adam on 16.2.18.
 */

public class Company {
    private String mCompanyName;
    private String mExecutiveHead;
    private String mPhoneNumber;
    private String mAddressFirstLine;
    private String mAddressSecondLine;
    //public HashMap<int, int> openingHours;

    public Company(String companyName, String executiveHead, String phoneNumber, String addressFirstLine, String addressSecondLine) {
        mCompanyName = companyName;
        mExecutiveHead = executiveHead;
        mPhoneNumber = phoneNumber;
        mAddressFirstLine = addressFirstLine;
        mAddressSecondLine = addressSecondLine;
    }

    public String getCompanyName() {
        return mCompanyName;
    }

    public String getExecutiveHeadName() {
        return mExecutiveHead;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public String getFirstLineOfAddress() {
        return mAddressFirstLine;
    }

    public String getSecondLineOfAddress() {
        return mAddressSecondLine;
    }

}
