package com.example.smartreminderlocationbased.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val locationName: String,
    val latitude: Double,
    val longitude: Double
) 