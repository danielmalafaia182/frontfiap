package br.com.fiap.locamail.classes

data class Email(
    val sender: String,
    val subject: String,
    val body: String,
    val isRead: Boolean
)
