package org.rest.exposed

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.rest.exposed.db.PostgresTaskRepository
import org.rest.exposed.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureDatabases()
    configureRouting()
    val repository = PostgresTaskRepository()
    configureSerialization(repository)
}
