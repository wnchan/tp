package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;
import seedu.address.logic.commands.TasksCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.group.GroupContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new TasksCommand object
 */
public class TasksCommandParser implements Parser<TasksCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the TasksCommand
     * and returns a TasksCommand object for execution.
     * @throws ParseException if the user input does not conform to the expected format
     */
    public TasksCommand parse(String args) throws ParseException {
        requireNonNull(args);
        try {
            int groupNumber = ParserUtil.parseGroupNumber(args.trim());
            return new TasksCommand(groupNumber, new GroupContainsKeywordsPredicate(Arrays.asList(
                String.valueOf(groupNumber))));
        } catch (NumberFormatException nfe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, TasksCommand.MESSAGE_USAGE), nfe);
        }
    }
}
