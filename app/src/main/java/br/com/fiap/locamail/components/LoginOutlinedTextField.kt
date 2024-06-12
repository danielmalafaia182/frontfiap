package br.com.fiap.locamail.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeHolder: String,
    keyboardType: KeyboardType,
    isError: Boolean,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = placeHolder, color = Color(0xFFFFFFFF).copy(alpha = 0.3f))
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        isError = isError,
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(6.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color(0xFF495A6B),
            focusedBorderColor = Color(0xFF495A6B),
            cursorColor = Color.White,
            unfocusedLabelColor = Color.Transparent,
            focusedLabelColor = Color.Transparent,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
        ),
        visualTransformation = visualTransformation
    )
}
