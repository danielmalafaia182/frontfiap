package br.com.fiap.locamail.classes

import java.sql.Timestamp

data class Email(
    val sender: String,
    val subject: String,
    val body: String,
    val isRead: Boolean,
    val imageId: Int,
    val timestamp: String
)
