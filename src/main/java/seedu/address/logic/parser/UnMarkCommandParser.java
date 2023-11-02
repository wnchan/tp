package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;
import seedu.address.logic.commands.UnMarkCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.group.GroupContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new UnMarkCommand object
 */
public class UnMarkCommandParser implements Parser<UnMarkCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the UnMarkCommand
     * and returns a UnMarkCommand object for execution.
     * @throws ParseException if the user input does not conform to the expected format
     */
    public UnMarkCommand parse(String args) throws ParseException {
        requireNonNull(args);
        try {
            String[] argParts = args.trim().split("gr/|ti/");
            if (argParts.length != 3) {
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, UnMarkCommand.MESSAGE_USAGE));
            }
            int groupNumber = ParserUtil.parseGroupNumber(argParts[1]);
            int taskIndex = ParserUtil.parseTaskIndex(argParts[2]) - 1;
            return new UnMarkCommand(groupNumber, taskIndex, new GroupContainsKeywordsPredicate(Arrays.asList(
                String.valueOf(groupNumber))));
        } catch (NumberFormatException nfe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, UnMarkCommand.MESSAGE_USAGE), nfe);
        }
    }
}
