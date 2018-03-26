package com.kotlin.demo.repositories

import com.kotlin.demo.OldPersonJPA
import org.springframework.data.repository.CrudRepository
import reactor.core.publisher.Flux

interface OldPersonJPARepository : CrudRepository<OldPersonJPA, Long> {
    fun findByFirstName(firstName: String): Flux<List<OldPersonJPA>>
    fun findByLastName(lastName: String): Flux<List<OldPersonJPA>>
}