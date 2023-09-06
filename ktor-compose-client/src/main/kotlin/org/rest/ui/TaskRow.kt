package org.rest.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.rest.model.Task

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TaskRow(task: Task, isEven: Boolean) {
    fun pickColor() = if (isEven) Color.LightGray else Color.White

    var backgroundColor by remember { mutableStateOf(pickColor()) }

    val style = remember {
        TextStyle(
            color = Color.Black,
            fontSize = 16.sp,
        )
    }

    val baseRowModifier = remember {
        Modifier
            .fillMaxWidth()
            .then(Modifier.onPointerEvent(
                PointerEventType.Enter,
                onEvent = { backgroundColor = Color.Yellow }
            ))
            .then(Modifier.onPointerEvent(
                PointerEventType.Exit,
                onEvent = { backgroundColor = pickColor() }
            ))
    }

    val rowModifier = baseRowModifier.then(Modifier.background(color = backgroundColor))

    Row(modifier = rowModifier) {
        Text(
            task.description,
            style = style,
            modifier = Modifier.padding(end = 10.dp)
        )
        Text(
            "(${task.name})",
            style = style,
        )
    }
}