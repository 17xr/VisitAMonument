package com.example.visitamonument.model

import com.example.visitamonument.data.LocalDataProvider

data class AppUiState(
    val monumentsList: List<City> = emptyList(),
    val currentCity: City = LocalDataProvider.defaultCity,
    val currentMonument: Monument = LocalDataProvider.defaultMonument,
    val currentScreen: AppScreen = AppScreen.General
)