package com.kotlin.demo

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
data class OldPersonJPA(
        @Id
        @GeneratedValue
        @JsonProperty("id")
        private val id: Long=0,
        @JsonProperty("firstName")
        private val firstName: String="teste",
        @JsonProperty("lastName")
        private val lastName: String="teste")