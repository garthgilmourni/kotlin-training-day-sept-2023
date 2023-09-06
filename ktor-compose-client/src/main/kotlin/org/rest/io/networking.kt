package org.rest.io

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import org.rest.model.Priority
import org.rest.model.Task

const val ROOT_URL = "http://0.0.0.0:8080"

fun buildClient() = HttpClient(CIO) {
    install(ContentNegotiation) {
        json()
    }
    defaultRequest {
        url(ROOT_URL)
    }
}

suspend fun HttpClient.fetchTasksByPriority(priority: Priority): List<Task> {
    val response = this.get("/tasks/byPriority/${priority}")
    if (!response.status.isSuccess()) {
        return emptyList()
    }
    return response.body<List<Task>>()
}

suspend fun HttpClient.fetchAllTasks(): List<Task> {
    val response = this.get("/tasks")
    if (!response.status.isSuccess()) {
        return emptyList()
    }
    return response.body<List<Task>>()
}