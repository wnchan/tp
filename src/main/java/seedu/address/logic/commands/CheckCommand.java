package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.group.Group;
import seedu.address.model.person.Person;
import seedu.address.model.tutorial.Tutorial;

/**
 * Checks a group requirement by its group number.
 */
public class CheckCommand extends Command {

    public static final String COMMAND_WORD = "checkGroup";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Checks the group identified by its group number.\n"
            + "Parameters: GROUP_NUMBER\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_CHECK_GROUP_SUCCESS =
            "Group fulfils the nationality requirement of CS2103T. Group %1$s";
    public static final String MESSAGE_CHECK_GROUP_NATIONALITY_WARNING =
            "Group does not fulfil the nationality requirement of CS2103T. Group %1$s";
    public static final String MESSAGE_CHECK_GROUP_GENDER_WARNING =
            "Group does not fulfil the gender requirement of CS2103T. Group %1$s";
    public static final String MESSAGE_CHECK_GROUP_TUTORIAL_WARNING =
            "Not every group member's tutorial matches the group's tutorial. Group %1$s";
    public static final String MESSAGE_CHECK_GROUP_NOT_FOUND = "Group with the provided group number not found.";

    private final int groupNumber;

    public CheckCommand(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        // Check if the group with the provided group number exists
        Group groupToCheck = model.getGroupWithNumber(groupNumber)
                .orElseThrow(() -> new CommandException(MESSAGE_CHECK_GROUP_NOT_FOUND));

        Set<Person> groupMembers = groupToCheck.getMembers();

        // check nationality requirement
        int localCount = 0;
        int foreignerCount = 0;
        for (Person member : groupMembers) {
            if (member.getNationality().value.equals("local")) {
                localCount++;
            } else {
                foreignerCount++;
            }
        }

        // check gender requirement
        int maleCount = 0;
        int femaleCount = 0;
        for (Person member : groupMembers) {
            if (member.getGender().value.equals("M")) {
                maleCount++;
            } else {
                femaleCount++;
            }
        }

        // check group members' tutorial
        String groupTutorial = groupToCheck.getTutorial().value;
        int count = 0;
        for (Person member : groupMembers) {
            for (Tutorial tut : member.getTutorials()) {
                if (tut.value.equals((groupTutorial))) {
                    count++;
                    continue;
                }
            }
        }

        if (localCount == 0 || foreignerCount == 0) {
            return new CommandResult(
                    String.format(MESSAGE_CHECK_GROUP_NATIONALITY_WARNING, Messages.format(groupToCheck)));
        }
        if (maleCount == 0 || femaleCount == 0) {
            return new CommandResult(String.format(MESSAGE_CHECK_GROUP_GENDER_WARNING, Messages.format(groupToCheck)));
        }
        if (count != groupMembers.size()) {
            return new CommandResult(
                    String.format(MESSAGE_CHECK_GROUP_TUTORIAL_WARNING, Messages.format(groupToCheck)));
        }
        return new CommandResult(String.format(MESSAGE_CHECK_GROUP_SUCCESS, Messages.format(groupToCheck)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CheckCommand)) {
            return false;
        }

        CheckCommand otherCheckCommand = (CheckCommand) other;
        return groupNumber == otherCheckCommand.groupNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("groupNumber", groupNumber)
                .toString();
    }
}
