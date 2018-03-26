package com.kotlin.demo

import com.kotlin.demo.repositories.PersonJpaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
class PeopleJPAEndpoint(val personJpaRepository: PersonJpaRepository) {

    @GetMapping(value = ["/jpa/people"])
    fun getPeople(): MutableIterable<PersonJpa> {
        return this.personJpaRepository.findAll()
    }

    @PostMapping(value = ["/jpa/people"])
    fun insertPeople(@RequestBody person: PersonJpa): PersonJpa {
        return this.personJpaRepository.save(person)
    }

    @GetMapping(value = ["/jpa/people/{personId}"])
    fun getPerson(@PathVariable personId: Long): Optional<PersonJpa> {
        return this.personJpaRepository.findById(personId)
    }

    @GetMapping(value = ["/jpa/people/first-name/{personFirstName}"])
    fun getPeopleByFirstName(@PathVariable personFirstName: String): Optional<List<PersonJpa>> {
        return this.personJpaRepository.findByFirstName(personFirstName)
    }

    @GetMapping(value = ["/jpa/people/last-name/{personLastName}"])
    fun getPeopleByLastName(@PathVariable personLastName: String): Optional<List<PersonJpa>> {
        return this.personJpaRepository.findByLastName(personLastName)
    }

    @DeleteMapping(value = ["/jpa/people/{personId}"])
    fun deletePerson(@PathVariable personId: Long): ResponseEntity<String> {
        this.personJpaRepository.deleteById(personId)
        return ResponseEntity<String>(null, HttpStatus.OK)
    }

    @PutMapping(value = ["/jpa/people"])
    fun updatePerson(@RequestBody person: PersonJpa): PersonJpa {
        return this.personJpaRepository.save(person)
    }

}