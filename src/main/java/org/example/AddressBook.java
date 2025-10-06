package org.example;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Bonus round
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ADDRESSBOOK_ID")
    public List<BuddyInfo> buddyList = new ArrayList<>();

    public AddressBook() {}
    public void addBuddy(BuddyInfo newBuddy){
        buddyList.add(newBuddy);
    }
    public int getId() {
        return id;
    }
    public List<BuddyInfo> getBuddyList() {
        return buddyList;
    }

}