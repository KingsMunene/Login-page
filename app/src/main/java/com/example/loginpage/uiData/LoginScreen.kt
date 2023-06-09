package com.example.loginpage.uiData

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card

import androidx.compose.material3.CardDefaults

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginpage.R

@Composable
fun LoginPage(loginViewModel: LoginViewModel = viewModel(),
    modifier: Modifier = Modifier
){
    val mediumPadding = dimensionResource(R.dimen.medium_padding)

    val loginState by loginViewModel.uiState.collectAsState()

    Column(modifier = modifier
        .fillMaxSize()
        .padding(mediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.page_title),
        style = MaterialTheme.typography.titleLarge)

        LoginForm(
            userName = loginViewModel.userName,
            onUserNameChange = {loginViewModel.onUserNameChanged(it)},
            password = loginViewModel.password,
            onPasswordChange = {loginViewModel.onPasswordChanged(it)},)

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(mediumPadding),
            verticalArrangement = Arrangement.spacedBy(mediumPadding),
            horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                Text(stringResource(R.string.login_button))
            }

            Button(onClick = { }, modifier = Modifier.fillMaxWidth()) {
                Text(stringResource(R.string.signup_button))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm(userName: String,
              onUserNameChange:(String) -> Unit,
              password: String,
              onPasswordChange:(String) -> Unit,
              modifier: Modifier = Modifier
) {
    val mediumPadding = dimensionResource(R.dimen.medium_padding)

    Card(elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(mediumPadding),
            verticalArrangement = Arrangement.spacedBy(mediumPadding),
        horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(
                value = userName,
                onValueChange = onUserNameChange,
                label = { Text(text = stringResource(id = R.string.user_name)) },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(containerColor = colorScheme.surface),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onDone = {}
                ),
                modifier = modifier)

            OutlinedTextField(
                value = password,
                onValueChange = onPasswordChange,
                isError = false,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(containerColor = colorScheme.surface),
                label = { Text(stringResource(R.string.Password_label)) },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation(),
                keyboardActions = KeyboardActions(
                    onDone = {}
                ),
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PagePreview() {
    LoginPage(modifier = Modifier)
}