package com.bagih.belajarspringdbrelationship.controller

import com.bagih.belajarspringdbrelationship.data.model.Registration
import com.bagih.belajarspringdbrelationship.service.RegistrationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/registrations")
class RegistrationController(
    @Autowired
    val service: RegistrationService
) {
    @GetMapping
    fun getAllRegistrations(): List<Registration>{
        return service.getAllRegistrations()
    }

    @GetMapping("/{id}")
    fun getRegistrationById(@PathVariable id: Int): Registration{
        return service.getRegistrationById(id)
    }

    @PostMapping
    fun addRegistration(@RequestBody registration: Registration): Registration{
        return service.addRegistration(registration)
    }

    @DeleteMapping("/{id}")
    fun deleteRegistration(@PathVariable id: Int){
        service.deleteRegistration(id)
    }
}