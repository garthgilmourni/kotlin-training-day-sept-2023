package org.rest.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.ktor.client.*

@Composable
fun App(client: HttpClient) {
    MaterialTheme {
        Column(modifier = Modifier.padding(20.dp)) {
            Example1(client)
            Rule()
            Example2(client)
        }
    }
}