package com.exfarnanda1945.loremipsumgen.core.navigation

sealed class AppRoutes(val route: String) {
    object WelcomeScreen : AppRoutes("welcome")
    object GeneratorScreen : AppRoutes("generator")
    object ResultGenScreen : AppRoutes("resultgen?result={result}") {
        fun setResult(result: String): String {
            return route.replace("{result}", result)
        }
    }
}