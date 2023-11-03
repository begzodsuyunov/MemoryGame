package com.example.memorygame.di

import com.example.memorygame.domain.repository.AppRepository
import com.example.memorygame.domain.repository.impl.AppRepositoryImpl
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule{

    @[Binds Singleton]
    fun bindAppRepository(impl: AppRepositoryImpl) : AppRepository

}