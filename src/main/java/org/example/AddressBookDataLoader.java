package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class AddressBookDataLoader implements CommandLineRunner {

    @Autowired
    private AddressBookRepo addressBookRepo;

    @Override
    public void run(String... args) throws Exception {
        AddressBook addressList = new AddressBook();
        addressList.addBuddy(new BuddyInfo("Andrew", "613-123-4567"));
        addressList.addBuddy(new BuddyInfo("John", "613-111-2222"));
        addressList.addBuddy(new BuddyInfo("Aaron", "613-333-4444"));

        addressBookRepo.save(addressList);
    }
}