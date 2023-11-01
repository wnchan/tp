package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.group.tasks.Task;
import seedu.address.model.group.tasks.TaskModule;
import seedu.address.model.group.tasks.TaskStatus;

/**
 * Jackson-friendly version of {@link Task}.
 */
public class JsonAdaptedTask {
    private final String task;
    private final String status;
    private final String module;

    /**
     * Constructs a {@code JsonAdaptedTask} with the given task details.
     */
    @JsonCreator
    public JsonAdaptedTask(@JsonProperty("task") String task,
                           @JsonProperty("status") String status,
                           @JsonProperty("module") String module) {
        this.task = task;
        this.status = status;
        this.module = module;
    }

    /**
     * Converts a given {@code Task} into this class for Jackson use.
     */
    public JsonAdaptedTask(Task source) {
        task = source.getTask();
        status = source.getStatus().toString();
        module = source.getModule().toString();
    }

    /**
     * Converts this Jackson-friendly adapted task object into the model's {@code Task} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted task.
     */
    public Task toModelType() throws IllegalValueException {
        if (task == null) {
            throw new IllegalValueException("Task's description is missing!");
        }

        if (status == null) {
            throw new IllegalValueException("Task's status is missing!");
        }
        if (!TaskStatus.isValidStatus(status)) {
            throw new IllegalValueException(TaskStatus.MESSAGE_CONSTRAINTS);
        }
        final TaskStatus modelStatus = TaskStatus.valueOf(status);

        if (module == null) {
            throw new IllegalValueException("Task's module is missing!");
        }
        if (!TaskModule.isValidModule(module)) {
            throw new IllegalValueException(TaskModule.MESSAGE_CONSTRAINTS);
        }
        final TaskModule modelModule = TaskModule.valueOf(module);

        return new Task(task, modelStatus, modelModule);
    }
}
