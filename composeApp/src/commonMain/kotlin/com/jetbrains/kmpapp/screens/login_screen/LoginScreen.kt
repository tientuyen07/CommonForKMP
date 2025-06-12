package com.jetbrains.kmpapp.screens.login_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
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
import com.jetbrains.kmpapp.custom.component.CustomButton
import com.jetbrains.kmpapp.custom.component.CustomTextField
import com.jetbrains.kmpapp.custom.localization.Language
import com.jetbrains.kmpapp.custom.theme.LocalTheme
import com.jetbrains.kmpapp.custom.theme.darkThemeColors
import com.jetbrains.kmpapp.custom.theme.lightThemeColors
import commonforkmp.composeapp.generated.resources.Res
import commonforkmp.composeapp.generated.resources.enter_password
import commonforkmp.composeapp.generated.resources.enter_username
import commonforkmp.composeapp.generated.resources.ic_flag_eng
import commonforkmp.composeapp.generated.resources.ic_flag_vietnam
import commonforkmp.composeapp.generated.resources.ic_login_logo
import commonforkmp.composeapp.generated.resources.sign_in
import commonforkmp.composeapp.generated.resources.sign_in_to_continue
import commonforkmp.composeapp.generated.resources.sign_up_if_have_not_an_account
import commonforkmp.composeapp.generated.resources.welcome
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun LoginScreen(
    language: Language,
    onLanguageChange: () -> Unit
) {
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
                    text = stringResource(Res.string.welcome),
                    color = theme.textPrimary,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    modifier = Modifier.fillMaxWidth().alpha(0.38f),
                    text = stringResource(Res.string.sign_in_to_continue),
                    color = theme.textPrimary,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(48.dp))
                CustomTextField(
                    value = username,
                    onValueChange = { username = it },
                    placeholder = stringResource(Res.string.enter_username),
                    isError = username.length < 3
                )
                Spacer(modifier = Modifier.height(16.dp))
                CustomTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = stringResource(Res.string.enter_password),
                    transformation = PasswordVisualTransformation(),
                    isError = password.length < 8
                )
                Spacer(modifier = Modifier.height(24.dp))
                CustomButton(
                    text = stringResource(Res.string.sign_in),
                    enabled = username.length >= 3 && password.length >= 8,
                    onClick = {

                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.fillMaxWidth().alpha(0.5f),
                    text = stringResource(Res.string.sign_up_if_have_not_an_account),
                    fontSize = 14.sp,
                    color = theme.textPrimary,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(240.dp))
                Button(modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterHorizontally),
                    onClick = onLanguageChange,
                    colors = ButtonColors(
                        containerColor = theme.buttonPrimary.copy(alpha = 0.2f),
                        contentColor = theme.textInverse,
                        disabledContainerColor =  theme.buttonDisabled,
                        disabledContentColor = theme.textInverse.copy(alpha = 0.38f)
                    )
                ) {
                    Text(
                        text = language.name,
                        color = theme.textPrimary,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        modifier = Modifier.width(32.dp).height(32.dp),
                        painter = if (language.iso == Language.English.iso) painterResource(Res.drawable.ic_flag_eng)
                        else painterResource(Res.drawable.ic_flag_vietnam),
                        contentDescription = "Flag"
                    )
                }
            }
        }
    }
}