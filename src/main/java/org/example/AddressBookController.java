package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookRepo addressBookRepository;

    @PostMapping
    public ResponseEntity<AddressBook> createAddressBook(@RequestBody AddressBook addressBook) {
        AddressBook savedAddressBook = addressBookRepository.save(addressBook);
        return new ResponseEntity<>(savedAddressBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/buddy")
    public ResponseEntity<AddressBook> addBuddyToAddressBook(
            @PathVariable Long id,
            @RequestBody BuddyInfo newBuddy) {

        AddressBook addressBook = addressBookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "AddressBook not found with ID: " + id));

        addressBook.addBuddy(newBuddy);

        AddressBook updatedAddressBook = addressBookRepository.save(addressBook);

        return new ResponseEntity<>(updatedAddressBook, HttpStatus.OK);
    }

    @DeleteMapping("/{abId}/buddy/{bId}")
    public ResponseEntity<AddressBook> removeBuddyFromAddressBook(
            @PathVariable Long abId,
            @PathVariable Long bId) {

        AddressBook addressBook = addressBookRepository.findById(abId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "AddressBook not found with ID: " + abId));

        boolean removed = addressBook.getBuddyList().removeIf(buddy -> buddy.getId() == bId);

        if (!removed) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Buddy not found with ID: " + bId + " in AddressBook " + abId);
        }

        AddressBook updatedAddressBook = addressBookRepository.save(addressBook);

        return new ResponseEntity<>(updatedAddressBook, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getAddressBook(@PathVariable Long id) {
        return addressBookRepository.findById(id)
                .map(addressBook -> new ResponseEntity<>(addressBook, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}