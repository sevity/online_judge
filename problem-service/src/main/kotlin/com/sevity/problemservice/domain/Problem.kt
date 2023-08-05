package com.sevity.problemservice.domain

import javax.persistence.*

@Entity
@Table(name = "problems")
data class Problem(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val title: String = "",

    @Column(nullable = false)
    val description: String = "",

    @Column(name = "example_input", nullable = false)
    val exampleInput: String = "",

    @Column(name = "example_output", nullable = false)
    val exampleOutput: String = ""
)
