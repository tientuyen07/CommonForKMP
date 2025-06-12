package com.jetbrains.kmpapp.custom.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.jetbrains.kmpapp.custom.theme.LocalTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun CustomTextField(
    modifier: Modifier = Modifier,
    textFieldModifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String? = null,
    shape: Shape = RoundedCornerShape(12.dp),
    enabled: Boolean = true,
    singleLine: Boolean = true,
    transformation: VisualTransformation = VisualTransformation.None,
    isError: Boolean = false,
) {
    val theme = LocalTheme.current
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val borderColor by animateColorAsState(
        targetValue = if (isError) theme.borderError
        else if (isFocused) theme.borderFocused
        else Color.Transparent,
        animationSpec = tween(durationMillis = 200)
    )

    Column(modifier = modifier) {
        TextField(
            modifier = textFieldModifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = borderColor,
                    shape = shape
                ),
            enabled = enabled,
            value = value,
            onValueChange = onValueChange,
            placeholder = if (placeholder != null) {
                {
                    Text(
                        modifier = Modifier.alpha(0.38f),
                        text = placeholder,
                        color = theme.textPrimary,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize
                    )
                }
            } else null,
            singleLine = singleLine,
            shape = shape,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = theme.surfaceLight,
                unfocusedContainerColor = theme.surfaceLight,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedTextColor = theme.textPrimary,
                focusedTextColor = theme.textPrimary,
                cursorColor = theme.iconPrimary
            ),
            interactionSource = interactionSource,
            visualTransformation = transformation
        )
    }
}