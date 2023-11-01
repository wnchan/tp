package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.testutil.TypicalGroups;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeleteGroupCommandTest {

    @Test
    public void execute_validGroupNumber_success() throws CommandException {
        Model model = new ModelManager(TypicalGroups.getTypicalAddressBook(), new UserPrefs());
        DeleteGroupCommand deleteGroupCommand = new DeleteGroupCommand(1);
        String expectedMessage = String.format(DeleteGroupCommand.MESSAGE_DELETE_GROUP_SUCCESS, TypicalGroups.GROUP1);

        CommandResult commandResult = deleteGroupCommand.execute(model);

        assertEquals(expectedMessage, commandResult.getFeedbackToUser());
    }

    @Test
    public void execute_invalidGroupNumber_throwsCommandException() {
        Model model = new ModelManager(TypicalGroups.getTypicalAddressBook(), new UserPrefs());
        DeleteGroupCommand deleteGroupCommand = new DeleteGroupCommand(4);

        assertThrows(CommandException.class, () -> deleteGroupCommand.execute(model));
    }
}
