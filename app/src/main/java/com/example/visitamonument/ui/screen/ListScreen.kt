package com.example.visitamonument.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.visitamonument.R
import com.example.visitamonument.model.AppUiState
import com.example.visitamonument.model.AppViewModel
import com.example.visitamonument.model.Monument

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreenTopAppBar(
    modifier: Modifier = Modifier,
    onIconClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        },
        navigationIcon = {
            IconButton(
                onClick = { onIconClicked() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(id = R.dimen.padding_small))
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier
    )
}

@Composable
fun ListScreenCard(
    modifier: Modifier = Modifier,
    appViewModel: AppViewModel,
    onCardClicked: (Monument) -> Unit
) {
    val appUiState: State<AppUiState> = appViewModel.uiState.collectAsState()

    Card(
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_large)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        modifier = modifier
            .fillMaxWidth()
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            items(appUiState.value.currentCity.monumentsList) { item ->
                ListScreenItem(
                    titleRes = item.titleRes,
                    subtitleRes = item.subtitleRes,
                    modifier = Modifier
                        .clickable {
                            onCardClicked(item)
                        }
                )

                if (item != appUiState.value.currentCity.monumentsList.last()) {
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .padding(vertical = dimensionResource(id = R.dimen.padding_small))
                    )
                }
            }
        }
    }
}

@Composable
fun ListScreenItem(
    modifier: Modifier = Modifier,
    titleRes: Int,
    subtitleRes: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Column {
            Text(
                text = stringResource(id = titleRes),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )

            Text(
                text = stringResource(id = subtitleRes),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.65f)
            )
        }

        Spacer(
            modifier = Modifier
                .weight(1f)
        )

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondaryContainer
        )
    }
}