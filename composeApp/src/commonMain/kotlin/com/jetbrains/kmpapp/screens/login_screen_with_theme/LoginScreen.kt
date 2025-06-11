package com.jetbrains.kmpapp.screens.login_screen_with_theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetbrains.kmpapp.screens.login_screen_with_theme.component.CustomButton
import com.jetbrains.kmpapp.screens.login_screen_with_theme.component.CustomTextField
import com.jetbrains.kmpapp.screens.login_screen_with_theme.theme.LocalTheme
import com.jetbrains.kmpapp.screens.login_screen_with_theme.theme.darkThemeColors
import com.jetbrains.kmpapp.screens.login_screen_with_theme.theme.lightThemeColors
import commonforkmp.composeapp.generated.resources.Res
import commonforkmp.composeapp.generated.resources.ic_login_logo
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val themeColors = if (isSystemInDarkTheme()) darkThemeColors else lightThemeColors

    CompositionLocalProvider(LocalTheme provides themeColors) {
        val theme = LocalTheme.current

        MaterialTheme {
            Column(
                modifier = Modifier.fillMaxSize()
                    .systemBarsPadding()
                    .padding(all = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.width(96.dp).height(96.dp).padding(bottom = 12.dp),
                    painter = painterResource(Res.drawable.ic_login_logo),
                    contentDescription = "Image Logo"
                )
                Spacer(modifier = Modifier.height(48.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Welcome",
                    color = theme.textPrimary,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    modifier = Modifier.fillMaxWidth().alpha(0.38f),
                    text = "Please sign in to continue",
                    color = theme.textPrimary,
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(48.dp))
                CustomTextField(
                    value = username,
                    onValueChange = { username = it },
                    placeholder = "Enter your username",
                    isError = username.length < 3
                )
                Spacer(modifier = Modifier.height(16.dp))
                CustomTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = "Enter your password",
                    transformation = PasswordVisualTransformation(),
                    isError = password.length < 8
                )
                Spacer(modifier = Modifier.height(24.dp))
                CustomButton(
                    text = "Sign in",
                    enabled = username.length >= 3 && password.length >= 8,
                    onClick = {

                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.fillMaxWidth().alpha(0.5f),
                    text = "Don't have an account? Sign up",
                    fontSize = 14.sp,
                    color = theme.textPrimary,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}