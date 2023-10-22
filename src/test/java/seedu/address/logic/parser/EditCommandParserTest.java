package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.DESCRIPTION_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.DESCRIPTION_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_DESCRIPTION_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_EMAIL_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_MAJOR_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_SM_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_YEAR_DESC;
import static seedu.address.logic.commands.CommandTestUtil.MAJOR_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.MAJOR_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.SM_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.SM_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MAJOR_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SM_GITHUB_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SM_LINKEDIN_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_YEAR_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_YEAR_BOB;
import static seedu.address.logic.commands.CommandTestUtil.YEAR_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.YEAR_DESC_BOB;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MAJOR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SOCIAL_MEDIA_LINK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_YEAR;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalEmails.EMAIL_FIRST_PERSON;
import static seedu.address.testutil.TypicalEmails.EMAIL_SECOND_PERSON;
import static seedu.address.testutil.TypicalEmails.EMAIL_THIRD_PERSON;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.person.Description;
import seedu.address.model.person.Email;
import seedu.address.model.person.Major;
import seedu.address.model.person.Name;
import seedu.address.model.person.Tutorial;
import seedu.address.model.person.Year;
import seedu.address.model.socialmedialink.SocialMediaLink;
import seedu.address.testutil.EditPersonDescriptorBuilder;

public class EditCommandParserTest {

    private static final String SOCIAL_MEDIA_LINK_EMPTY = " " + PREFIX_SOCIAL_MEDIA_LINK;

    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE);

    private EditCommandParser parser = new EditCommandParser();

    @Test
    public void parse_missingParts_failure() {
        // no email specified
        assertParseFailure(parser, VALID_NAME_AMY, MESSAGE_INVALID_FORMAT);

        // no field specified
        assertParseFailure(parser, VALID_EMAIL_AMY, EditCommand.MESSAGE_NOT_EDITED);

        // no email and no field specified
        assertParseFailure(parser, "", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidPreamble_failure() {
        // invalid arguments being parsed as preamble
        assertParseFailure(parser, "some random string", MESSAGE_INVALID_FORMAT);

        // invalid prefix being parsed as preamble
        assertParseFailure(parser, VALID_EMAIL_AMY + " i/ string", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidValue_failure() {
        assertParseFailure(parser, VALID_EMAIL_AMY + INVALID_NAME_DESC,
                Name.MESSAGE_CONSTRAINTS); // invalid name
        assertParseFailure(parser, VALID_EMAIL_AMY + INVALID_MAJOR_DESC,
                Major.MESSAGE_CONSTRAINTS); // invalid major
        assertParseFailure(parser, VALID_EMAIL_AMY + INVALID_YEAR_DESC,
                Year.MESSAGE_CONSTRAINTS); // invalid year
        assertParseFailure(parser, VALID_EMAIL_AMY + INVALID_EMAIL_DESC,
                Email.MESSAGE_CONSTRAINTS); // invalid email
        assertParseFailure(parser, VALID_EMAIL_AMY + INVALID_DESCRIPTION_DESC,
                Description.MESSAGE_CONSTRAINTS); // invalid description
        assertParseFailure(parser, VALID_EMAIL_AMY + INVALID_SM_DESC,
                SocialMediaLink.MESSAGE_CONSTRAINTS); // invalid social media link

        // invalid year followed by valid email
        assertParseFailure(parser, VALID_EMAIL_AMY + INVALID_YEAR_DESC + EMAIL_DESC_AMY,
                Year.MESSAGE_CONSTRAINTS);

        // while parsing {@code PREFIX_SOCIAL_MEDIA_LINK} alone will reset the tags of the {@code Person} being edited,
        // parsing it together with a valid social media link results in error
        assertParseFailure(parser, VALID_EMAIL_AMY + SM_DESC_AMY + SOCIAL_MEDIA_LINK_EMPTY,
                SocialMediaLink.MESSAGE_CONSTRAINTS);
        assertParseFailure(parser, VALID_EMAIL_AMY + SOCIAL_MEDIA_LINK_EMPTY + SM_DESC_AMY,
                SocialMediaLink.MESSAGE_CONSTRAINTS);

        // multiple invalid values, but only the first invalid value is captured
        assertParseFailure(parser, VALID_EMAIL_AMY + INVALID_NAME_DESC + INVALID_EMAIL_DESC + VALID_MAJOR_AMY
                        + VALID_YEAR_AMY,
                Name.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_allFieldsSpecified_success() {
        String userInput = EMAIL_SECOND_PERSON + YEAR_DESC_BOB + SM_DESC_AMY
                + EMAIL_DESC_AMY + DESCRIPTION_DESC_AMY + NAME_DESC_AMY + MAJOR_DESC_AMY;

        EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withName(VALID_NAME_AMY)
                .withMajor(VALID_MAJOR_AMY).withYear(VALID_YEAR_BOB).withEmail(VALID_EMAIL_AMY)
                .withDescription(VALID_DESCRIPTION_AMY)
                .withSocialMediaLinks(VALID_SM_GITHUB_AMY, VALID_SM_LINKEDIN_AMY).build();
        EditCommand expectedCommand = new EditCommand(EMAIL_SECOND_PERSON, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_someFieldsSpecified_success() {
        String userInput = EMAIL_FIRST_PERSON + YEAR_DESC_BOB + EMAIL_DESC_AMY;

        EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withYear(VALID_YEAR_BOB)
                .withEmail(VALID_EMAIL_AMY).build();
        EditCommand expectedCommand = new EditCommand(EMAIL_FIRST_PERSON, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_oneFieldSpecified_success() {
        // name
        String userInput = EMAIL_THIRD_PERSON + NAME_DESC_AMY;
        EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withName(VALID_NAME_AMY).build();
        EditCommand expectedCommand = new EditCommand(EMAIL_THIRD_PERSON, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // major
        userInput = EMAIL_THIRD_PERSON + MAJOR_DESC_AMY;
        descriptor = new EditPersonDescriptorBuilder().withMajor(VALID_MAJOR_AMY).build();
        expectedCommand = new EditCommand(EMAIL_THIRD_PERSON, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // year
        userInput = EMAIL_THIRD_PERSON + YEAR_DESC_AMY;
        descriptor = new EditPersonDescriptorBuilder().withYear(VALID_YEAR_AMY).build();
        expectedCommand = new EditCommand(EMAIL_THIRD_PERSON, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // email
        userInput = EMAIL_THIRD_PERSON + EMAIL_DESC_AMY;
        descriptor = new EditPersonDescriptorBuilder().withEmail(VALID_EMAIL_AMY).build();
        expectedCommand = new EditCommand(EMAIL_THIRD_PERSON, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // description
        userInput = EMAIL_THIRD_PERSON + DESCRIPTION_DESC_AMY;
        descriptor = new EditPersonDescriptorBuilder().withDescription(VALID_DESCRIPTION_AMY).build();
        expectedCommand = new EditCommand(EMAIL_THIRD_PERSON, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // social media links
        userInput = EMAIL_THIRD_PERSON + SM_DESC_AMY;
        descriptor = new EditPersonDescriptorBuilder().withSocialMediaLinks(VALID_SM_LINKEDIN_AMY, VALID_SM_GITHUB_AMY)
                .build();
        expectedCommand = new EditCommand(EMAIL_THIRD_PERSON, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_multipleRepeatedFields_failure() {
        // More extensive testing of duplicate parameter detections is done in
        // AddCommandParserTest#parse_repeatedNonTagValue_failure()

        // valid followed by invalid
        String userInput = EMAIL_FIRST_PERSON + INVALID_YEAR_DESC + YEAR_DESC_BOB;

        assertParseFailure(parser, userInput, Messages.getErrorMessageForDuplicatePrefixes(PREFIX_YEAR));

        // invalid followed by valid
        userInput = EMAIL_FIRST_PERSON + YEAR_DESC_BOB + INVALID_YEAR_DESC;

        assertParseFailure(parser, userInput, Messages.getErrorMessageForDuplicatePrefixes(PREFIX_YEAR));

        // multiple valid fields repeated
        userInput = EMAIL_FIRST_PERSON + YEAR_DESC_AMY + DESCRIPTION_DESC_AMY + EMAIL_DESC_AMY + MAJOR_DESC_AMY
                + SM_DESC_AMY + YEAR_DESC_AMY + DESCRIPTION_DESC_AMY + EMAIL_DESC_AMY + SM_DESC_AMY
                + YEAR_DESC_BOB + DESCRIPTION_DESC_BOB + EMAIL_DESC_BOB + SM_DESC_BOB + MAJOR_DESC_BOB;

        assertParseFailure(parser, userInput,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_MAJOR, PREFIX_YEAR, PREFIX_EMAIL,
                        PREFIX_DESCRIPTION));

        // multiple invalid values
        userInput = EMAIL_FIRST_PERSON + INVALID_MAJOR_DESC + INVALID_YEAR_DESC + INVALID_DESCRIPTION_DESC
                + INVALID_EMAIL_DESC + INVALID_MAJOR_DESC + INVALID_YEAR_DESC + INVALID_DESCRIPTION_DESC
                + INVALID_EMAIL_DESC;

        assertParseFailure(parser, userInput,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_MAJOR, PREFIX_YEAR, PREFIX_EMAIL,
                        PREFIX_DESCRIPTION));
    }

    @Test
    public void parse_resetSocialMediaLinks_success() {
        String userInput = EMAIL_THIRD_PERSON + SOCIAL_MEDIA_LINK_EMPTY;

        EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withSocialMediaLinks().build();
        EditCommand expectedCommand = new EditCommand(EMAIL_THIRD_PERSON, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parseTutorials_validInput_success() throws Exception {
        String userInput = " " + PREFIX_TUTORIAL + "01 02 03";
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(userInput, PREFIX_TUTORIAL);

        EditPersonDescriptorBuilder descriptorBuilder = new EditPersonDescriptorBuilder();
        List<String> tutorialsStrings = argMultimap.getAllValues(PREFIX_TUTORIAL);

        if (!tutorialsStrings.isEmpty()) {
            Set<Tutorial> tutorialSet = ParserUtil.parseTutorials(tutorialsStrings);
            descriptorBuilder.withTutorials(tutorialSet);
        }

        EditPersonDescriptor expectedDescriptor = new EditPersonDescriptorBuilder()
            .withTutorials(new HashSet<>(List.of(new Tutorial("01"), new Tutorial("02"), new Tutorial("03"))))
            .build();

        assertEquals(expectedDescriptor, descriptorBuilder.build());
    }

}
