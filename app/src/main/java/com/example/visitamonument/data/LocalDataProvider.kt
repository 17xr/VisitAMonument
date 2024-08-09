package com.example.visitamonument.data

import com.example.visitamonument.R
import com.example.visitamonument.model.City
import com.example.visitamonument.model.Monument

object LocalDataProvider {
    val defaultCity: City = getMonuments()[0]
    val defaultMonument: Monument = getMonuments()[0].monumentsList[0]

    fun getMonuments(): List<City> {
        return listOf(
            City(
                id = 1,
                titleRes = R.string.city1,
                countryRes = R.string.country1,
                monumentsList = listOf(
                    Monument(
                        id = 1,
                        titleRes = R.string.monument1,
                        subtitleRes = R.string.subtitle1,
                        detailsRes = R.string.detail1,
                        imageRes = R.drawable.colosseum
                    ),
                    Monument(
                        id = 2,
                        titleRes = R.string.monument2,
                        subtitleRes = R.string.subtitle2,
                        detailsRes = R.string.detail2,
                        imageRes = R.drawable.roman_forum
                    ),
                    Monument(
                        id = 3,
                        titleRes = R.string.monument3,
                        subtitleRes = R.string.subtitle3,
                        detailsRes = R.string.detail3,
                        imageRes = R.drawable.pantheon
                    )
                )
            ), City(
                id = 2,
                titleRes = R.string.city2,
                countryRes = R.string.country2,
                monumentsList = listOf(
                    Monument(
                        id = 1,
                        titleRes = R.string.monument4,
                        subtitleRes = R.string.subtitle4,
                        detailsRes = R.string.detail4,
                        imageRes = R.drawable.eiffel_tower
                    ),
                    Monument(
                        id = 2,
                        titleRes = R.string.monument5,
                        subtitleRes = R.string.subtitle5,
                        detailsRes = R.string.detail5,
                        imageRes = R.drawable.louvre_museum
                    ),
                    Monument(
                        id = 3,
                        titleRes = R.string.monument6,
                        subtitleRes = R.string.subtitle6,
                        detailsRes = R.string.detail6,
                        imageRes = R.drawable.notre_dame_cathedral
                    ),
                    Monument(
                        id = 4,
                        titleRes = R.string.monument7,
                        subtitleRes = R.string.subtitle7,
                        detailsRes = R.string.detail7,
                        imageRes = R.drawable.arc_de_triomphe
                    )
                )
            ), City(
                id = 3,
                titleRes = R.string.city3,
                countryRes = R.string.country3,
                monumentsList = listOf(
                    Monument(
                        id = 1,
                        titleRes = R.string.monument8,
                        subtitleRes = R.string.subtitle8,
                        detailsRes = R.string.detail8,
                        imageRes = R.drawable.acropolis
                    ),
                    Monument(
                        id = 2,
                        titleRes = R.string.monument9,
                        subtitleRes = R.string.subtitle9,
                        detailsRes = R.string.detail9,
                        imageRes = R.drawable.ancient_agora
                    )
                )
            ), City(
                id = 4,
                titleRes = R.string.city4,
                countryRes = R.string.country4,
                monumentsList = listOf(
                    Monument(
                        id = 1,
                        titleRes = R.string.monument10,
                        subtitleRes = R.string.subtitle10,
                        detailsRes = R.string.detail10,
                        imageRes = R.drawable.hagia_sophia
                    ),
                    Monument(
                        id = 2,
                        titleRes = R.string.monument11,
                        subtitleRes = R.string.subtitle11,
                        detailsRes = R.string.detail11,
                        imageRes = R.drawable.topkapi_palace
                    ),
                    Monument(
                        id = 3,
                        titleRes = R.string.monument12,
                        subtitleRes = R.string.subtitle12,
                        detailsRes = R.string.detail12,
                        imageRes = R.drawable.blue_mosque
                    ),
                    Monument(
                        id = 4,
                        titleRes = R.string.monument13,
                        subtitleRes = R.string.subtitle13,
                        detailsRes = R.string.detail13,
                        imageRes = R.drawable.basilica_cistern
                    )
                )
            ), City(
                id = 5,
                titleRes = R.string.city5,
                countryRes = R.string.country5,
                monumentsList = listOf(
                    Monument(
                        id = 1,
                        titleRes = R.string.monument14,
                        subtitleRes = R.string.subtitle14,
                        detailsRes = R.string.detail14,
                        imageRes = R.drawable.great_pyramids_of_giza
                    ),
                    Monument(
                        id = 2,
                        titleRes = R.string.monument15,
                        subtitleRes = R.string.subtitle15,
                        detailsRes = R.string.detail15,
                        imageRes = R.drawable.saladin_citadel
                    )
                )
            )
        )
    }

    fun getInformation(): List<Int> {
        return listOf(
            R.string.information1,
            R.string.information2,
            R.string.information3,
            R.string.information4,
            R.string.information5,
            R.string.information6,
            R.string.information7,
            R.string.information8,
            R.string.information9,
            R.string.information10,
            R.string.information11,
            R.string.information12,
            R.string.information13,
            R.string.information14,
            R.string.information15,
            R.string.information16,
            R.string.information17,
            R.string.information18,
            R.string.information19,
            R.string.information20,
            R.string.information21,
            R.string.information22,
            R.string.information23,
            R.string.information24
        )
    }
}