package seedu.address.model.group.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import seedu.address.model.group.exceptions.TaskException;

public class DeadlineTest {
    void testToString() throws TaskException {
        Deadline deadline = new Deadline("Finish assignment", TaskStatus.NOT_DONE, TaskModule.CS2101,
                "23/09/2023 1300");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy h:mm a");
        String expectedFormattedDateTime = LocalDateTime.parse("23/09/2023 1300",
                DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm")).format(outputFormatter);
        String expectedToString = "[D][ ] CS2101 Finish assignment (by: " + expectedFormattedDateTime + ")";
        assertEquals(expectedToString, deadline.toString());
    }

    @Test
    void testGenerateStr() throws TaskException {
        Deadline deadline = new Deadline("Finish assignment", TaskStatus.DONE, TaskModule.CS2103T, "23/09/2023 1300");
        String expectedGenerateStr = "D | 0 | Finish assignment | 23/09/2023 1300";
        assertEquals(expectedGenerateStr, deadline.generateStr());
    }
}
