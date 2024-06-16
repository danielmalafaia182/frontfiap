    package br.com.fiap.locamail.model

    data class EmailItem(
        val sender: String,
        val subject: String,
        val body: String,
        val isRead: Boolean,
        val imageId: Int,
        val timestamp: String
    )
