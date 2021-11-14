package com.tech.simplemovieapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films")
data class Film(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val type: String
)
