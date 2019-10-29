package com.devlhse.webfluxjdbicrud.utils;

import com.devlhse.webfluxjdbicrud.model.Contact;
import com.devlhse.webfluxjdbicrud.model.request.ContactRequest;
import com.devlhse.webfluxjdbicrud.model.response.ContactResponse;

public class ContactUtils {

    public static ContactResponse toResponse(Contact contact) {
        return new ContactResponse.Builder()
                .id(contact.getId())
                .email(contact.getEmail())
                .phone(contact.getPhone())
                .name(contact.getName()).build();
    }

    public static Contact toModel(ContactRequest contactRequest){
        return new Contact.Builder()
                .name(contactRequest.getName())
                .email(contactRequest.getEmail())
                .phone(contactRequest.getPhone())
                .build();
    }
}
