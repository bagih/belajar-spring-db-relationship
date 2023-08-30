package com.bagih.belajarspringdbrelationship.service

import com.bagih.belajarspringdbrelationship.data.model.Category
import com.bagih.belajarspringdbrelationship.data.model.Registration
import com.bagih.belajarspringdbrelationship.data.model.Tournament
import com.bagih.belajarspringdbrelationship.data.repository.TournamentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TournamentService(
    val repository: TournamentRepository
) {
    fun getAllTournaments(): List<Tournament>{
        return repository.findAll()
    }

    fun getTournamentById(id: Int): Tournament{
        return repository.findById(id).get()
    }

    fun addTournament(tournament: Tournament): Tournament{
        tournament.id = 0
        return repository.save(tournament)
    }

    fun deleteTournament(id: Int){
        repository.deleteById(id)
    }

    fun addRegistration(id: Int, registration: Registration): Tournament{
        val tournament: Tournament = repository.findById(id).get()
        tournament.addRegistration(registration)
        return repository.save(tournament)
    }

    fun removeRegistration(id: Int, registration: Registration): Tournament{
        val tournament: Tournament = repository.findById(id).get()
        tournament.removeRegistration(registration)
        return repository.save(tournament)
    }

    fun addCategory(id: Int, category: Category): Tournament{
        val tournament = repository.findById(id).get()
        tournament.addCategory(category)
        return repository.save(tournament)
    }

    fun removeCategory(id: Int, category: Category): Tournament{
        val tournament = repository.findById(id).get()
        tournament.removeCategory(category)
        return repository.save(tournament)
    }
}