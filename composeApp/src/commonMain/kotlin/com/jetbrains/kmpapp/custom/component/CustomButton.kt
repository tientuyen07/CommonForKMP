package com.jetbrains.kmpapp.custom.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetbrains.kmpapp.custom.theme.LocalTheme
import commonforkmp.composeapp.generated.resources.Res
import commonforkmp.composeapp.generated.resources.ic_sign_in
import org.jetbrains.compose.resources.painterResource

@Composable
fun CustomButton(
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    val theme = LocalTheme.current
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(size = 12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = theme.buttonPrimary,
            contentColor = theme.textInverse,
            disabledContainerColor =  theme.buttonDisabled,
            disabledContentColor = theme.textInverse.copy(alpha = 0.38f)
        ),
        contentPadding = PaddingValues(all = 16.dp)
    ) {
        Icon(modifier = Modifier.size(16.dp),
            painter = painterResource(Res.drawable.ic_sign_in),
            contentDescription = "Sing in icon"
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = text)
    }
}