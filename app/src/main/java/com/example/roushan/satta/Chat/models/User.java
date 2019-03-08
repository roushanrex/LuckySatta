package com.example.roushan.satta.Chat.models;

/**
 * Created by root on 14/2/18.
 */

public class User {
    String uid;
    String name;
    String email;
    String redeem;


    public User() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }



    public String getName() {
        return name;
    }

    public String getRedeem() {
        return redeem;
    }

    public void setRedeem(String redeem) {
        this.redeem = redeem;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", redeem='" + redeem + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
