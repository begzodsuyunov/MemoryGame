package com.example.memorygame.di

import com.example.memorygame.domain.usecase.GameUseCase
import com.example.memorygame.domain.usecase.MenuUseCase
import com.example.memorygame.domain.usecase.MiniLevelUseCase
import com.example.memorygame.domain.usecase.impl.GameUseCaseImpl
import com.example.memorygame.domain.usecase.impl.MenuUseCaseImpl
import com.example.memorygame.domain.usecase.impl.MiniLevelUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindMenuUseCase(impl: MenuUseCaseImpl): MenuUseCase

    @Binds
    fun bindMiniLevelUseCase(impl: MiniLevelUseCaseImpl): MiniLevelUseCase

    @Binds
    fun bindGameUseCase(impl: GameUseCaseImpl): GameUseCase

}