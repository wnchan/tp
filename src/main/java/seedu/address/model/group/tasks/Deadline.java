package seedu.address.model.group.tasks;

import java.time.LocalDateTime;
import seedu.address.model.group.exceptions.TaskException;

/**
 * The `Deadline` class represents a task with a specific deadline in the Duke program.
 * It is a subclass of the `Task` class and provides functionality to handle tasks with deadlines.
 */
public class Deadline extends Task {

    private String byStr;
    private LocalDateTime by;

    /**
     * Initializes a new `Deadline` task with the specified description, status, module, and deadline.
     *
     * @param task       The description of the task.
     * @param status     The status of the task (complete or incomplete).
     * @param module     The module the task is assigned to (CS2103T or CS2101).
     * @param by         The deadline of the task in string format (dd/MM/yyyy).
     * @throws TaskException If there is an issue parsing the deadline format.
     */
    public Deadline(String task, TaskStatus status, TaskModule module, String by) throws TaskException {
        super(task, status, module, "D", by);
        try {
            this.by = parseDateTime(by);
            this.byStr = by;
        } catch (Exception e) {
            throw new TaskException("Invalid date format :< Please use dd/MM/yyyy\n");
        }
    }

    @Override
    public String getDeadline() {
        return "(by " + this.byStr + ")";
    }

//    /**
//     * Returns a string representation of the `Deadline` task, including its description and deadline.
//     *
//     * @return A formatted string representing the `Deadline` task.
//     */
//    public String toString() {
//        // Format LocalDateTime as a string in your desired output format
//        DateTimeFormatter outputFormatter = DateTimeFormatter
//                .ofPattern("MMM dd yyyy h:mm a");
//        String formattedDateTime = by.format(outputFormatter);
//        return "[D]" + super.toString() + " (by: " + formattedDateTime + ")";
//    }

//    /**
//     * Formats the task's information into a user-friendly string representation.
//     * This method is used to generate a message indicating that a task has been added successfully.
//     *
//     * @return A formatted string message indicating the task addition.
//     */
//    public String printStr() {
//        return ("Got it. I've added this task:\n "
//                + this.toString() + "\n" + "Now you have "
//                + Task.getCounter() + " tasks in the list\n");
//    }

//    /**
//     * Generates a string representation of the `Deadline` task for saving to a file.
//     *
//     * @return A formatted string representing the `Deadline` task for file storage.
//     */
//    @Override
//    public String generateStr() {
//        return "D | " + this.getStatus()
//            + " | " + this.getTask() + " | " + byStr + " | " + this.getModule();
//    }
}
