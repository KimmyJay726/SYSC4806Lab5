package org.example;

import jakarta.persistence.*;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String buddyName;
    private String buddyPhonenumber;

    private String buddyAddress;

    public BuddyInfo() {}

    public BuddyInfo(String name, String phoneNumber, String address) {
        this.buddyName = name;
        this.buddyPhonenumber = phoneNumber;
        this.buddyAddress = address;
    }
    public String getName() {
        return buddyName;
    }
    public String getNumber() {
        return buddyPhonenumber;
    }
    public String getAddress() {
        return buddyAddress;
    }
    public int getId() {
        return id;
    }
    public void setBuddyName(String buddyName) {
        this.buddyName = buddyName;
    }

    public void setBuddyPhonenumber(String buddyPhonenumber) {
        this.buddyPhonenumber = buddyPhonenumber;
    }


    @Override
    public String toString() {
        return "Name: " + buddyName + ", Phone Number: " + buddyPhonenumber;
    }
}
