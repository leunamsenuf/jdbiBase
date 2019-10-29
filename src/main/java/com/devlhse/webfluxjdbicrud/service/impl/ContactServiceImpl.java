package com.devlhse.webfluxjdbicrud.service.impl;

import com.devlhse.webfluxjdbicrud.model.Contact;
import com.devlhse.webfluxjdbicrud.repository.ContactRepository;
import com.devlhse.webfluxjdbicrud.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Mono<Contact> create(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Mono<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }

}
