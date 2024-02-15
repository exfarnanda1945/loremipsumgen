package com.exfarnanda1945.loremipsumgen.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.generator.GeneratorScreen
import com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.result.ResultScreen
import com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.welcome.WelcomeScreen

@Composable
fun AppNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = AppRoutes.WelcomeScreen.route) {
        composable(AppRoutes.WelcomeScreen.route) {
            WelcomeScreen(navHostController)
        }
        composable(AppRoutes.GeneratorScreen.route) {
            GeneratorScreen(navHostController)
        }
        composable(
            AppRoutes.ResultGenScreen.route,
            arguments = listOf(navArgument("result") {
                type = NavType.StringType

            }),
        ) { entry ->
            val result = entry.arguments?.getString("result")
            result?.let {
                ResultScreen(result = it, navHostController = navHostController)
            }
        }
    }

}