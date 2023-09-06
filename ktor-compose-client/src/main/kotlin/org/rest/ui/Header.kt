package org.rest.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(headerText: String) {
    Text(
        text = headerText,
        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp),
        modifier = Modifier.padding(bottom = 10.dp)
    )
}