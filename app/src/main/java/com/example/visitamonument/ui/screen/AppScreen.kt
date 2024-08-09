package com.example.visitamonument.ui.screen

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.visitamonument.R
import com.example.visitamonument.data.LocalDataProvider
import com.example.visitamonument.model.AppContentType
import com.example.visitamonument.model.AppScreen
import com.example.visitamonument.model.AppUiState
import com.example.visitamonument.model.AppViewModel

@Composable
fun VisitAMonumentApp(
    modifier: Modifier = Modifier,
    appViewModel: AppViewModel,
    navController: NavHostController,
    contentType: AppContentType
) {
    val appUiState: State<AppUiState> = appViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            when (contentType) {
                AppContentType.One -> {
                    when (appUiState.value.currentScreen) {
                        AppScreen.General -> {
                            GeneralScreenTopAppBar()
                        }

                        AppScreen.List -> {
                            ListScreenTopAppBar(
                                onIconClicked = {
                                    appViewModel.navigateToGeneralScreen()
                                    navController.navigateUp()
                                }
                            )
                        }

                        AppScreen.Details -> {
                            DetailsScreenTopAppBar(
                                onIconClicked = {
                                    appViewModel.navigateToListScreen()
                                    navController.navigateUp()
                                }
                            )
                        }
                    }
                }

                AppContentType.Two -> {
                    when (appUiState.value.currentScreen) {
                        AppScreen.General -> {
                            GeneralScreenTopAppBar()
                        }

                        else -> {
                            DetailsScreenTopAppBar(
                                onIconClicked = {
                                    appViewModel.navigateToGeneralScreen()
                                    navController.navigateUp()
                                }
                            )
                        }
                    }
                }

                AppContentType.Three -> {
                    GeneralScreenTopAppBar()
                }
            }
        },
        modifier = modifier
            .fillMaxSize()
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppScreen.General.name,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(durationMillis = 300, easing = LinearEasing)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(durationMillis = 300, easing = LinearEasing)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(durationMillis = 300, easing = LinearEasing)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(durationMillis = 300, easing = LinearEasing)
                )
            },
            modifier = Modifier
                .padding(innerPadding)
        ) {
            when (contentType) {
                AppContentType.One -> {
                    composable(route = AppScreen.General.name) {
                        appViewModel.navigateToGeneralScreen()

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .padding(dimensionResource(id = R.dimen.padding_medium))
                            ) {
                                RandomInformationCard()

                                Spacer(
                                    modifier = Modifier
                                        .height(dimensionResource(id = R.dimen.padding_medium))
                                )

                                GeneralScreenCard(
                                    appViewModel = appViewModel,
                                    onCardClicked = {
                                        appViewModel.updateCurrentCity(city = it)
                                        appViewModel.updateCurrentMonument(monument = appUiState.value.currentCity.monumentsList[0])
                                        navController.navigate(route = AppScreen.List.name)
                                    }
                                )
                            }
                        }
                    }

                    composable(route = AppScreen.List.name) {
                        appViewModel.navigateToListScreen()

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .padding(dimensionResource(id = R.dimen.padding_medium))
                            ) {
                                RandomInformationCard()

                                Spacer(
                                    modifier = Modifier
                                        .height(dimensionResource(id = R.dimen.padding_medium))
                                )

                                ListScreenCard(
                                    appViewModel = appViewModel,
                                    onCardClicked = {
                                        appViewModel.updateCurrentMonument(monument = it)
                                        navController.navigate(route = AppScreen.Details.name)
                                    }
                                )
                            }
                        }
                    }

                    composable(route = AppScreen.Details.name) {
                        appViewModel.navigateToDetailsScreen()

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            LazyColumn(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                item {
                                    DetailsScreenCard(
                                        appViewModel = appViewModel,
                                        modifier = Modifier
                                            .padding(dimensionResource(id = R.dimen.padding_medium))
                                    )
                                }
                            }
                        }
                    }
                }

                AppContentType.Two -> {
                    composable(route = AppScreen.General.name) {
                        appViewModel.navigateToGeneralScreen()

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .padding(dimensionResource(id = R.dimen.padding_medium))
                            ) {
                                RandomInformationCard()

                                Spacer(
                                    modifier = Modifier
                                        .height(dimensionResource(id = R.dimen.padding_medium))
                                )

                                Row {
                                    GeneralScreenCard(
                                        appViewModel = appViewModel,
                                        onCardClicked = {
                                            appViewModel.updateCurrentCity(city = it)
                                            appViewModel.updateCurrentMonument(monument = appUiState.value.currentCity.monumentsList[0])
                                        },
                                        modifier = Modifier
                                            .weight(1f)
                                    )

                                    Spacer(
                                        modifier = Modifier
                                            .width(dimensionResource(id = R.dimen.padding_medium))
                                    )

                                    ListScreenCard(
                                        appViewModel = appViewModel,
                                        onCardClicked = {
                                            appViewModel.updateCurrentMonument(monument = it)
                                            navController.navigate(route = AppScreen.Details.name)
                                        },
                                        modifier = Modifier
                                            .weight(1f)
                                    )
                                }
                            }
                        }
                    }

                    composable(route = AppScreen.Details.name) {
                        appViewModel.navigateToDetailsScreen()

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            LazyColumn(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                item {
                                    DetailsScreenCard(
                                        appViewModel = appViewModel,
                                        modifier = Modifier
                                            .padding(dimensionResource(id = R.dimen.padding_medium))
                                    )
                                }
                            }
                        }
                    }
                }

                AppContentType.Three -> {
                    composable(route = AppScreen.General.name) {
                        appViewModel.navigateToGeneralScreen()

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Row {
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                ) {
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .padding(
                                                start = dimensionResource(id = R.dimen.padding_medium),
                                                top = dimensionResource(id = R.dimen.padding_medium),
                                                bottom = dimensionResource(id = R.dimen.padding_medium)
                                            )
                                    ) {
                                        RandomInformationCard()

                                        Spacer(
                                            modifier = Modifier
                                                .height(dimensionResource(id = R.dimen.padding_medium))
                                        )

                                        Row {
                                            GeneralScreenCard(
                                                appViewModel = appViewModel,
                                                onCardClicked = {
                                                    appViewModel.updateCurrentCity(city = it)
                                                    appViewModel.updateCurrentMonument(monument = appUiState.value.currentCity.monumentsList[0])
                                                },
                                                modifier = Modifier
                                                    .weight(1f)
                                            )

                                            Spacer(
                                                modifier = Modifier
                                                    .width(dimensionResource(id = R.dimen.padding_medium))
                                            )

                                            ListScreenCard(
                                                appViewModel = appViewModel,
                                                onCardClicked = {
                                                    appViewModel.updateCurrentMonument(monument = it)
                                                },
                                                modifier = Modifier
                                                    .weight(2f)
                                            )
                                        }
                                    }
                                }

                                LazyColumn(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                        .weight(1f)
                                ) {
                                    item {
                                        DetailsScreenCard(
                                            appViewModel = appViewModel,
                                            modifier = Modifier
                                                .padding(dimensionResource(id = R.dimen.padding_medium))
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RandomInformationCard(
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_large)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer
        ),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.light_bulb),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onTertiaryContainer
            )

            Spacer(
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.padding_small))
            )

            Text(
                text = stringResource(id = LocalDataProvider.getInformation().random()),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}