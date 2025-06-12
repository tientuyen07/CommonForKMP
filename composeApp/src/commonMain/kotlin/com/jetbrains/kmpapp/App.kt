package com.jetbrains.kmpapp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jetbrains.kmpapp.custom.localization.Language
import com.jetbrains.kmpapp.custom.localization.Localization
import com.jetbrains.kmpapp.screens.detail.DetailScreen
import com.jetbrains.kmpapp.screens.login_screen.LoginScreen
import com.jetbrains.kmpapp.screens.list.ListScreen
import dev.burnoo.compose.remembersetting.rememberStringSetting
import kotlinx.serialization.Serializable
import org.koin.compose.koinInject

@Serializable
object ListDestination

@Serializable
data class DetailDestination(val objectId: Int)

@Serializable
object LoginScreen

@Composable
fun App() {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    ) {
        val localization = koinInject<Localization>()
        var languageIso by rememberStringSetting(
            key = "savedLanguageIso",
            defaultValue = Language.English.iso
        )
        val selectedLanguage by derivedStateOf {
            Language.entries.first { it.iso == languageIso }
        }
        localization.applyLanguages(languageIso)

        Surface {
            val navController: NavHostController = rememberNavController()
            NavHost(navController = navController, startDestination = LoginScreen) {
                composable<LoginScreen> {
                    LoginScreen(
                        language = selectedLanguage,
                        onLanguageChange = {
                            languageIso = if (selectedLanguage == Language.English) Language.Vietnamese.iso else Language.English.iso
                            localization.applyLanguages(languageIso)
                        }
                    )
                }
                composable<ListDestination> {
                    ListScreen(navigateToDetails = { objectId ->
                        navController.navigate(DetailDestination(objectId))
                    })
                }
                composable<DetailDestination> { backStackEntry ->
                    DetailScreen(
                        objectId = backStackEntry.toRoute<DetailDestination>().objectId,
                        navigateBack = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}
