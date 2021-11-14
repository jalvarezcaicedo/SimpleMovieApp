package com.tech.simplemovieapp.data.model

import androidx.room.Entity

@Entity(tableName = "films", primaryKeys = ["name", "type"])
data class Film(
    val name: String,
    val type: String
)
