package br.com.fiap.locamail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.locamail.cadastro.RegisterScreen
import br.com.fiap.locamail.components.BackPressHandler
import br.com.fiap.locamail.login.LoginScreen
import br.com.fiap.locamail.menu.MenuScreen
import br.com.fiap.locamail.ui.theme.LocaMailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LocaMailTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "register"
                    ) {
                        composable(route = "login") {
                            LoginScreen(navController)
                        }
                        composable(route = "menu") {
                            MenuScreen(navController)
                        }
                        composable(route = "register") {
                            RegisterScreen(navController)
                        }
                    }
                    BackPressHandler(navController)
                }
            }
        }
    }
}
