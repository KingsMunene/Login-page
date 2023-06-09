package com.example.loginpage.uiData

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

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
                onValueChange = {} )

            OutlinedTextField(
                value = "",
                onValueChange = {},
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