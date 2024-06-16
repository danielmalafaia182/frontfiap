package br.com.fiap.locamail.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Drafts
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Outbox
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Report
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.rememberDrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.locamail.R
import br.com.fiap.locamail.components.DrawerItem
import br.com.fiap.locamail.components.EmailList
import br.com.fiap.locamail.components.MenuCaixaEmail
import br.com.fiap.locamail.components.MenuSearchBar
import br.com.fiap.locamail.functions.contains
import br.com.fiap.locamail.functions.generateEmails
import br.com.fiap.locamail.ui.theme.Inter
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun MenuScreen(navController: NavController?) {
    var searchBar by remember { mutableStateOf("") }
    var isPrincipalVisible by remember { mutableStateOf(true) }
    var isLocaMailVisible by remember { mutableStateOf(false) }
    var isDominioXVisible by remember { mutableStateOf(false) }
    var isDominioYVisible by remember { mutableStateOf(false) }

    val principalEmails by remember { mutableStateOf(generateEmails()) }
    val locaMailEmails by remember { mutableStateOf(generateEmails()) }
    val dominioXEmails by remember { mutableStateOf(generateEmails()) }
    val dominioYEmails by remember { mutableStateOf(generateEmails()) }

    val filteredPrincipalEmails = principalEmails.filter { it.contains(searchBar) }
    val filteredLocaMailEmails = locaMailEmails.filter { it.contains(searchBar) }
    val filteredDominioXEmails = dominioXEmails.filter { it.contains(searchBar) }
    val filteredDominioYEmails = dominioYEmails.filter { it.contains(searchBar) }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color(0xFF181E24))
                    .padding(16.dp)
                    .padding(top = 16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logoheader),
                        contentDescription = stringResource(id = R.string.locaMailLogo),
                        modifier = Modifier
                            .width(107.18.dp)
                            .height(27.47.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = stringResource(id = R.string.OFFLINE),
                            color = Color(0xFFF00843),
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .offset(y = 5.dp),
                            fontFamily = Inter,
                            fontSize = 14.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.INBOXES),
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontFamily = Inter,
                    fontSize = 12.sp
                )
                DrawerItem(stringResource(id = R.string.all_email_boxes), filteredPrincipalEmails.size, Icons.Default.Inbox) {
                    coroutineScope.launch {
                        drawerState.close()
                        if (!isPrincipalVisible) {
                            isPrincipalVisible = true
                            isLocaMailVisible = false
                            isDominioXVisible = false
                            isDominioYVisible = false
                        }
                    }
                }
                DrawerItem(stringResource(id = R.string.app_name), filteredLocaMailEmails.size, Icons.Default.LocalOffer) {
                    coroutineScope.launch {
                        drawerState.close()
                        if (!isLocaMailVisible) {
                            isPrincipalVisible = false
                            isLocaMailVisible = true
                            isDominioXVisible = false
                            isDominioYVisible = false
                        }
                    }
                }
                DrawerItem(stringResource(id = R.string.x_domain), filteredDominioXEmails.size, Icons.Default.People) {
                    coroutineScope.launch {
                        drawerState.close()
                        if (!isDominioXVisible) {
                            isPrincipalVisible = false
                            isLocaMailVisible = false
                            isDominioXVisible = true
                            isDominioYVisible = false
                        }
                    }
                }
                DrawerItem(stringResource(id = R.string.y_domain), filteredDominioYEmails.size, Icons.Default.People) {
                    coroutineScope.launch {
                        drawerState.close()
                        if (!isDominioYVisible) {
                            isPrincipalVisible = false
                            isLocaMailVisible = false
                            isDominioXVisible = false
                            isDominioYVisible = true
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.emails),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontFamily = Inter,
                    fontSize = 12.sp
                )
                DrawerItem("Com estrela", Random.nextInt(1, 99), Icons.Default.Star, {})
                DrawerItem("Baixados", Random.nextInt(1, 99), Icons.Default.Schedule, {})
                DrawerItem("Enviados", 0, Icons.Default.Send, {})
                DrawerItem("Caixa de saída", 0, Icons.Default.Outbox, {})
                DrawerItem("Rascunhos", 0, Icons.Default.Drafts, {})
                DrawerItem("Spam", 0, Icons.Default.Report, {})
                DrawerItem("Lixeira", 0, Icons.Default.Delete, {})
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.CALENDAR),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontFamily = Inter,
                    fontSize = 12.sp
                )
                DrawerItem(stringResource(id = R.string.CALENDAR), Random.nextInt(1, 99), Icons.Default.CalendarMonth, {})
                Row {
                    Text(
                        text = stringResource(id = R.string.online_update_message),
                        color = Color(0xFFF00843),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp),
                        fontFamily = Inter,
                        fontSize = 14.sp
                    )
                }
            }
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF181E24))
                    .padding(start = 16.dp)
                    .padding(vertical = 24.dp),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.menulogo),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .clickable {
                                    coroutineScope.launch {
                                        drawerState.open()
                                    }
                                }
                        )
                        MenuSearchBar(
                            searchBar = searchBar,
                            onSearchBarChange = { searchBar = it }
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        MenuCaixaEmail(
                            isEmailListVisible = isPrincipalVisible,
                            unreadCount = filteredPrincipalEmails.count { !it.isRead },
                            onClick = { isPrincipalVisible = !isPrincipalVisible },
                            nomeCaixaEmail = stringResource(id = R.string.all_email_boxes)
                        )
                        if (isPrincipalVisible) {
                            EmailList(emailItems = filteredPrincipalEmails)
                        }
                        MenuCaixaEmail(
                            isEmailListVisible = isLocaMailVisible,
                            unreadCount = filteredLocaMailEmails.count { !it.isRead },
                            onClick = { isLocaMailVisible = !isLocaMailVisible },
                            nomeCaixaEmail = stringResource(id = R.string.app_name)
                        )
                        if (isLocaMailVisible) {
                            EmailList(emailItems = filteredLocaMailEmails)
                        }

                        MenuCaixaEmail(
                            isEmailListVisible = isDominioXVisible,
                            unreadCount = filteredDominioXEmails.count { !it.isRead },
                            onClick = { isDominioXVisible = !isDominioXVisible },
                            nomeCaixaEmail = stringResource(id = R.string.x_domain)
                        )
                        if (isDominioXVisible) {
                            EmailList(emailItems = filteredDominioXEmails)
                        }

                        MenuCaixaEmail(
                            isEmailListVisible = isDominioYVisible,
                            unreadCount = filteredDominioYEmails.count { !it.isRead },
                            onClick = { isDominioYVisible = !isDominioYVisible },
                            nomeCaixaEmail = stringResource(id = R.string.y_domain)
                        )
                        if (isDominioYVisible) {
                            EmailList(emailItems = filteredDominioYEmails)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
                FloatingActionButton(
                    onClick = { /* Handle new email click */ },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)
                        .height(48.dp)
                        .width(139.dp)
                        .offset(
                            y = -(14.dp)
                        ),
                    shape = CircleShape,
                    containerColor = Color(0xFFF00843)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(
                                horizontal = 12.dp,
                                vertical = 8.dp,
                            )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.email),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .height(24.dp)
                                .width(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = stringResource(id = R.string.new_email),
                            color = Color.White,
                            fontFamily = Inter,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
private fun InboxScreenPreview() {
    MenuScreen(navController = null)
}