package br.com.fiap.locamail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.locamail.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuSearchBar(searchBar: String, onSearchBarChange: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF181E24))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = searchBar,
            onValueChange = onSearchBarChange,
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_bar),
                    fontSize = 14.sp,
                    color = Color.White
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .weight(1f)
                .height(48.dp)
                .background(Color(0xFF2A343E), RoundedCornerShape(50)),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                focusedTextColor = Color.White
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = stringResource(id = R.string.search_icon),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(4.dp))
            },
            trailingIcon = {
                Row(
                    modifier = Modifier.padding(end = 8.dp) // Add padding to the Row
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Mic,
                        contentDescription = stringResource(id = R.string.mic_icon),
                        tint = Color.White
                    )
                }
            }
        )
    }
}
