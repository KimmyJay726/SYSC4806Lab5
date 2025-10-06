package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {
    @Test
    public void testGetName() {
        BuddyInfo buddy = new BuddyInfo("Andrew", "613-123-4567");
        assertEquals("Andrew", buddy.getName());
    }
    @Test
    public void testGetNumber() {
        BuddyInfo buddy = new BuddyInfo("Andrew", "613-123-4567");
        assertEquals("613-123-4567", buddy.getNumber());
    }
}