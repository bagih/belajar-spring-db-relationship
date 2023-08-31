package com.bagih.belajarspringdbrelationship.data.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import org.hibernate.annotations.Cascade
import java.util.ArrayList

@Entity
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    @Column(unique = true)
    var name: String,

    @ManyToMany(
        mappedBy = "playingCategories",
        cascade = [CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH]
    )
    @JsonIgnoreProperties("playingCategories")
    private var tournaments: MutableList<Tournament>? = ArrayList()
){
}
