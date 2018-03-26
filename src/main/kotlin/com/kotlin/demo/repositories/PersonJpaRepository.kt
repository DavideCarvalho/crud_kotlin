package com.kotlin.demo.repositories

import com.kotlin.demo.PersonJpa
import org.springframework.data.repository.CrudRepository
import java.util.*

interface PersonJpaRepository : CrudRepository<PersonJpa, Long> {
    fun findByFirstName(firstName: String): Optional<List<PersonJpa>>
    fun findByLastName(lastName: String): Optional<List<PersonJpa>>
}