package org.applications.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.thymeleaf.Thymeleaf
import io.ktor.server.thymeleaf.ThymeleafContent
import org.applications.model.TaskRepository
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

fun Application.configureTemplating() {
    install(Thymeleaf) {
        setTemplateResolver(ClassLoaderTemplateResolver().apply {
            prefix = "templates/thymeleaf/"
            suffix = ".html"
            characterEncoding = "utf-8"
        })
    }
    routing {
        route("/tasks") {
            get {
                val tasks = TaskRepository.allTasks()
                call.respond(ThymeleafContent("all-tasks", mapOf("tasks" to tasks)))
            }
            get("/byName") {
                val name = call.request.queryParameters["taskName"]
                if (name == null) {
                    call.respond(HttpStatusCode.BadRequest)
                    return@get
                }
                val task = TaskRepository.taskByName(name)
                if (task == null) {
                    val message = "There is no task called '$name'"
                    call.respond(ThymeleafContent("error", mapOf("message" to message)))
                    return@get
                }
                call.respond(ThymeleafContent("single-task", mapOf("task" to task)))
            }
        }
    }
}
