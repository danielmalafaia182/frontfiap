package br.com.fiap.locamail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.locamail.classes.Email
import br.com.fiap.locamail.functions.generateEmails

@Composable
fun EmailComp(email: Email) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { /* Handle email click */ }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            TextLogin(text = email.sender, color = Color.White)
            TextLogin(text = email.subject, color = Color.White)
            TextLogin(text = email.body, color = Color.White)
        }
    }
}

@Composable
fun EmailList(emails: List<Email>) {
    LazyColumn {
        items(emails) { email ->
            EmailComp(email = email)
        }
    }
}

@Composable
fun InboxScreen() {
    val emails = generateEmails(50)
    EmailList(emails = emails)
}

@Preview(showBackground = true)
@Composable
fun InboxScreenPreview() {
    InboxScreen()
}

