package com.ui.pojo;

public class AddressPOJO {



    private String company;
    private String city;
    private String addressLine1;
    private String addressLine2;
    private String postCode;
    private String homePhoneNumber;
    private String mobileNUmber;
    private String otherInformation;
    private String addressAlias;
    private String state;

    public AddressPOJO(String company, String city, String addressLine1, String addressLine2,
                       String postCode, String homePhoneNumber, String mobileNUmber,
                       String otherInformation, String addressAlias, String state) {
        this.company = company;
        this.city = city;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.postCode = postCode;
        this.homePhoneNumber = homePhoneNumber;
        this.mobileNUmber = mobileNUmber;
        this.otherInformation = otherInformation;
        this.addressAlias = addressAlias;
        this.state = state;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public String getMobileNUmber() {
        return mobileNUmber;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public String getAddressAlias() {
        return addressAlias;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "AddressPOJO{" +
                "company='" + company + '\'' +
                ", city='" + city + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", postCode='" + postCode + '\'' +
                ", homePhoneNumber='" + homePhoneNumber + '\'' +
                ", mobileNUmber='" + mobileNUmber + '\'' +
                ", otherInformation='" + otherInformation + '\'' +
                ", addressAlias='" + addressAlias + '\'' +
                ", state='" + state + '\'' +
                '}';
    }




}
