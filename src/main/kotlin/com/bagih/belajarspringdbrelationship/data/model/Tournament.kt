package com.bagih.belajarspringdbrelationship.data.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany

@Entity
data class Tournament(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    var name: String,
    var location: String,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "")
    var registrations: MutableList<Registration>? = ArrayList()
) {
    fun addRegistration(registration: Registration){
        registrations?.add(registration)
    }

    fun removeRegistration(registration: Registration){
        registrations?.let {
            it.remove(registration)
        }
    }
}