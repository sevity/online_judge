package com.sevity.problemservice.controller

import com.sevity.problemservice.domain.Problem
import com.sevity.problemservice.service.ProblemService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/problems")
class ProblemController(private val problemService: ProblemService) {

    @GetMapping
    fun getAllProblems() = problemService.getAllProblems()

    @GetMapping("/{id}")
    fun getProblem(@PathVariable id: Int): Problem = problemService.getProblem(id)


    @PostMapping
    fun createProblem(@RequestBody problem: Problem): Problem = problemService.createProblem(problem)

    @PutMapping("/{id}")
    fun updateProblem(@PathVariable id: Int, @RequestBody problem: Problem): Problem = problemService.updateProblem(id, problem)

    @DeleteMapping("/{id}")
    fun deleteProblem(@PathVariable id: Int): ResponseEntity<Void> {
        problemService.deleteProblem(id)
        return ResponseEntity<Void>(HttpStatus.NO_CONTENT)
    }

    // Add more methods as needed for CRUD operations
}
