package com.devskiller.anonymizer;

public class Anonymizer {

    public static String anonymizeEmail(String email, char replacement) {
        //rewrite this method
        String mChar = Character.toString(replacement);
        email = email.replaceAll("(?<=.{3}).(?=.*@)", mChar);
        return email;
    }

    public static String anonymizeSkype(String skype, char replacement) {
        //rewrite this method
        String mChar = Character.toString(replacement);
        skype = skype.replaceAll(".", mChar);
        return skype;
    }

    public static String anonymizePhone(String phone, char replacement, int digits) {
        //rewrite this method
        if(phone.length() > digits){
            String mChar = Character.toString(replacement);
            String mSub =phone.substring(0, phone.length() - digits).replaceAll(".", mChar);
            phone = phone.substring(0,phone.length() - digits) + mSub;
        } else {
            String mChar = Character.toString(replacement);
            phone = phone.replaceAll(".", mChar);
        }
        return phone;
    }
}
