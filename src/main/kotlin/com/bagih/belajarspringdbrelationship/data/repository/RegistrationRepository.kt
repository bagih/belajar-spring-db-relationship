package com.bagih.belajarspringdbrelationship.data.repository

import com.bagih.belajarspringdbrelationship.data.model.Registration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RegistrationRepository: JpaRepository<Registration, Int> {
}