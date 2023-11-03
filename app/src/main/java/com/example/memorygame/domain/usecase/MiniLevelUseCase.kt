package com.example.memorygame.domain.usecase

import com.example.memorygame.data.room.entity.GameEntity
import kotlinx.coroutines.flow.Flow

interface MiniLevelUseCase {
    fun getAllEasyLevel(): Flow<List<GameEntity>>

    fun getAllMediumLevel(): Flow<List<GameEntity>>

    fun getAllHardLevel(): Flow<List<GameEntity>>
}