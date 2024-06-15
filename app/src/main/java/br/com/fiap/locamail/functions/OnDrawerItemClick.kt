package br.com.fiap.locamail.functions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

suspend fun OnDrawerItemClick(coroutineScope: CoroutineScope, drawerState: androidx.compose.material.DrawerState, toggleVisibility: () -> Unit) {
    toggleVisibility()
    coroutineScope.launch {
        drawerState.close()
    }
}