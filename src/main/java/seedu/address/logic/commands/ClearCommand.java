package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.ui.ConfirmationPopup;

/**
 * Clears the address book with a confirmation popup.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "All student data has been cleared.";
    public static final String MESSAGE_CANCELLED = "Clear operation was cancelled.";

    public static final String SHOWING_CONFIRMATION_MESSAGE = "Opened confirmation window.";

    private boolean isConfirmed = false;

    @Override
    public CommandResult execute(Model model) throws CommandException {
        ConfirmationPopup confirmationPopup = new ConfirmationPopup();
        confirmationPopup.setConfirmationCallback(confirmed -> {
            if (confirmed) {
                this.isConfirmed = true;
                model.setAddressBook(new AddressBook());
            }
        });
        confirmationPopup.show();

        if (isConfirmed) {
            return new CommandResult(SHOWING_CONFIRMATION_MESSAGE, false, false, true);
        } else {
            return new CommandResult(SHOWING_CONFIRMATION_MESSAGE, false, false, false);
        }
    }
}
