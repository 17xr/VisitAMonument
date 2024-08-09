package com.example.visitamonument

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.visitamonument.model.AppContentType
import com.example.visitamonument.model.AppViewModel
import com.example.visitamonument.ui.screen.VisitAMonumentApp
import com.example.visitamonument.ui.theme.VisitAMonumentTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appViewModel: AppViewModel by viewModels()
            val navController: NavHostController = rememberNavController()
            val windowSize: WindowSizeClass = calculateWindowSizeClass(activity = this)

            val contentType: AppContentType = when (windowSize.widthSizeClass) {
                WindowWidthSizeClass.Medium -> AppContentType.Two
                WindowWidthSizeClass.Expanded -> AppContentType.Three
                else -> AppContentType.One
            }

            VisitAMonumentTheme(
                dynamicColor = false
            ) {
                VisitAMonumentApp(
                    appViewModel = appViewModel,
                    navController = navController,
                    contentType = contentType
                )
            }
        }
    }
}