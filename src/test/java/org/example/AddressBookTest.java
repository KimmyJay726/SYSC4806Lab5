package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class AddressBookTest {
    @Test
    public void testAddBuddy() {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddy = new BuddyInfo("Andrew", "613-123-4567");
        addressBook.addBuddy(buddy);
        assertEquals("Name: Andrew, Phone Number: 613-123-4567", addressBook.buddyList.get(0).toString());
    }
}