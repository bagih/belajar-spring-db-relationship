package com.bagih.belajarspringdbrelationship.data.repository

import com.bagih.belajarspringdbrelationship.data.model.PlayerProfile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerProfileRepository: JpaRepository<PlayerProfile, Int> {
}