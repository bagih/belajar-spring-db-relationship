package com.bagih.belajarspringdbrelationship.controller

import com.bagih.belajarspringdbrelationship.data.model.Category
import com.bagih.belajarspringdbrelationship.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/categories")
class CategoryController(
    val service: CategoryService
) {
    @GetMapping
    fun getAllCategories(): List<Category>{
        return service.getAllCategories()
    }

    @GetMapping("/{id}")
    fun getCategoryByID(@PathVariable id: Int): Category{
        return service.getCategoryById(id)
    }

    @PostMapping
    fun addCategory(@RequestBody category: Category): Category{
        return service.addCategory(category)
    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: Int){
        service.deleteCategory(id)
    }
}