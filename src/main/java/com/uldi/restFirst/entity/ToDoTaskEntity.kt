package com.uldi.restFirst.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class ToDoTaskEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long,
    val title: String,
    val isDone: Boolean,
    @ManyToOne
    @JoinColumn(name ="user_id")
    val user: UserEntity
)