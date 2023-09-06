package org.fundamentals.view

import org.fundamentals.model.Task

fun Task.taskAsRow() = """
        <tr>
            <td>$name</td><td>$description</td><td>$priority</td>
        </tr>
    """.trimIndent()

fun List<Task>.tasksAsTable() = this.joinToString(
    prefix = "<table rules=\"all\">",
    postfix = "</table>",
    separator = "\n",
    transform = Task::taskAsRow
)