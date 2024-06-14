package br.com.fiap.locamail.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.locamail.R
import br.com.fiap.locamail.classes.Email
import br.com.fiap.locamail.functions.generateEmails

@Composable
fun MenuScreen(navController: NavController?) {
    val emails = generateEmails(50)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF17161C))
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopAppBar()
        Spacer(modifier = Modifier.height(16.dp))
        EmailList(emails)
        Spacer(modifier = Modifier.height(16.dp))
        ComposeEmailButton()
    }
}

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = "Pesquisar no LocaMail",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Profile",
            modifier = Modifier
                .size(40.dp)
                .background(Color.Gray, CircleShape)
        )
    }
}

@Composable
fun EmailList(emails: List<Email>) {
    LazyColumn {
        items(emails) { email ->
            EmailItem(email = email)
        }
    }
}

@Composable
fun EmailItem(email: Email) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { /* Handle email click */ },
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1F1F1F))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = email.sender, fontWeight = FontWeight.Bold, color = Color.White)
            Text(text = email.subject, style = MaterialTheme.typography.bodyLarge, color = Color.White)
            Text(
                text = email.body,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun ComposeEmailButton() {
    Button(
        onClick = { /* Handle compose email */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF00843)),
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .size(56.dp)
    ) {
        Text("+", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
private fun InboxScreenPreview() {
    MenuScreen(navController = null)
}
