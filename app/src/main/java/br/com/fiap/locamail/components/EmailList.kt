package br.com.fiap.locamail.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import br.com.fiap.locamail.classes.Email

@Composable
fun EmailList(emails: List<Email>) {
    LazyColumn {
        items(emails) { email ->
            ComponenteEmail(email = email)
        }
    }
}