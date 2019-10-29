package com.devlhse.webfluxjdbicrud.repository;

import com.devlhse.webfluxjdbicrud.model.Contact;
import reactor.core.publisher.Mono;

public interface ContactRepository {

    Mono<Contact> save(Contact contact);

    Mono<Contact> findById(Long id);
}
