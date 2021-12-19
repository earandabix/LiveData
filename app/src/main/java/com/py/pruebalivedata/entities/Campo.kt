package com.py.pruebalivedata.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Campo")
data class Campo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String = ""
) {
    override fun toString(): String {
        return nombre
    }
}