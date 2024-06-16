package br.com.fiap.locamail.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import br.com.fiap.locamail.model.EmailItem

@Composable
fun EmailList(emailItems: List<EmailItem>) {
    LazyColumn {
        items(emailItems) { email ->
            ComponenteEmail(emailItem = email)
        }
    }
}