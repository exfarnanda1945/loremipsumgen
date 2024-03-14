package com.exfarnanda1945.loremipsumgen.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.generator.GeneratorScreen
import com.exfarnanda1945.loremipsumgen.feat_result.presentation.result.ResultScreen

@Composable
fun AppNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = AppRoutes.GeneratorScreen.route) {
        composable(AppRoutes.GeneratorScreen.route) {
            GeneratorScreen(navHostController)
        }
        composable(
            AppRoutes.ResultGenScreen.route,
            arguments = listOf(
                navArgument("value") {
                type = NavType.StringType
                defaultValue = "" },
//                navArgument("setting"){
//                    type =
//                }
                ),
        ) { entry ->
            val result = entry.arguments?.getString("value")
            result?.let {
                ResultScreen(result = it, navHostController = navHostController)
            }
        }
    }

}