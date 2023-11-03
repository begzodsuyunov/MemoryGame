package com.example.memorygame.domain.usecase

import kotlinx.coroutines.flow.Flow

interface MenuUseCase {

    fun getLevel(): Flow<String>

    suspend fun setLevel(level: String)

}