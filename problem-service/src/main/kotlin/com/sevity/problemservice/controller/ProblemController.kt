package com.sevity.problemservice.controller

import com.sevity.problemservice.domain.Problem
import com.sevity.problemservice.service.ProblemService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/problems")
class ProblemController(private val problemService: ProblemService) {

    @GetMapping
    fun getAllProblems() = problemService.getAllProblems()

    @GetMapping("/{id}")
    fun getProblem(@PathVariable id: Long): Problem = problemService.getProblem(id)


    @PostMapping
    fun createProblem(@RequestBody problem: Problem): Problem = problemService.createProblem(problem)

    @PutMapping("/{id}")
    fun updateProblem(@PathVariable id: Long, @RequestBody problem: Problem): Problem = problemService.updateProblem(id, problem)

    // Add more methods as needed for CRUD operations
}
