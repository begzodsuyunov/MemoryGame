package com.example.memorygame.domain.usecase.impl

import com.example.memorygame.data.room.entity.GameEntity
import com.example.memorygame.domain.repository.AppRepository
import com.example.memorygame.domain.usecase.MiniLevelUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MiniLevelUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) : MiniLevelUseCase {

    override fun getAllEasyLevel(): Flow<List<GameEntity>> =
        repository.getAllEasyLevel()

    override fun getAllMediumLevel(): Flow<List<GameEntity>> =
        repository.getAllMediumLevel()

    override fun getAllHardLevel(): Flow<List<GameEntity>> =
        repository.getAllHardLevel()
}