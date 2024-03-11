package com.work.workhubpro.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.work.workhubpro.R

@Composable
fun MyTextField(labelValue: String, painterResource: Painter) {
    var textValue: String by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textValue,
        onValueChange = {
            textValue = it
        },
        label = { Text(text = labelValue) },
        keyboardOptions = KeyboardOptions.Default,
        textStyle = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
        ),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Cyan,
            focusedLabelColor = Color.DarkGray,
            cursorColor = Color.Black,
        ),
        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = "Mail",
                modifier = Modifier
                    .size(20.dp, 20.dp),
            )
        }
    )
}


@Composable
fun PasswordTextField(labelValue: String, painterResource: Painter) {
    var textValue: String by remember { mutableStateOf("") }
    var passwordVisible: Boolean by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textValue,
        onValueChange = {
            textValue = it
        },
        label = { Text(text = labelValue) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        textStyle = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
        ),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Cyan,
            focusedLabelColor = Color.DarkGray,
            cursorColor = Color.Black,
        ),
        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = "Mail",
                modifier = Modifier
                    .size(20.dp, 20.dp),
            )
        },
        trailingIcon = {
            val iconImage = if (passwordVisible){
                Icons.Filled.Visibility
            }else {
                Icons.Filled.VisibilityOff
            }

            val description = if (passwordVisible){
                stringResource(id = R.string.hide_password)
            }else {
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = {passwordVisible = !passwordVisible}) {
                Icon(
                    imageVector = iconImage,
                    contentDescription = description
                )
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}