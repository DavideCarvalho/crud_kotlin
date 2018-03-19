package com.kotlin.demo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document
class Person(
        @Id
        private val id: String,
        private val firstName: String,
        private val lastName: String) {


    override fun toString(): String {
        return "Person(id='$id', firstName='$firstName', lastName='$lastName')"
    }
}