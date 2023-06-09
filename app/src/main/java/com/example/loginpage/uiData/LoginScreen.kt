package com.example.loginpage.uiData

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginpage.R

@Composable
fun LoginPage() {

    LoginForm()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm(modifier: Modifier = Modifier) {
    Card(){
        Column(){
            OutlinedTextField(value = "" ,
                onValueChange = {},
                label = { Text(text = stringResource(id = R.string.user_name)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onDone = {}
                ),
                modifier = modifier)

            OutlinedTextField(
                value = "",
                onValueChange = {},
                isError = false,
                singleLine = true,
                label = { Text(stringResource(R.string.Password_label)) },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {}
                ),
                modifier = modifier
            )
        }
    }
}

@Preview
@Composable
fun PagePreview() {
    LoginPage()
}