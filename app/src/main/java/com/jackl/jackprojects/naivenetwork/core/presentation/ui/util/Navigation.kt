package com.jackl.jackprojects.naivenetwork.core.presentation.ui.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jackl.jackprojects.naivenetwork.splash.SplashScreen

@Composable
fun NavigationRoot(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = SplashScreen
    ) {
        composable<SplashScreen> {
            SplashScreen(
                goNextScreen = {
                    navController.navigate(AuthGraph) {
                        popUpTo<SplashScreen>()
                    }
                }
            )
        }

        authGraph(navController)
    }
}

fun NavGraphBuilder.authGraph(
    navController: NavHostController
) {
    navigation<AuthGraph>(
        startDestination = IntroScreen
    ){
        composable<IntroScreen> {

        }

        composable<LoginScreen> {

        }
    }
}