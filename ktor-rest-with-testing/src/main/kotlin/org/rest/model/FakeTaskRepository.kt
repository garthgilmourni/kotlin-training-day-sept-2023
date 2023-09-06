package org.rest.model

class FakeTaskRepository(private val tasks: MutableList<Task>) : TaskRepository {
    override fun allTasks(): List<Task> = tasks

    override fun tasksByPriority(priority: Priority) = tasks.filter {
        it.priority == priority
    }

    override fun taskByName(name: String) = tasks.find {
        it.name.equals(name, ignoreCase = true)
    }

    override fun addTask(task: Task) {
        if (taskByName(task.name) != null) {
            throw IllegalStateException("Cannot duplicate task names!")
        }
        tasks.add(task)
    }

    override fun removeTask(name: String): Boolean {
        return tasks.removeIf { it.name == name }
    }
}