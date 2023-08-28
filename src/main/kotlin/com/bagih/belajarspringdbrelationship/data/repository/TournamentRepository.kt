package com.bagih.belajarspringdbrelationship.data.repository

import com.bagih.belajarspringdbrelationship.data.model.Tournament
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TournamentRepository: JpaRepository<Tournament, Int> {
}