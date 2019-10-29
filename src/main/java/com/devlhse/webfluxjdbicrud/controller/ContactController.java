package com.devlhse.webfluxjdbicrud.controller;

import com.devlhse.webfluxjdbicrud.model.request.ContactRequest;
import com.devlhse.webfluxjdbicrud.model.response.ContactResponse;
import com.devlhse.webfluxjdbicrud.service.ContactService;
import com.devlhse.webfluxjdbicrud.utils.ContactUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
public class ContactController {

    private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping(path = "/contacts", consumes = "application/json")
    public Mono<ResponseEntity<ContactResponse>> create(@Valid @RequestBody ContactRequest contactRequest) {

        LOG.info(" Iniciando Registro de Contato com os seguintes dados: [{}]", contactRequest.toString());

        return contactService.create(ContactUtils.toModel(contactRequest))
                .map(ContactUtils::toResponse)
                .map(contactResponse -> new ResponseEntity<>(contactResponse, HttpStatus.CREATED));
    }

    @GetMapping("/contacts/{id}")
    public Mono<ResponseEntity<ContactResponse>> getContactById(@PathVariable(value = "id") Long contactId) {
        return contactService.findById(contactId)
                .map(ContactUtils::toResponse)
                .map(ownerResponse -> ResponseEntity.ok(ownerResponse))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
