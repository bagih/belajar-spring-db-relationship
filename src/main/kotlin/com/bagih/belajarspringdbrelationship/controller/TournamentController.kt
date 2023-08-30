package com.bagih.belajarspringdbrelationship.controller

import com.bagih.belajarspringdbrelationship.data.model.Category
import com.bagih.belajarspringdbrelationship.data.model.Registration
import com.bagih.belajarspringdbrelationship.data.model.Tournament
import com.bagih.belajarspringdbrelationship.service.CategoryService
import com.bagih.belajarspringdbrelationship.service.RegistrationService
import com.bagih.belajarspringdbrelationship.service.TournamentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tournaments")
class TournamentController(
    val tournamentService: TournamentService,
    val registrationService: RegistrationService,
    val categoryService: CategoryService
) {
    @GetMapping
    fun getAllTournaments(): List<Tournament>{
        return tournamentService.getAllTournaments()
    }

    @GetMapping("/{id}")
    fun getTournamentById(@PathVariable id: Int): Tournament{
        return tournamentService.getTournamentById(id)
    }

    @PostMapping
    fun addTournament(@RequestBody tournament: Tournament): Tournament{
        return tournamentService.addTournament(tournament)
    }

    @DeleteMapping("/{id}")
    fun deleteTournament(@PathVariable id: Int){
        tournamentService.deleteTournament(id)
    }

    @PutMapping("/{id}/registrations/{registrationId}")
    fun addRegistration(@PathVariable id: Int, @PathVariable registrationId: Int): Tournament{
        val registration: Registration = registrationService.getRegistrationById(registrationId)
        println(registration.toString())
        return tournamentService.addRegistration(id, registration)
    }

    @PutMapping("/{id}/remove_registrations/{registrationId}")
    fun removeRegistration(@PathVariable id: Int, @PathVariable registrationId: Int): Tournament{
        val registration: Registration = registrationService.getRegistrationById(registrationId)
        println(registration.toString())
        return tournamentService.removeRegistration(id, registration)
    }

    @PutMapping("/{id}/add_category/{categoryId}")
    fun addCategory(@PathVariable id: Int, @PathVariable categoryId: Int): Tournament{
        val category: Category = categoryService.getCategoryById(categoryId)
        println(category.toString())
        return tournamentService.addCategory(id, category)
    }

    @PutMapping("/{id}/remove_category/{categoryId}")
    fun removeCategory(@PathVariable id: Int, @PathVariable categoryId: Int): Tournament{
        val category: Category = categoryService.getCategoryById(categoryId)
        println(category.toString())
        return tournamentService.removeCategory(id, category)
    }
}