package com.example.memorygame.presentation.ui.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memorygame.data.model.GameModel
import com.example.memorygame.data.room.entity.GameEntity
import com.example.memorygame.domain.usecase.GameUseCase
import com.example.memorygame.presentation.navigator.Navigator
import com.example.memorygame.presentation.ui.viewmodel.GameViewModel
import com.example.memorygame.utils.eventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModelImpl @Inject constructor(
    private val useCase: GameUseCase,
    private val navigator: Navigator
) : GameViewModel, ViewModel() {

    override val gameModelLiveData = eventFlow<List<GameModel>>()

    override fun back() {
        viewModelScope.launch {
            navigator.back()
        }
    }

    override fun getByNumber(level: Int, number: Int) {
        viewModelScope.launch {
            useCase.getByNumber(level, number).collect {
                gameModelLiveData.emit(it)
            }
        }
    }

    override fun saveResult(entity: GameEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.saveResult(entity)
        }
    }

    override fun btnClicked(state: Boolean, position: Int) {

    }

    override fun openNextLevel(level: Int, number: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.openNextLevel(level, number)
        }
    }
}