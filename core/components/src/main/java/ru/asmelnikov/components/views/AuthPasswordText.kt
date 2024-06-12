package ru.asmelnikov.components.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ru.asmelnikov.components.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthPasswordText(onInput: (String) -> Unit) {

    var passwordState by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }


    val icon = if (passwordVisibility) {
        painterResource(id = R.drawable.ic_visible)
    } else {
        painterResource(id = R.drawable.ic_invisible)
    }

    TextField(
        value = passwordState,
        onValueChange = {
            passwordState = it
            onInput(it)
        },
        label = { Text(text = "Password") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(
                    painter = icon,
                    contentDescription = "Visibility Icon",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        },
        visualTransformation = if (passwordVisibility)
            VisualTransformation.None
        else PasswordVisualTransformation(),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 30.dp),
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