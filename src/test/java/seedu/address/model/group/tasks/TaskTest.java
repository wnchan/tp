package seedu.address.model.group.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import seedu.address.model.group.exceptions.TaskException;

public class TaskTest {

    @Test
    void constructor_withValidArguments_createsCorrectTaskObject() {
        Task task = new Task("Read book", TaskStatus.NOT_DONE, TaskModule.CS2101, "TODO", "");
        assertEquals("Read book", task.getTask());
        assertEquals(TaskStatus.NOT_DONE, task.getStatus());
        assertEquals(TaskModule.CS2101, task.getModule());
        assertEquals("TODO", task.getType());
        assertEquals("", task.getBy());
    }

    @Test
    void toString_validTask_correctStringRepresentation() {
        Task task = new Task("Read book", TaskStatus.NOT_DONE, TaskModule.CS2101, "TODO", "");
        String expected = "TODO NOT_DONE CS2101 Read book ";
        assertEquals(expected, task.toString());
    }

    @Test
    void setStatus_setsNewStatus_statusIsUpdated() {
        Task task = new Task("Read book", TaskStatus.NOT_DONE, TaskModule.CS2101, "TODO", "");
        task.setStatus(TaskStatus.DONE);
        assertEquals(TaskStatus.DONE, task.getStatus());
    }

    @Test
    void parseDateTime_validDateTimeString_parsesCorrectly() throws TaskException {
        Task task = new Task();
        LocalDateTime expectedDateTime = LocalDateTime.of(2023, 9, 23, 23, 59);
        assertEquals(expectedDateTime, task.parseDateTime("23/09/2023 2359"));
    }

    @Test
    void parseDateTime_invalidDateTimeString_throwsException() {
        Task task = new Task();
        assertThrows(IllegalArgumentException.class, () -> {
            task.parseDateTime("invalid-date-time");
        });
    }

    @Test
    void mark_asDone_taskIsMarkedDone() {
        Task task = new Task("Read book", TaskStatus.NOT_DONE, TaskModule.CS2101, "TODO", "");
        task.mark();
        assertEquals(TaskStatus.DONE, task.getStatus());
    }

    @Test
    void unMark_asNotDone_taskIsMarkedNotDone() {
        Task task = new Task("Read book", TaskStatus.DONE, TaskModule.CS2101, "TODO", "");
        task.unMark();
        assertEquals(TaskStatus.NOT_DONE, task.getStatus());
    }
}
