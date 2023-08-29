package com.bagih.belajarspringdbrelationship.data.model

import jakarta.persistence.*

@Entity
data class Registration(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    @ManyToOne(cascade = [CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH])
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    var player: Player?
)