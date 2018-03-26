package com.kotlin.demo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class PersonJpa(
        @Id
        @GeneratedValue
        val id: Long = 0,
        val firstName: String = "",
        val lastName: String = "")