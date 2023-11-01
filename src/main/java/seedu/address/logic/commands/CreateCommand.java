package seedu.address.logic.commands;

import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL;

import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.ObservableList;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.group.Group;
import seedu.address.model.group.exceptions.TaskException;
import seedu.address.model.group.tasks.TaskInitializer;
import seedu.address.model.group.tasks.TaskList;
import seedu.address.model.tutorial.Tutorial;

/**
 * Creates a new empty group.
 */
public class CreateCommand extends Command {

    public static final String COMMAND_WORD = "create";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Creates a new empty group.\n"
            + "Parameters: "
            + PREFIX_TUTORIAL + "TUTORIAL "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_TUTORIAL + "02";

    public static final String MESSAGE_SUCCESS = "Group created successfully! Group number is %1$s";

    private final Tutorial tutorial;

    public CreateCommand(Tutorial tutorial) {
        this.tutorial = tutorial;
    }

    @Override
    public CommandResult execute(Model model) {
        int number = generateGroupNumber(model);
        Group createdGroup = new Group(number, tutorial);
        // Initialize the tasks and add them to the group
        TaskList initialTasks = null;
        try {
            initialTasks = TaskInitializer.initializeTasks();
        } catch (TaskException e) {
            throw new RuntimeException(e);
        }
        createdGroup.addTasks(initialTasks);

        model.addGroup(createdGroup);

        return new CommandResult(String.format(MESSAGE_SUCCESS, createdGroup.getNumber()),
                false, false, true, false);
    }

    /**
     * Generates the next group number to be used when creating a new group.
     *
     * @param model
     * @return
     */
    private int generateGroupNumber(Model model) {
        int number;
        ReadOnlyAddressBook addressBook = model.getAddressBook();
        ObservableList<Group> groups = addressBook.getGroupList();

        if (groups.isEmpty()) {
            number = 1;
        } else {
            number = 2;
            List<Integer> groupNumbers = groups.stream()
                .map(Group::getNumber).collect(Collectors.toList());
            while (groupNumbers.contains(number)) {
                number++;
            }
        }

        return number;
    }
}
