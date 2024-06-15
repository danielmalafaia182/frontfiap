package br.com.fiap.locamail.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.locamail.R
import br.com.fiap.locamail.components.CustomOutlinedTextField
import br.com.fiap.locamail.components.LoginOptionButton
import br.com.fiap.locamail.components.TextLogin

@Composable
fun LoginScreen(navController: NavController?) {
    var loginEmail by remember { mutableStateOf("") }
    var loginPassword by remember { mutableStateOf("") }
    var errorEmail by remember { mutableStateOf(false) }
    var errorPassword by remember { mutableStateOf(false) }

    val MAXIMUMPASSWORDSIZE = 8

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF181E24))
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.logoheader),
            contentDescription = stringResource(id = R.string.locaMailLogo),
            modifier = Modifier
                .size(width = 190.82.dp, height = 40.dp)
                .offset(y = 30.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF181E24)),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TextLogin(
                        text = stringResource(id = R.string.email),
                        color = Color.White
                    )
                    CustomOutlinedTextField(
                        value = loginEmail,
                        onValueChange = {
                            loginEmail = it
                            if (errorEmail) errorEmail = false
                        },
                        placeHolder = stringResource(id = R.string.email_input),
                        keyboardType = KeyboardType.Email,
                        isError = errorEmail,
                    )
                    if (errorEmail) {
                        TextLogin(
                            text = stringResource(id = R.string.email_login_error),
                            color = Color.Red,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End
                        )
                    }
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TextLogin(
                        text = stringResource(id = R.string.password),
                        color = Color.White
                    )
                    CustomOutlinedTextField(
                        value = loginPassword,
                        onValueChange = {
                            if (it.length < MAXIMUMPASSWORDSIZE) loginPassword = it
                            if (errorPassword) errorPassword = false
                        },
                        placeHolder = stringResource(id = R.string.password_input),
                        keyboardType = KeyboardType.Password,
                        isError = errorPassword,
                        visualTransformation = PasswordVisualTransformation()
                    )
                    if (errorPassword) {
                        TextLogin(
                            text = stringResource(id = R.string.password_login_error),
                            color = Color.Red,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End
                        )
                    }
                    TextLogin(
                        text = stringResource(id = R.string.forgot_password),
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.End)
                            .clickable { /* TODO: Handle forgot password */ }
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {
                        if (loginEmail.isEmpty()) {
                            errorEmail = true
                        }
                        if (loginPassword.isEmpty()) {
                            errorPassword = true
                        }
                        if (!errorEmail && !errorPassword) {
                            navController?.navigate("menu") {
                                popUpTo("login") { inclusive = true }
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF00843)),
                    shape = RoundedCornerShape(6.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    TextLogin(
                        text = stringResource(id = R.string.login),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextLogin(
                text = stringResource(id = R.string.login_options),
                color = Color.White
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                LoginOptionButton(
                    icon = R.drawable.linkedinlogo,
                    contentDescription = stringResource(id = R.string.linkedInLogo)
                )
                LoginOptionButton(icon = R.drawable.facebooklogo, contentDescription = stringResource(id = R.string.XLogo))
                LoginOptionButton(icon = R.drawable.xlogo, contentDescription = stringResource(id = R.string.FacebookLogo))
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 30.dp)
        ) {
            TextLogin(
                text = stringResource(id = R.string.does_not_have_account) + " ",
                color = Color.White
            )
            TextLogin(
                text = stringResource(id = R.string.register_here),
                color = Color.White,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { /* TODO: Handle sign up */ }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(navController = null)
}
