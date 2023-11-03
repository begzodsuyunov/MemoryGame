package com.example.memorygame.data.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.memorygame.data.room.entity.GameEntity

interface BaseDao<T> {

    @Insert
    fun insert(t: List<T>)

    @Update
    fun update(entity: GameEntity)

    @Delete
    fun delete(entity: GameEntity)
}