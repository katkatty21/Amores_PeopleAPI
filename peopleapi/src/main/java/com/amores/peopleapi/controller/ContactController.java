package com.amores.peopleapi.controller;

import com.amores.peopleapi.service.GoogleContactsService;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final GoogleContactsService contactsService;

    public ContactController(GoogleContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @GetMapping
    public ResponseEntity<String> getContacts(@RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient client) {
        return contactsService.getContacts(client);
    }

    @PostMapping("/add")
    public String addContact(@RequestBody Map<String, String> contactData) {
        // Logic to add a new contact (Google Contacts API needed)
        return "Contact added!";
    }

    @PutMapping("/edit/{id}")
    public String editContact(@PathVariable String id, @RequestBody Map<String, String> contactData) {
        // Logic to update an existing contact (Google Contacts API needed)
        return "Contact updated!";
    }

    @DeleteMapping("/remove/{id}")
    public String removeContact(@PathVariable String id) {
        // Logic to remove a contact (Google Contacts API needed)
        return "Contact removed!";
    }
}