package com.bagih.belajarspringdbrelationship.service

import com.bagih.belajarspringdbrelationship.data.model.Player
import com.bagih.belajarspringdbrelationship.data.model.PlayerProfile
import com.bagih.belajarspringdbrelationship.data.repository.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlayerService(
    @Autowired
    val repository: PlayerRepository
) {
    fun getAllPlayer(): List<Player>{
        return repository.findAll()
    }

    fun getPlayerById(id: Int): Player{
        return repository.findById(id).get()
    }

    fun addPlayer(player: Player): Player{
        player.id = 0
        return repository.save(player)
    }

    fun deletePlayerById(id: Int){
        repository.deleteById(id)
    }

    fun assignProfile(id: Int, profile: PlayerProfile): Player{
        val player = repository.findById(id).get()
        player.playerProfile = profile
        return repository.save(player)
    }
}