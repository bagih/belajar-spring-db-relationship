package com.bagih.belajarspringdbrelationship.controller

import com.bagih.belajarspringdbrelationship.data.model.PlayerProfile
import com.bagih.belajarspringdbrelationship.service.PlayerProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/profiles")
class PlayerProfileController(
    @Autowired
    val service: PlayerProfileService
) {
    @GetMapping
    fun getAllPlayerProfiles(): List<PlayerProfile>{
        return service.getAllPlayerProfiles()
    }

    @GetMapping("/{id}")
    fun getPlayerProfileById(@PathVariable id: Int): PlayerProfile{
        return service.getPlayerProfileById(id)
    }

    @PostMapping
    fun addPlayerProfile(@RequestBody playerProfile: PlayerProfile): PlayerProfile{
        playerProfile.id = 0
        return service.addPlayerProfile(playerProfile)
    }

    @DeleteMapping("/{id}")
    fun deletePlayerById(@PathVariable id: Int){
        service.deletePlayerProfileById(id)
    }

}