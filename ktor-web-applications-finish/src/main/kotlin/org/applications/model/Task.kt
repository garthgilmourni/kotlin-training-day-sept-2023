package org.applications.model

data class Task(
    val name: String,
    val description: String,
    val priority: Priority
)