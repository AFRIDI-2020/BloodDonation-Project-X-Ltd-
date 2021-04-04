package com.example.blooddonation;

public class User {

    private String username;
    private String email;
    private String phoneNo;
    private String altPhoneNo;
    private String social;
    private String bloodGroup;
    private String weight;
    private String gender;
    private String street;
    private String city;
    private String postalCode;
    private String age;
    private String birthDate;
    private String profileImageLink;

    public User() {
    }

    public User(String username, String email, String phoneNo, String altPhoneNo, String social, String bloodGroup, String weight, String gender, String street, String city, String postalCode, String age, String birthDate, String profileImageLink) {
        this.username = username;
        this.email = email;
        this.phoneNo = phoneNo;
        this.altPhoneNo = altPhoneNo;
        this.social = social;
        this.bloodGroup = bloodGroup;
        this.weight = weight;
        this.gender = gender;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.age = age;
        this.birthDate = birthDate;
        this.profileImageLink = profileImageLink;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getAltPhoneNo() {
        return altPhoneNo;
    }

    public String getSocial() {
        return social;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAge() {
        return age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getProfileImageLink() {
        return profileImageLink;
    }
}
