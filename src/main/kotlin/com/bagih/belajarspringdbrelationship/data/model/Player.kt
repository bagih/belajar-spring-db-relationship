package com.bagih.belajarspringdbrelationship.data.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne

@Entity
data class Player(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    var name: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    var playerProfile: PlayerProfile
)
