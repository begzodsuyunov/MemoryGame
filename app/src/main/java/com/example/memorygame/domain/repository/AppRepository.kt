package com.example.memorygame.domain.repository

import com.example.memorygame.data.model.GameModel
import com.example.memorygame.data.room.entity.GameEntity
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    fun getAllEasyLevel(): Flow<List<GameEntity>>

    fun getAllMediumLevel(): Flow<List<GameEntity>>

    fun getAllHardLevel(): Flow<List<GameEntity>>

    fun update(entity: GameEntity)

    fun getLevel(): Flow<String>

    suspend fun openNextLevel(level: Int, number: Int)

    suspend fun setLevel(level: String)

    fun getByNumber(level: Int, number: Int): Flow<List<GameModel>>

}