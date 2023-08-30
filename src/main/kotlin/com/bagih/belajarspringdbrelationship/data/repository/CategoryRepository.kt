package com.bagih.belajarspringdbrelationship.data.repository

import com.bagih.belajarspringdbrelationship.data.model.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository: JpaRepository<Category, Int> {
}