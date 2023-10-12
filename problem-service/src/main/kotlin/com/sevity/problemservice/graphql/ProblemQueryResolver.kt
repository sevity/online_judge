// src/main/kotlin/com/sevity/problemservice/graphql/ProblemQueryResolver.kt

package com.sevity.problemservice.graphql

import com.expediagroup.graphql.server.operations.Query
import com.sevity.problemservice.domain.Problem
import com.sevity.problemservice.domain.ProblemRepository
import org.springframework.stereotype.Component

@Component
class ProblemQueryResolver(
    private val problemRepository: ProblemRepository
) : Query {
    fun problem(id: Int): Problem? {
        return problemRepository.findById(id).orElse(null)
    }

    fun problems(): List<Problem> {
        return problemRepository.findAll().toList()
    }
}
