package com.exfarnanda1945.loremipsumgen.core.navigation

sealed class AppRoutes(val route: String) {
    object GeneratorScreen : AppRoutes("generator")
    object ResultGenScreen : AppRoutes("resultgen?setting={setting}?result={value}") {
        fun setParam(setting: String, result: String): String {
            val rmLineBreak = result.replace(
                "\n",
                ""
            )
            return route.replace("{setting}", setting).replace("{value}", rmLineBreak)
        }
    }
}