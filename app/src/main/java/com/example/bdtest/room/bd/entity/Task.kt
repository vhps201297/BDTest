package com.example.bdtest.room.bd.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) private val idTask: Int,
    @ColumnInfo(name = "id_user_fk") var idUserFK: Long,
    @ColumnInfo(name = "name_task") var nameTask: String,
    @ColumnInfo(name = "is_check") var isCheck: Boolean,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "date_finished") var dateFinished: String
)
