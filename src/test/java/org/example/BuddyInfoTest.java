package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {
    @Test
    public void testGetName() {
        BuddyInfo buddy = new BuddyInfo("Andrew", "613-123-4567", "1 Street");
        assertEquals("Andrew", buddy.getName());
    }
    @Test
    public void testGetNumber() {
        BuddyInfo buddy = new BuddyInfo("Andrew", "613-123-4567", "2 Street");
        assertEquals("613-123-4567", buddy.getNumber());
    }

    @Test
    public void testGetAddress() {
        BuddyInfo buddy = new BuddyInfo("John", "613-888-9999", "3 Street");
        assertEquals("3 Street", buddy.getAddress());
    }
}