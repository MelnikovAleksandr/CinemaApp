package ru.asmelnikov.components.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthInputText(
    labelText: String,
    onInput: (String) -> Unit
) {
    var textState by remember { mutableStateOf("") }

    TextField(
        value = textState.trim(),
        onValueChange = {
            textState = it
            onInput(it)
        },
        label = { Text(text = labelText) },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 30.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF95A6C5),
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedLeadingIconColor = Color(0xFF58647C),
            unfocusedLeadingIconColor = Color(0xFF58647C),
            focusedTrailingIconColor = Color(0xFF58647C),
            unfocusedTrailingIconColor = Color(0xFF58647C),
        ),
        shape = RoundedCornerShape(15.dp)
    )
}