package org.example;

import jakarta.persistence.*;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String buddyName;
    private String buddyPhonenumber;

    public BuddyInfo() {}

    public BuddyInfo(String name, String phoneNumber) {
        this.buddyName = name;
        this.buddyPhonenumber = phoneNumber;
    }
    public String getName() {
        return buddyName;
    }
    public String getNumber() {
        return buddyPhonenumber;
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
