package seedu.address.model.group.tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import seedu.address.model.group.exceptions.TaskException;


/**
 * The Task class represents a task in the StudentConnect application.
 */
public class Task {
    private static int counter = 0;

    private String task;
    private TaskStatus status;
    private TaskModule module;
    private String type;
    private String by;

    /**
     * Constructs a Task object with a task description, status, module, and save status.
     *
     * @param task       The description of the task.
     * @param status     The status of the task (complete or incomplete).
     * @param module     The module the task is assigned to (CS2103T or CS2101).
     * @param type       The type of task, either a deadline or a todo.
     * @param by         The date the task must be completed by, empty for a todo.
     */
    public Task(String task, TaskStatus status, TaskModule module, String type, String by) {
        this.task = task;
        this.status = status;
        this.module = module;
        this.type = type;
        this.by = by;

        if (!task.isEmpty()) {
            addTask(this.task);
        }
    }

    /**
     * Empty constructor for Task.
     */
    public Task() {

    }

    /**
     * Returns a string representation of the task.
     *
     * @return A string representing the task's status and description.
     */
    @Override
    public String toString() {
        return this.type + status.toString() + " " + this.module + " " + this.task + " " + this.by;
    }

    /**
     * Adds a task to the list of tasks.
     *
     * @param task The task description to add.
     */
    public void addTask(String task) {
        if (!task.equals("")) {
            if (!task.isEmpty()) {
                //Duke.taskList.addTask(this); //need to change according to how we implement the main class
                counter++;
            }
        }
    }

    /**
     * Gets the count of tasks.
     *
     * @return The count of tasks.
     */
    public static int getCounter() {
        return counter;
    }

    /**
     * Gets the status of the task.
     *
     * @return The status of the task.
     */
    public TaskStatus getStatus() {
        return this.status;
    }

    /**
     * Sets the status of the task.
     *
     * @param taskStatus The status to set.
     */
    public void setStatus(TaskStatus taskStatus) {
        this.status = taskStatus;
    }

    /**
     * Gets the module of the task.
     *
     * @return The module the task is assigned to.
     */
    public TaskModule getModule() {
        return module;
    }

    /**
     * Gets the description of the task.
     *
     * @return The task description.
     */
    public String getTask() {
        return this.task;
    }

    /**
     * Gets the type of the task.
     *
     * @return The task type.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Gets the deadline of the task.
     *
     * @return The task deadline.
     */
    public String getBy() {
        return this.by;
    }

    /**
     * Parses a date and time string to a LocalDateTime object.
     *
     * @param dateTimeString The date and time string in the format "dd/MM/yyyy HHmm".
     * @return A LocalDateTime object representing the parsed date and time.
     * @throws TaskException If the date and time string has an invalid format.
     */
    public LocalDateTime parseDateTime(String dateTimeString) throws TaskException {
        // Split the input string into date and time parts
        String[] parts = dateTimeString.split(" ", 2);

        // Check if there are exactly two parts (date and time)
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid date/time format: "
                    + dateTimeString);
        }

        String datePart = parts[0];
        String timePart = parts[1];

        // Define a formatter for the date part, e.g., "dd/MM/yyyy"
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Parse the date part into a LocalDate object
        LocalDate date = LocalDate.parse(datePart, dateFormatter);

        // Define a formatter for the time part, e.g., "HHmm"
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");
        // Parse the time part into a LocalTime object
        LocalTime time = LocalTime.parse(timePart, timeFormatter);

        // Combine the date and time into a LocalDateTime object
        return LocalDateTime.of(date, time);
    }

    /**
     * Formats the list of tasks into a human-readable string.
     *
     * @return A formatted string containing the tasks in the list.
     */
    public String formatList() {
        StringBuilder formattedList = new StringBuilder();
        formattedList.append("Here are the tasks in your list:\n");

        /*for (int i = 0; i < Duke.taskList.size(); i++) {
            Task task = Duke.taskList.getTasks().get(i);
            formattedList.append((i + 1)).append(". ").append(task.toString()).append("\n");
        }*/

        //formattedList.append(Ui.horizontalLine);
        return formattedList.toString();
    }


    /**
     * Gets the type of the task.
     *
     * @return The string representing task type.
     */
    public String getTaskType() {
        // Your logic to determine the task type based on the instance's actual class
        if (this instanceof Todo) {
            return "T";
        } else if (this instanceof Deadline) {
            return "D";
        } else {
            return ""; // Handle unknown task types or add appropriate logic
        }
    }

    /**
     * Marks the task as done.
     */
    public void mark() {
        this.status = TaskStatus.DONE;
    }

    /**
     * Marks the task as not done.
     */
    public void unMark() {
        this.status = TaskStatus.NOT_DONE;
    }

    /**
     * Checks if the current task contains the specified keyword.
     *
     * @param keyword The keyword to search for within the task.
     * @return {@code true} if the task contains the keyword,
     *     {@code false} otherwise.
     */
    public boolean contains(String keyword) {
        return task.contains(keyword);
    }

    /*/**
     * Deletes a task from the task list and updates the
     * storage file accordingly.
     *
     * @param i The index of the task to be deleted.
     * @return A message confirming the deletion of the task and
     * the current task count.
     * @throws TaskException If the provided index is invalid.
     */
    /*public String delete(int i) throws TaskException {
        if (i > Duke.taskList.size() || i <= 0) {
            throw new TaskException(
                    "OOPS!!! Invalid number :(\n");
        }
        Task deleteTask = Duke.taskList.getTasks().get(i - 1);
        counter = counter - 1;
        Duke.taskList.deleteTask(i - 1);
        Storage.deleteLineFromFile(i);
        return ("Noted. I've removed this task:\n" + deleteTask.toString()
                + "\n" + String.format("Now you have %d tasks in the list\n", counter)
                );
    }*/

    /**
     * Generates String representation to be saved in text file.
     */
    public String generateStr() {
        return task;
    }
    public String getDeadline() {
        if (this.getTaskType() == "D") {
            return this.getDeadline();
        } else {
            return "";
        }
    }

    /**
     * Saves the task to a file.
     */
    public void saveToFile() {
        return;
    }
}
