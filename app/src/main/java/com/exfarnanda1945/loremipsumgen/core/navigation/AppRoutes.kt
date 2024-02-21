package com.exfarnanda1945.loremipsumgen.core.navigation

sealed class AppRoutes(val route: String) {
    object WelcomeScreen : AppRoutes("welcome")
    object GeneratorScreen : AppRoutes("generator")
    object ResultGenScreen : AppRoutes("resultgen?result={value}") {
        fun setResult(result: String): String {
            val rmLineBreak = result.replace(
                "\n",
                ""
            )
            return route.replace("{value}", rmLineBreak)
        }
    }
}