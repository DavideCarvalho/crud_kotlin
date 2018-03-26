package com.kotlin.demo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document
data class Person(
        @Id
        var id: String?,
        val firstName: String,
        val lastName: String)