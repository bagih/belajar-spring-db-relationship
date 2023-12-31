package com.bagih.belajarspringdbrelationship.data.model

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
data class Player(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,

    var name: String?,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    var playerProfile: PlayerProfile?,

    @OneToMany(mappedBy = "player", cascade = [CascadeType.ALL])
    var registrations: MutableList<Registration>? = ArrayList()
){
    fun registerPlayer(registration: Registration){
        registrations?.add(registration)
        registration.player = this
    }

    fun removeRegistration(registration: Registration){
        registrations?.remove(registration)
        registration.player = null
    }
}
