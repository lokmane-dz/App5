package me.lokmvne.app5.utils

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun MyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    iconModifier: Modifier = Modifier,
    modifier: Modifier = Modifier.width(300.dp),
//    label: String = "",
    placeholder: String = "",
//    supportingText: String = "",
    trailingIcon: ImageVector,
    keyboardActions: KeyboardActions = KeyboardActions(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        placeholder = { Text(text = placeholder) },
        // label = { Text(text = label) },
        readOnly = false,
        enabled = true,
        singleLine = true,
        trailingIcon = {
            Icon(
                imageVector = trailingIcon,
                contentDescription = placeholder,
                modifier = iconModifier
            )
        },
        //supportingText = { Text(text = supportingText) },
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
            disabledTextColor = Color.Gray,
            errorTextColor = MaterialTheme.colorScheme.error,
            focusedContainerColor = MaterialTheme.colorScheme.primary,
            unfocusedContainerColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = Color.LightGray,
            errorContainerColor = MaterialTheme.colorScheme.primary,
            cursorColor = MaterialTheme.colorScheme.onPrimary,
            errorCursorColor = MaterialTheme.colorScheme.error,
            selectionColors = TextSelectionColors(
                handleColor = MaterialTheme.colorScheme.primary,
                backgroundColor = Color.LightGray,
            ),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            focusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
            disabledLeadingIconColor = Color.Gray,
            errorLeadingIconColor = MaterialTheme.colorScheme.error,
            focusedTrailingIconColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedTrailingIconColor = MaterialTheme.colorScheme.onPrimary,
            disabledTrailingIconColor = Color.LightGray,
            errorTrailingIconColor = MaterialTheme.colorScheme.error,
            focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedLabelColor = MaterialTheme.colorScheme.onPrimary,
            disabledLabelColor = Color.LightGray,
            errorLabelColor = MaterialTheme.colorScheme.error,
            focusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary,
            disabledPlaceholderColor = Color.LightGray,
            errorPlaceholderColor = MaterialTheme.colorScheme.error,
            focusedSupportingTextColor = MaterialTheme.colorScheme.primary,
            unfocusedSupportingTextColor = MaterialTheme.colorScheme.primary,
            disabledSupportingTextColor = Color.Gray,
            errorSupportingTextColor = MaterialTheme.colorScheme.error,
            focusedPrefixColor = Color.Black,
            unfocusedPrefixColor = Color.Black,
            disabledPrefixColor = Color.Black,
            errorPrefixColor = MaterialTheme.colorScheme.error,
            focusedSuffixColor = Color.Red,
            unfocusedSuffixColor = Color.Black,
            disabledSuffixColor = Color.Black,
            errorSuffixColor = MaterialTheme.colorScheme.error,
        ),

        )
}


@Composable
fun MyButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
        .width(150.dp)
        .height(48.dp),
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = true,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContentColor = Color.Gray,
            disabledContainerColor = Color.LightGray,
        )
    ) {
        Text(text = text)
    }
}