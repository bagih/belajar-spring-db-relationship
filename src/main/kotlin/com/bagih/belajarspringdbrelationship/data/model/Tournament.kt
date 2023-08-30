package com.bagih.belajarspringdbrelationship.data.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
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
    var registrations: MutableList<Registration>? = ArrayList(),

    @ManyToMany(cascade = [CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH])
    @JoinTable(
        name = "tournament_categories",
        joinColumns = [JoinColumn(name = "tournament_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    @JsonIgnoreProperties("tournaments")
    var playingCategories: MutableList<Category>? = ArrayList()
) {
    fun addRegistration(registration: Registration){
        registrations?.add(registration)
    }

    fun removeRegistration(registration: Registration){
        registrations?.let {
            it.remove(registration)
        }
    }

    fun addCategory(category: Category){
        playingCategories?.add(category)
    }

    fun removeCategory(category: Category){
        playingCategories?.let {
            it.remove(category)
        }
    }

}