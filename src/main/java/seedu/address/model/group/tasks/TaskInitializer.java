package seedu.address.model.group.tasks;

import java.util.ArrayList;
import java.util.List;
import seedu.address.model.group.exceptions.TaskException;

public class TaskInitializer {
    public static TaskList initializeTasks() throws TaskException {
        // Create an empty TaskList
        TaskList taskList = new TaskList();

        List<Task> allTasks = new ArrayList<>();

        // Create tasks for CS2101
        allTasks.add(new Todo("Upload video of op1", TaskStatus.NOT_DONE, TaskModule.CS2101));
        allTasks.add(new Todo("Complete peer review for op1", TaskStatus.NOT_DONE, TaskModule.CS2101));
        allTasks.add(new Deadline("Submit slides for op2", TaskStatus.NOT_DONE, TaskModule.CS2101, "29/10/2023 2359"));
        allTasks.add(new Deadline("Complete peer review", TaskStatus.NOT_DONE, TaskModule.CS2101, "02/11/2023 2359"));
        allTasks.add(new Todo("Research on the SCQA framework", TaskStatus.NOT_DONE, TaskModule.CS2101));
        allTasks.add(new Deadline("plan for op2 ", TaskStatus.NOT_DONE, TaskModule.CS2101, "24/10/2023 2359"));
        allTasks.add(new Deadline("submit UG", TaskStatus.NOT_DONE, TaskModule.CS2101, "09/11/2023 2359"));

        // Create tasks for CS2103T
        allTasks.add(new Todo("complete mid semester review form", TaskStatus.NOT_DONE, TaskModule.CS2103T));
        allTasks.add(new Deadline("add demo screenshots to project notes", TaskStatus.NOT_DONE, TaskModule.CS2103T, "20/10/2023 2359"));
        allTasks.add(new Deadline("release v1.3.trial jar file", TaskStatus.NOT_DONE, TaskModule.CS2103T, "27/10/2023 2359"));
        allTasks.add(new Deadline("wrap up mileston 1.3", TaskStatus.NOT_DONE, TaskModule.CS2103T, "03/11/2023 2359"));
        allTasks.add(new Deadline("finalise tp", TaskStatus.NOT_DONE, TaskModule.CS2103T, "17/11/2023 2359"));
        allTasks.add(new Todo("update dg for each feature", TaskStatus.NOT_DONE, TaskModule.CS2103T));

        // Add the tasks to the TaskList
        taskList.addTasks(allTasks);
        return taskList;
    }
}
