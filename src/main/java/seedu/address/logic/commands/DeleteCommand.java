package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Optional;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Email;
import seedu.address.model.person.Person;

/**
 * Deletes a person identified using it's displayed index from the address book.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the person identified by the email address.\n"
            + "Parameters: EMAIL\n"
            + "Example: " + COMMAND_WORD + " alexyeoh@u.nus.edu";

    public static final String MESSAGE_DELETE_PERSON_SUCCESS = "Person deleted Successfully! Deleted Person: %1$s";
    private final Email targetEmail;

    public DeleteCommand(Email targetEmail) {
        this.targetEmail = targetEmail;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // Find the person with the provided email
        Optional<Person> personToDelete = model.getPersonWithEmail(targetEmail);

        if (personToDelete.isEmpty()) {
            throw new CommandException("Person with the provided email not found.");
        }

        // Delete the person from the model
        model.deletePerson(personToDelete.get());

        return new CommandResult(String.format(MESSAGE_DELETE_PERSON_SUCCESS, personToDelete.get()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof DeleteCommand)) {
            return false;
        }

        DeleteCommand otherDeleteCommand = (DeleteCommand) other;
        return targetEmail.equals(otherDeleteCommand.targetEmail);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetEmail", targetEmail)
                .toString();
    }
}
