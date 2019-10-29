package com.devlhse.webfluxjdbicrud.service;

import com.devlhse.webfluxjdbicrud.model.Contact;
import reactor.core.publisher.Mono;

public interface ContactService {

    Mono<Contact> create(Contact contact);

    Mono<Contact> findById(Long id);

}
