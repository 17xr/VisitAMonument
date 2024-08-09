package com.example.visitamonument.model

import androidx.lifecycle.ViewModel
import com.example.visitamonument.data.LocalDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<AppUiState> = MutableStateFlow(
        AppUiState(
            monumentsList = LocalDataProvider.getMonuments(),
            currentCity = LocalDataProvider.defaultCity,
            currentMonument = LocalDataProvider.defaultMonument,
            currentScreen = AppScreen.General
        )
    )

    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    fun updateCurrentCity(city: City) {
        _uiState.update { currentState ->
            currentState.copy(
                currentCity = city
            )
        }
    }

    fun updateCurrentMonument(monument: Monument) {
        _uiState.update { currentState ->
            currentState.copy(
                currentMonument = monument
            )
        }
    }

    fun navigateToGeneralScreen() {
        _uiState.update { currentState ->
            currentState.copy(
                currentScreen = AppScreen.General
            )
        }
    }

    fun navigateToListScreen() {
        _uiState.update { currentState ->
            currentState.copy(
                currentScreen = AppScreen.List
            )
        }
    }

    fun navigateToDetailsScreen() {
        _uiState.update { currentState ->
            currentState.copy(
                currentScreen = AppScreen.Details
            )
        }
    }
}