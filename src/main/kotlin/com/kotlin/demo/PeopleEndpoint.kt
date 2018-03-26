package com.kotlin.demo

import com.kotlin.demo.repositories.PersonRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
class PeopleEndpoint(val personRepository: PersonRepository, var personId: Int = 1) {


    @GetMapping(value = ["/people"])
    fun getPeople(): Flux<Person> {
        return this.personRepository.findAll()
    }

    @GetMapping(value = ["/people/{personId}"])
    fun getPerson(@PathVariable personId: String): Mono<Person> {
        return this.personRepository.findById(personId)
    }

    @GetMapping(value = ["/people/first-name/{personFirstName}"])
    fun getPeopleByFirstName(@PathVariable personFirstName: String): Flux<List<Person>> {
        return this.personRepository.findByFirstName(personFirstName)
    }

    @GetMapping(value = ["/people/last-name/{personLastName}"])
    fun getPeopleByLastName(@PathVariable personLastName: String): Flux<List<Person>> {
        return this.personRepository.findByLastName(personLastName)
    }

    @DeleteMapping(value = ["/people/{personId}"])
    fun deletePerson(@PathVariable personId: String): ResponseEntity<String> {
        this.personRepository.deleteById(personId)
        return ResponseEntity<String>(null, HttpStatus.OK)
    }

    @PostMapping(value = ["/people"])
    fun addPerson(@RequestBody person: Person): Mono<Person> {
        person.id = this.personId.toString()
        this.personId++
        return this.personRepository.save(person)
    }

    @PutMapping(value = ["/people"])
    fun updatePerson(@RequestBody person: Person): Mono<Person> {
        return this.personRepository.insert(person)
    }

}