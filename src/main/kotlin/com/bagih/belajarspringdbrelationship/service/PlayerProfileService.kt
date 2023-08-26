package com.bagih.belajarspringdbrelationship.service

import com.bagih.belajarspringdbrelationship.data.model.PlayerProfile
import com.bagih.belajarspringdbrelationship.data.repository.PlayerProfileRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlayerProfileService(
    @Autowired
    val repository: PlayerProfileRepository
) {
    fun getAllPlayerProfiles(): List<PlayerProfile>{
        return repository.findAll()
    }

    fun getPlayerProfileById(id: Int): PlayerProfile{
        return repository.findById(id).get()
    }

    fun addPlayerProfile(playerProfile: PlayerProfile): PlayerProfile{
        playerProfile.id = 0
        return repository.save(playerProfile)
    }

    fun deletePlayerProfileById(id: Int){
        repository.deleteById(id)
    }
}