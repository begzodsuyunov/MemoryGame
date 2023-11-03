package com.example.memorygame.presentation.ui.viewmodel

import com.example.memorygame.data.model.GameModel
import com.example.memorygame.data.room.entity.GameEntity
import kotlinx.coroutines.flow.Flow

interface GameViewModel {

    val gameModelLiveData: Flow<List<GameModel>>

    fun back()

    fun getByNumber(level: Int, number: Int)

    fun saveResult(entity: GameEntity)

    fun btnClicked(state: Boolean, position: Int)

    fun openNextLevel(level: Int, number: Int)

}