package com.devlhse.webfluxjdbicrud.repository.impl;

import com.devlhse.webfluxjdbicrud.model.Contact;
import com.devlhse.webfluxjdbicrud.repository.ContactRepository;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.locator.ClasspathSqlLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Callable;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Repository
public class ContactRepositoryImpl implements ContactRepository {

    private final Jdbi jdbi;
    private final Scheduler jdbcScheduler;

    @Autowired
    public ContactRepositoryImpl(Jdbi jdbi, Scheduler jdbcScheduler) {
        this.jdbi = jdbi;
        this.jdbcScheduler = jdbcScheduler;
    }

    @Override
    public Mono<Contact> save(Contact contact) {
        return async(() -> {
            String sql = ClasspathSqlLocator.findSqlOnClasspath("sql.contact.contact-insert");

            return jdbi.withHandle(handle -> {

                Long contactId = handle.createUpdate(sql)
                        .bind("name", contact.getName())
                        .bind("email", contact.getEmail())
                        .bind("phone", contact.getPhone())
                        .executeAndReturnGeneratedKeys("id")
                        .mapTo(Long.class)
                        .findOnly();

                return contact;
            });
        });
    }

    @Override
    public Mono<Contact> findById(Long id) {
        String sql = ClasspathSqlLocator.findSqlOnClasspath("sql.contact.contact-find-by-id");
        return async(() -> this.jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bind("id", id)
                        .mapTo(Contact.class)
                        .findFirst()))
                .flatMap(Mono::justOrEmpty);
    }

    private <T> Flux<T> asyncFlux(Supplier<Stream<? extends T>> supplier) {
        return Flux.fromStream(supplier)
                .subscribeOn(jdbcScheduler)
                .publishOn(Schedulers.parallel());
    }

    private <T> Mono<T> async(Callable<T> supplier) {
        return Mono.fromCallable(supplier)
                .subscribeOn(jdbcScheduler)
                .publishOn(Schedulers.parallel());
    }
}
