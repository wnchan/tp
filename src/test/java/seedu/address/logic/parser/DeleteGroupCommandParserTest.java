package seedu.address.logic.parser;


import static seedu.address.logic.parser.CliSyntax.PREFIX_GROUP;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.DeleteGroupCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class DeleteGroupCommandParserTest {

    private DeleteGroupCommandParser parser = new DeleteGroupCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteGroupCommand() {
        // Test valid input
        String userInput = " " + PREFIX_GROUP + "1";
        DeleteGroupCommand expectedCommand = new DeleteGroupCommand(1);
        CommandParserTestUtil.assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_missingGroupPrefix_throwsParseException() {
        // Test input without group prefix
        String userInput = "1";
        String expectedMessage = String.format("Invalid command format! \n" + DeleteGroupCommand.MESSAGE_USAGE);
        CommandParserTestUtil.assertParseFailure(parser, userInput, expectedMessage);
    }

    @Test
    public void parse_invalidGroupNumber_throwsParseException() {
        // Test invalid group number
        String userInput = " " + PREFIX_GROUP + "abc";
        assertThrows(ParseException.class, () -> parser.parse(userInput));
    }

}
