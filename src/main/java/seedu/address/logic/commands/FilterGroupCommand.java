package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.group.GroupBelongsTutorialPredicate;

/**
 * Filters all groups in StudentConnect that belong to the filtered tutorial slot.
 */
public class FilterGroupCommand extends Command {

    public static final String COMMAND_WORD = "filterGroup";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Filters all groups that belong to the specified "
            + "tutorial slot (2-digit numbers between 01 and 22) and displays them as a list with index numbers."
            + "\nParameters: SLOT\n"
            + "Example: " + COMMAND_WORD + " 01";

    private final GroupBelongsTutorialPredicate predicate;

    public FilterGroupCommand(GroupBelongsTutorialPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredGroupList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_GROUPS_LISTED_OVERVIEW, model.getFilteredGroupList().size()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FilterGroupCommand)) {
            return false;
        }

        FilterGroupCommand otherFilterGroupCommand = (FilterGroupCommand) other;
        return predicate.equals(otherFilterGroupCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", predicate)
                .toString();
    }
}
