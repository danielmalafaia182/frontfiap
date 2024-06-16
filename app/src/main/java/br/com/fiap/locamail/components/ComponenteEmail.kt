package br.com.fiap.locamail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.locamail.model.EmailItem
import br.com.fiap.locamail.ui.theme.Inter

@Composable
fun ComponenteEmail(emailItem: EmailItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 8.dp)
            .clickable { /* Handle email click */ }
            .then(if (!emailItem.isRead) Modifier.shadow(4.dp) else Modifier),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF181E24))
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = emailItem.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = emailItem.sender,
                        color = if (!emailItem.isRead) Color.White else Color(0xFF5E5D5D),
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.weight(1f),
                        fontFamily = Inter,
                        fontSize = 12.sp
                    )
                    Text(
                        text = emailItem.timestamp,
                        fontWeight = FontWeight.Medium,
                        color = if (!emailItem.isRead) Color.White else Color(0xFF5E5D5D),
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontFamily = Inter,
                        fontSize = 12.sp
                    )
                }
                Text(
                    text = emailItem.subject,
                    fontWeight = FontWeight.Bold,
                    color = if (!emailItem.isRead) Color.White else Color(0xFF5E5D5D),
                    fontFamily = Inter,
                    fontSize = 16.sp
                )
                Text(
                    text = emailItem.body,
                    style = MaterialTheme.typography.bodySmall,
                    overflow = TextOverflow.Ellipsis,
                    color = if (!emailItem.isRead) Color.White else Color(0xFF5E5D5D),
                    fontFamily = Inter,
                )
            }
        }
    }
}