package com.example.memorygame.presentation.navigator

import androidx.navigation.NavController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorDispatcher @Inject constructor() : Navigator, NavigationHandler {

    override val navigationStack = MutableSharedFlow<(NavController) -> Unit>()

    private suspend fun navigator(args: NavController.() -> Unit) {
        navigationStack.emit(args)
    }

    override suspend fun navigateTo(direction: Direction) =
        navigator {
            navigate((direction))
        }

    override suspend fun back() = navigator {
        popBackStack()
    }
}