package com.example.bdtest.room.bd.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
data class UserWithTasks(
    @Embedded val user: User,
    @Relation(parentColumn = "idUser", entityColumn = "id_user_fk")
    val tasks: List<Task>

)
