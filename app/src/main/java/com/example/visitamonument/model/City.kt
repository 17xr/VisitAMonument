package com.example.visitamonument.model

import androidx.annotation.StringRes

data class City(
    val id: Int,
    @StringRes val titleRes: Int,
    @StringRes val countryRes: Int,
    val monumentsList: List<Monument>
)