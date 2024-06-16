package br.com.fiap.locamail.cadastro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import br.com.fiap.locamail.components.TextLogin
import br.com.fiap.locamail.database.repository.UserRepository
import br.com.fiap.locamail.model.User

@Composable
fun RegisterScreen(navController: NavController?) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var dtNascimento by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var emailLogin by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current
    val userRepository = UserRepository(context)

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
                // Identificação
                TextLogin(
                    //text = stringResource(id = R.string.crie_sua_conta),
                    text = "Crie sua conta",
                    color = Color.White,
                    fontSize = 12.sp
                )
                TextLogin(
//                    text = stringResource(id = R.string.identificacao),
                    text = "identificacao",
                    color = Color.White,
                    fontSize = 24.sp
                )
                CustomOutlinedTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
//                    placeHolder = stringResource(id = R.string.nome)
                    placeHolder = "Nome",
                    isError = false,
                    keyboardType = KeyboardType.Text
                )
                CustomOutlinedTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
//                    placeHolder = stringResource(id = R.string.sobrenome)
                    placeHolder = "Sobrenome",
                    isError = false,
                    keyboardType = KeyboardType.Text
                )

                // Informações básicas
                TextLogin(
//                    text = stringResource(id = R.string.informacoes_basicas),
                    text = "Informações Básicas",
                    color = Color.White,
                    fontSize = 16.sp
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CustomOutlinedTextField(
                        modifier = Modifier.size(30.dp),
                        value = dtNascimento,
                        onValueChange = { dtNascimento = it },
//                        placeHolder = stringResource(id = R.string.dia)
                        placeHolder = "Dia",
                        isError = false,
                        keyboardType = KeyboardType.Number
                    )
//                    CustomOutlinedTextField(
//                        modifier = Modifier.size(30.dp),
//                        value = mes,
//                        onValueChange = { mes = it },
////                        placeHolder = stringResource(id = R.string.mes)
//                        placeHolder = "Mês",
//                        isError = false,
//                        keyboardType = KeyboardType.Number
//                    )
//                    CustomOutlinedTextField(
//                        modifier = Modifier.size(30.dp),
//                        value = ano,
//                        onValueChange = { ano = it },
////                        placeHolder = stringResource(id = R.string.ano)
//                        placeHolder = "Ano",
//                        isError = false,
//                        keyboardType = KeyboardType.Number
//                    )
                }
                    CustomOutlinedTextField(
                        value = gender,
                        onValueChange = { gender = it },
//                    placeHolder = stringResource(id = R.string.genero))
                        placeHolder = "Genero",
                        isError = false,
                        keyboardType = KeyboardType.Text
                    )
                    // Endereço LocaMail
                    TextLogin(
//                    text = stringResource(id = R.string.endereco_locamail),
                        text = "Endereço Locamail",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        CustomOutlinedTextField(
                            value = emailLogin,
                            onValueChange = { emailLogin = it },
//                        placeHolder = stringResource(id = R.string.email)
                            placeHolder = "Email",
                            isError = false,
                            keyboardType = KeyboardType.Email
                        )
                        CustomOutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
//                    placeHolder = stringResource(id = R.string.senha),
                            placeHolder = "Senha",
                            isError = false,
                            keyboardType = KeyboardType.Password,
                            visualTransformation = PasswordVisualTransformation()
                        )
                        Column(
                            modifier = Modifier.fillMaxWidth(),
//                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                onClick = {
                                    val user = User(
                                        id = 0,
                                        firstName = firstName,
                                        lastName = lastName,
                                        dtNascimento = dtNascimento,
                                        gender = gender,
                                        emailLogin = emailLogin,
                                        password = password
                                    )
                                    userRepository.salvar(user)
                                    navController?.navigate("login")
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                                shape = RoundedCornerShape(6.dp),
                                modifier = Modifier
                                    .height(48.dp)
                                    .weight(1f)
                            ) {
                                TextLogin(
//                            text = stringResource(id = R.string.voltar),
                                    text = "cadastrar",
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }
    }



