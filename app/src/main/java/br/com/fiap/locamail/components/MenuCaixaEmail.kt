package br.com.fiap.locamail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.ArrowRight
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MenuCaixaEmail(
    isEmailListVisible: Boolean,
    unreadCount: Int,
    onClick: () -> Unit,
    nomeCaixaEmail: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { onClick() }
        ) {
            Icon(
                imageVector = if (isEmailListVisible) Icons.Outlined.ArrowDropDown else Icons.Outlined.ArrowRight,
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = "$nomeCaixaEmail ($unreadCount)",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.Tune,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable { }
            )
            Icon(
                imageVector = Icons.Outlined.MoreVert,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable { }
            )
        }
    }
}