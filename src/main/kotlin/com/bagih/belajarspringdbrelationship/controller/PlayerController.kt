package com.bagih.belajarspringdbrelationship.controller

import com.bagih.belajarspringdbrelationship.data.model.Player
import com.bagih.belajarspringdbrelationship.service.PlayerProfileService
import com.bagih.belajarspringdbrelationship.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/players")
class PlayerController(
    @Autowired
    val playerService: PlayerService,
    @Autowired
    val playerProfileService: PlayerProfileService
) {
    @GetMapping
    fun getAllPlayers(): List<Player>{
        return playerService.getAllPlayer()
    }

    @GetMapping("/{id}")
    fun getPlayerById(@PathVariable id: Int): Player{
        return playerService.getPlayerById(id)
    }

    @PostMapping
    fun addPlayer(@RequestBody player: Player): Player{
        return playerService.addPlayer(player)
    }

    @DeleteMapping("/{id}")
    fun deletePlayerById(@PathVariable id: Int){
        playerService.deletePlayerById(id)
    }

    @PutMapping("/{id}/profiles/{profile_id}")
    fun assignDetail(@PathVariable id: Int, @PathVariable profile_id: Int): Player{
        val profile = playerProfileService.getPlayerProfileById(profile_id)
        println(profile)
        return playerService.assignProfile(id, profile)
    }
}