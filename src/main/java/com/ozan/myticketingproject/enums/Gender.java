package com.ozan.myticketingproject.enums;

public enum Gender {
    //we put private final variable, constructor, and Getter
    // this is for using modified version of the value, with space, capital letter, small letter etc.
    MALE("Male"),FEMALE("Female");
    private final String value;
    Gender(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
