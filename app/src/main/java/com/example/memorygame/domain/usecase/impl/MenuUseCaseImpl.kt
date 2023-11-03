package com.example.memorygame.domain.usecase.impl

import com.example.memorygame.domain.repository.AppRepository
import com.example.memorygame.domain.usecase.MenuUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MenuUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) : MenuUseCase {

    override fun getLevel(): Flow<String> = repository.getLevel()

    override suspend fun setLevel(level: String)  = repository.setLevel(level)
}