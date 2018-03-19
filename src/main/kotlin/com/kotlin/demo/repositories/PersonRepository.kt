package com.kotlin.demo.repositories

import com.kotlin.demo.Person
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

interface PersonRepository : ReactiveMongoRepository<Person, String> {

    fun findByFirstName(firstName: String): Flux<List<Person>>
    fun findByLastName(lastName: String): Flux<List<Person>>
}