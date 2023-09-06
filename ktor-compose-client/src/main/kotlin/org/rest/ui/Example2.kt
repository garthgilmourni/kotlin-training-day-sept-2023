package org.rest.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.ktor.client.*
import org.rest.io.fetchTasksByPriority
import org.rest.model.Priority
import org.rest.model.Task

@Composable
fun Example2(client: HttpClient) {
    val selectedPriority = remember { mutableStateOf(Priority.values()[0]) }
    val tasks = remember { mutableStateOf(emptyList<Task>()) }

    fun switchPriority(priority: Priority) {
        selectedPriority.value = priority
    }

    LaunchedEffect(selectedPriority.value) {
        tasks.value = client.fetchTasksByPriority(selectedPriority.value)
    }

    Header("Example 2: Viewing Tasks By Priority")

    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(Priority.values()) { priority ->
            Button(
                onClick = { switchPriority(priority) },
                modifier = Modifier.padding(end = 5.dp)
            ) {
                Text(priority.toString())
            }
        }
    }
    Row {
        SubHeader("All the tasks with priority ${selectedPriority.value}")
    }
    Row {
        LazyColumn(modifier = Modifier.height(100.dp).padding(10.dp)) {
            itemsIndexed(tasks.value) { index, task ->
                TaskRow(task, index % 2 == 0)
            }
        }
    }
}