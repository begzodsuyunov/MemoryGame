package com.example.memorygame.di

import com.example.memorygame.presentation.navigator.NavigationHandler
import com.example.memorygame.presentation.navigator.Navigator
import com.example.memorygame.presentation.navigator.NavigatorDispatcher
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun bindNavigator(dispatcher: NavigatorDispatcher): Navigator

    @Binds
    fun bindHandler(dispatcher: NavigatorDispatcher): NavigationHandler

}