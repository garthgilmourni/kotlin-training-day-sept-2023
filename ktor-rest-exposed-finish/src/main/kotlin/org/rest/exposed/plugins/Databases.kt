package org.rest.exposed.plugins

import io.ktor.server.application.*
import org.jetbrains.exposed.sql.*

fun Application.configureDatabases() {
    Database.connect(
        "jdbc:postgresql://localhost:5432/ktor_workshop",
        user = "postgres",
        password = "password"
    )
}
