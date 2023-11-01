package seedu.address.model.group.tasks;

import java.util.ArrayList;
import java.util.List;

import seedu.address.model.group.exceptions.TaskException;

public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public TaskList(List<Task> initialTasks) {
        tasks = new ArrayList<>(initialTasks);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.remove(taskIndex);
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public boolean isTaskInAllTasks(String taskType, String taskDescription) {
        for (Task task : tasks) {
            if (task.getTask().equals(taskDescription) && task.getTaskType().equals(taskType)) {
                return true;
            }
        }
        return false;
    }

    public void addTasks(List<Task> tasks) {
        this.tasks.addAll(tasks);
    }

    /**
     * Returns true if the task list is empty.
     *
     * @return True if the task list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public List<Task> getTaskList() {
        return new ArrayList<>(tasks);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String tempStatus;
        for (Task task : tasks) {
            if (task.getStatus() == TaskStatus.NOT_DONE) {
                tempStatus = "[ ]";
            } else {
                tempStatus = "[X]";
            }
            result.append(task.getType()).append(tempStatus).append(" ").append(task.getModule()).append(" ")
                .append(task.getTask()).append(" ").append(task.getBy()).append("\n");

        }
        return String.valueOf(result);
    }
}
