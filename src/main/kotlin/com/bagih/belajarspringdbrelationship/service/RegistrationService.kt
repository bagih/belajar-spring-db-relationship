package com.bagih.belajarspringdbrelationship.service

import com.bagih.belajarspringdbrelationship.data.model.Registration
import com.bagih.belajarspringdbrelationship.data.repository.RegistrationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RegistrationService(
    @Autowired
    val repository: RegistrationRepository
) {
    fun getAllRegistrations(): List<Registration>{
        return repository.findAll()
    }

    fun getRegistrationById(id: Int): Registration{
        return repository.findById(id).get()
    }

    fun addRegistration(registration: Registration): Registration{
        registration.id = 0
        return repository.save(registration)
    }

    fun deleteRegistration(id: Int){
        return repository.deleteById(id)
    }
}