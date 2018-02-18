package com.example.android.poukarpresentation;

import java.util.HashMap;

/**
 * Created by adam on 16.2.18.
 */

public class Company {
    private String mCompanyName;
    private String mCompanyType;
    private String mExecutiveHead;
    private String mPhoneNumber;
    private String mEmailAddress;
    private String mWebAddress;
    private String mAddressFirstLine;
    private String mAddressSecondLine;
    //public HashMap<int, int> openingHours;

    public Company(String companyName, String companyType, String executiveHead, String phoneNumber, String emailAddress, String webAddress, String addressFirstLine, String addressSecondLine) {
        mCompanyName = companyName;
        mCompanyType = companyType;
        mExecutiveHead = executiveHead;
        mPhoneNumber = phoneNumber;
        mEmailAddress = emailAddress;
        mWebAddress = webAddress;
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
    public String getEmailAddress() {
        return mEmailAddress;
    }

    public String getFirstLineOfAddress() {
        return mAddressFirstLine;
    }

    public String getSecondLineOfAddress() {
        return mAddressSecondLine;
    }

    public String getCompanyType() {
        return mCompanyType;
    }

    public String getWebAddress() {
        return mWebAddress;
    }

}
