package com.example.memorygame.presentation.ui.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memorygame.data.room.entity.GameEntity
import com.example.memorygame.domain.usecase.MiniLevelUseCase
import com.example.memorygame.presentation.navigator.Navigator
import com.example.memorygame.presentation.ui.screen.fragment.game.MiniLevelFragmentDirections
import com.example.memorygame.presentation.ui.viewmodel.MiniLevelViewModel
import com.example.memorygame.utils.eventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MiniLevelViewModelImpl @Inject constructor(
    private val useCase: MiniLevelUseCase,
    private val navigator: Navigator
) : MiniLevelViewModel, ViewModel() {

    override val easyLevelsList = eventFlow<List<GameEntity>>()

    override val mediumLevelsList = eventFlow<List<GameEntity>>()

    override val hardLevelsList = eventFlow<List<GameEntity>>()

    override fun back() {
        viewModelScope.launch {
            navigator.back()
        }
    }

    override fun openGameScreen(gameEntity: GameEntity) {

        viewModelScope.launch {
            navigator.navigateTo(
                MiniLevelFragmentDirections.actionMiniLevelFragmentToGameFragment(
                    gameEntity
                )
            )
        }
    }

    override fun generateEasy() {

        viewModelScope.launch {
            useCase.getAllEasyLevel().collectLatest {
                easyLevelsList.emit(it)
            }
        }
    }

    override fun generateMedium() {
        viewModelScope.launch {
            useCase.getAllMediumLevel().collectLatest {
                mediumLevelsList.emit(it)
            }
        }
    }

    override fun generateHard() {
        viewModelScope.launch {
            useCase.getAllHardLevel().collectLatest {
                hardLevelsList.emit(it)
            }
        }
    }
}