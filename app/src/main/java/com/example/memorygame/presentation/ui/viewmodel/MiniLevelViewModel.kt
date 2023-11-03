package com.example.memorygame.presentation.ui.viewmodel

import com.example.memorygame.data.room.entity.GameEntity
import kotlinx.coroutines.flow.Flow

interface MiniLevelViewModel {

    val easyLevelsList: Flow<List<GameEntity>>
    val mediumLevelsList: Flow<List<GameEntity>>
    val hardLevelsList: Flow<List<GameEntity>>

    fun back()

    fun openGameScreen(gameEntity: GameEntity)

    fun generateEasy()
    fun generateMedium()
    fun generateHard()
}