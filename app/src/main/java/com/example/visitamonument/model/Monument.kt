package com.example.visitamonument.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Monument(
    val id: Int,
    @StringRes val titleRes: Int,
    @StringRes val subtitleRes: Int,
    @StringRes val detailsRes: Int,
    @DrawableRes val imageRes: Int
)
