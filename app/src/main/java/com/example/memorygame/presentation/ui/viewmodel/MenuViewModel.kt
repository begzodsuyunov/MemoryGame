package com.example.memorygame.presentation.ui.viewmodel

import kotlinx.coroutines.flow.Flow

interface MenuViewModel {
    val levelFlow: Flow<String>

    fun onClickPlay(level: String)

    suspend fun setLevel(level: String)

    fun onClickNext(level: String)

    fun onClickPrev(level: String)

    fun onClickSetting()

    fun onClickInfo()
}