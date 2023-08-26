package com.bagih.belajarspringdbrelationship.data.repository

import com.bagih.belajarspringdbrelationship.data.model.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository: JpaRepository<Player, Int> {
}