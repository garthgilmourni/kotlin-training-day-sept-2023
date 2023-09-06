package org.rest.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.ktor.client.*
import kotlinx.coroutines.launch
import org.rest.io.fetchAllTasks
import org.rest.model.Task

@Composable
fun Example1(client: HttpClient) {
    val scope = rememberCoroutineScope()
    val tasks = remember { mutableStateOf(emptyList<Task>()) }

    fun loadAllTasks() = scope.launch {
        tasks.value = client.fetchAllTasks()
    }

    fun clearAllTasks() {
        tasks.value = emptyList()
    }

    Header("Example 1: Viewing All Tasks")
    Row {
        Button(
            onClick = ::loadAllTasks,
            modifier = Modifier.padding(end = 5.dp)
        ) {
            Text("Load Tasks")
        }
        Button(
            onClick = ::clearAllTasks,
            modifier = Modifier.padding(end = 5.dp)
        ) {
            Text("Clear Tasks")
        }
    }
    Row {
        LazyColumn(modifier = Modifier.height(120.dp).padding(10.dp)) {
            itemsIndexed(tasks.value) { index, task ->
                TaskRow(task, index % 2 == 0)
            }
        }
    }
}