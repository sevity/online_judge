package com.sevity.problemservice.service

import com.sevity.problemservice.domain.Problem
import com.sevity.problemservice.domain.ProblemRepository
import org.springframework.stereotype.Service

@Service
class ProblemService(private val problemRepository: ProblemRepository) {

    fun getAllProblems(): List<Problem> = problemRepository.findAll()
    fun createProblem(problem: Problem): Problem = problemRepository.save(problem)
    fun getProblem(id: Int): Problem = problemRepository.findById(id).orElseThrow { NoSuchElementException("Problem not found") }
    fun updateProblem(id: Int, problem: Problem): Problem {
        val existingProblem = problemRepository.findById(id).orElseThrow { NoSuchElementException("Problem not found") }
        val updatedProblem = existingProblem.copy(
            title = problem.title,
            description = problem.description,
            exampleInput = problem.exampleInput,
            exampleOutput = problem.exampleOutput,
            realInput = problem.realInput,
            realOutput = problem.realOutput
        )
        return problemRepository.save(updatedProblem)
    }

    fun deleteProblem(id: Int) {
        val existingProblem = problemRepository.findById(id).orElseThrow { NoSuchElementException("Problem not found") }
        problemRepository.delete(existingProblem)
    }



    // Add more methods as needed for CRUD operations
}
