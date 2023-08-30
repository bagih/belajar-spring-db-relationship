package com.bagih.belajarspringdbrelationship.service

import com.bagih.belajarspringdbrelationship.data.model.Category
import com.bagih.belajarspringdbrelationship.data.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    val repository: CategoryRepository
) {
    fun getAllCategories(): List<Category>{
        return repository.findAll()
    }

    fun getCategoryById(id: Int): Category{
        return repository.findById(id).get()
    }

    fun addCategory(category: Category): Category{
        category.id = 0
        return repository.save(category)
    }

    fun deleteCategory(id: Int){
        repository.deleteById(id)
    }
}