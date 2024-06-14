//package br.com.fiap.locamail.register
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import br.com.fiap.locamail.components.TextLogin
//
//@Composable
//fun RegisterScreen(
//    navController: NavController,
////    userId: Int
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFF17161C))
//            .padding(horizontal = 16.dp)
//    ) {
//        Spacer(modifier = Modifier.height(56.dp))
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.spacedBy(56.dp)
//        ) {
//            Column(
//                verticalArrangement = Arrangement.spacedBy(32.dp)
//            ) {
//                Column(
//                    verticalArrangement = Arrangement.spacedBy(20.dp)
//                ) {
//                    TextLogin(text = "CRIE SUA CONTA", color = )
//                    Text(
//                        text = "CRIE SUA CONTA",
//                        color = Color.White,
//                        fontSize = 12.sp,
//                        fontWeight = FontWeight.Medium,
//                        modifier = Modifier.align(Alignment.Start)
//                    )
//                    Text(
//                        text = "Identificação",
//                        color = Color.White,
//                        fontSize = 20.sp,
//                        fontWeight = FontWeight.Medium,
//                        modifier = Modifier.align(Alignment.Start)
//                    )
//                }
//                Column(
//                    verticalArrangement = Arrangement.spacedBy(24.dp)
//                ) {
//                    Column(
//                        verticalArrangement = Arrangement.spacedBy(12.dp)
//                    ) {
//                        Text(
//                            text = "Nome",
//                            color = Color.White,
//                            fontSize = 12.sp,
//                            fontWeight = FontWeight.Medium
//                        )
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(48.dp)
//                                .background(Color.Transparent)
//                                .padding(horizontal = 16.dp)
//                                .border(2.dp, Color(0xFF495A6B), RoundedCornerShape(6.dp))
//                        ) {
//                            Text(
//                                text = "Daniel",
//                                color = Color.White,
//                                fontSize = 14.sp,
//                                fontWeight = FontWeight.Medium,
//                                modifier = Modifier.align(Alignment.CenterStart)
//                            )
//                        }
//                    }
//                    Column(
//                        verticalArrangement = Arrangement.spacedBy(12.dp)
//                    ) {
//                        Text(
//                            text = "Sobrenome",
//                            color = Color.White,
//                            fontSize = 12.sp,
//                            fontWeight = FontWeight.Medium
//                        )
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(48.dp)
//                                .background(Color.Transparent)
//                                .padding(horizontal = 16.dp)
//                                .border(1.dp, Color(0xFF2A343E), RoundedCornerShape(6.dp))
//                        ) {
//                            Text(
//                                text = "Sobrenome",
//                                color = Color.White.copy(alpha = 0.3f),
//                                fontSize = 14.sp,
//                                fontWeight = FontWeight.Medium,
//                                modifier = Modifier.align(Alignment.CenterStart)
//                            )
//                        }
//                    }
//                }
//            }
//            Column(
//                verticalArrangement = Arrangement.spacedBy(32.dp)
//            ) {
//                Column(
//                    verticalArrangement = Arrangement.spacedBy(20.dp)
//                ) {
//                    Text(
//                        text = "Informações básicas",
//                        color = Color.White,
//                        fontSize = 21.sp,
//                        fontWeight = FontWeight.Medium,
//                        modifier = Modifier.align(Alignment.Start)
//                    )
//                }
//                Column(
//                    verticalArrangement = Arrangement.spacedBy(24.dp)
//                ) {
//                    // Add day, month, year fields here...
//                    // Reuse the same Box structure for these fields
//                    Column(
//                        verticalArrangement = Arrangement.spacedBy(12.dp)
//                    ) {
//                        Text(
//                            text = "Gênero",
//                            color = Color.White,
//                            fontSize = 12.sp,
//                            fontWeight = FontWeight.Medium
//                        )
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(48.dp)
//                                .background(Color.Transparent)
//                                .padding(horizontal = 16.dp)
//                                .border(1.dp, Color(0xFF2A343E), RoundedCornerShape(6.dp))
//                        ) {
//                            Text(
//                                text = "Gênero",
//                                color = Color.White.copy(alpha = 0.3f),
//                                fontSize = 14.sp,
//                                fontWeight = FontWeight.Medium,
//                                modifier = Modifier.align(Alignment.CenterStart)
//                            )
//                        }
//                    }
//                }
//            }
//            Column(
//                verticalArrangement = Arrangement.spacedBy(32.dp)
//            ) {
//                Column(
//                    verticalArrangement = Arrangement.spacedBy(20.dp)
//                ) {
//                    Text(
//                        text = "Endereço LocaMail",
//                        color = Color.White,
//                        fontSize = 21.sp,
//                        fontWeight = FontWeight.Medium,
//                        modifier = Modifier.align(Alignment.Start)
//                    )
//                }
//                Column(
//                    verticalArrangement = Arrangement.spacedBy(24.dp)
//                ) {
//                    // Add email field here...
//                }
//            }
//            Column(
//                verticalArrangement = Arrangement.spacedBy(32.dp)
//            ) {
//                Column(
//                    verticalArrangement = Arrangement.spacedBy(20.dp)
//                ) {
//                    Text(
//                        text = "Crie uma senha forte",
//                        color = Color.White,
//                        fontSize = 21.sp,
//                        fontWeight = FontWeight.Medium,
//                        modifier = Modifier.align(Alignment.Start)
//                    )
//                }
//                Column(
//                    verticalArrangement = Arrangement.spacedBy(24.dp)
//                ) {
//                    // Add password fields here...
//                }
//            }
//            Column(
//                verticalArrangement = Arrangement.spacedBy(32.dp)
//            ) {
//                Column(
//                    verticalArrangement = Arrangement.spacedBy(20.dp)
//                ) {
//                    Text(
//                        text = "Adicionar email de recuperação",
//                        color = Color.White,
//                        fontSize = 21.sp,
//                        fontWeight = FontWeight.Medium,
//                        modifier = Modifier.align(Alignment.Start)
//                    )
//                }
//                Column(
//                    verticalArrangement = Arrangement.spacedBy(24.dp)
//                ) {
//                    // Add recovery email field here...
//                }
//            }
//        }
//        Spacer(modifier = Modifier.height(56.dp))
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Box(
//                modifier = Modifier
//                    .weight(1f)
//                    .height(48.dp)
//                    .background(Color(0xFF2A343E), RoundedCornerShape(6.dp))
//                    .clickable { /* TODO: Handle Back */ },
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = "Voltar",
//                    color = Color.White,
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//            Spacer(modifier = Modifier.width(12.dp))
//            Box(
//                modifier = Modifier
//                    .weight(1f)
//                    .height(48.dp)
//                    .background(Color(0xFFF00843), RoundedCornerShape(6.dp))
//                    .clickable { /* TODO: Handle Next */ },
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = "Avançar",
//                    color = Color.White,
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(24.dp))
//        Row(
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            horizontalArrangement = Arrangement.spacedBy(24.dp)
//        ) {
//            Text(
//                text = "Ajuda",
//                color = Color(0xFF898891),
//                fontSize = 12.sp,
//                fontWeight = FontWeight.Medium
//            )
//            Text(
//                text = "Privacidade",
//                color = Color(0xFF898891),
//                fontSize = 12.sp,
//                fontWeight = FontWeight.Medium
//            )
//            Text(
//                text = "Termos",
//                color = Color(0xFF898891),
//                fontSize = 12.sp,
//                fontWeight = FontWeight.Medium
//            )
//        }
//    }
//}