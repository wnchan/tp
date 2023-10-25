package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MAJOR_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MAJOR_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NATIONALITY_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NATIONALITY_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SM_GITHUB_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SM_GITHUB_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SM_LINKEDIN_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SM_LINKEDIN_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_YEAR_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_YEAR_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person ALICE = new PersonBuilder().withName("Alice Pauline").withMajor("Computer Science")
            .withYear("2").withEmail("alice@u.nus.edu").withDescription("web dev")
            .withSocialMediaLinks("https://www.linkedin.com/in/alice").withNationality("foreigner").build();
    public static final Person BENSON = new PersonBuilder().withName("Benson Meier").withMajor("Computer Science")
            .withYear("2").withEmail("johnd@u.nus.edu").withDescription("mobile dev")
            .withSocialMediaLinks("https://www.linkedin.com/in/benson", "https://github.com/benson")
            .withNationality("local").build();
    public static final Person CARL = new PersonBuilder().withName("Carl Kurz").withMajor("Computer Science")
            .withYear("2").withEmail("heinz@u.nus.edu").withDescription("fe dev").withNationality("local").build();
    public static final Person DANIEL = new PersonBuilder().withName("Daniel Meier").withMajor("Computer Science")
            .withYear("2").withEmail("cornelia@u.nus.edu").withDescription("be dev")
            .withSocialMediaLinks("https://www.linkedin.com/in/daniel").withNationality("local").build();
    public static final Person ELLE = new PersonBuilder().withName("Elle Meyer").withMajor("Computer Science")
            .withYear("2").withEmail("werner@u.nus.edu").withDescription("fe dev").withNationality("foreigner").build();
    public static final Person FIONA = new PersonBuilder().withName("Fiona Kunz").withMajor("Computer Science")
            .withYear("2").withEmail("lydia@u.nus.edu").withDescription("be dev").withNationality("foreigner").build();
    public static final Person GEORGE = new PersonBuilder().withName("George Best").withMajor("Computer Science")
            .withYear("2").withEmail("anna@u.nus.edu").withDescription("fe dev").withNationality("foreigner").build();

    // Manually added
    public static final Person HOON = new PersonBuilder().withName("Hoon Meier").withMajor("Computer Science")
            .withYear("2").withEmail("stefan@u.nus.edu").withDescription("web dev")
            .withNationality("foreigner").build();
    public static final Person IDA = new PersonBuilder().withName("Ida Mueller").withMajor("Computer Science")
            .withYear("2").withEmail("hans@u.nus.edu").withDescription("mobile dev").withNationality("local").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withName(VALID_NAME_AMY).withMajor(VALID_MAJOR_AMY)
            .withYear(VALID_YEAR_AMY).withEmail(VALID_EMAIL_AMY).withDescription(VALID_DESCRIPTION_AMY)
            .withSocialMediaLinks(VALID_SM_LINKEDIN_AMY, VALID_SM_GITHUB_AMY).withNationality(VALID_NATIONALITY_AMY).build();
    public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB).withMajor(VALID_MAJOR_BOB)
            .withYear(VALID_YEAR_BOB).withEmail(VALID_EMAIL_BOB).withDescription(VALID_DESCRIPTION_BOB)
            .withSocialMediaLinks(VALID_SM_LINKEDIN_BOB, VALID_SM_GITHUB_BOB).withNationality(VALID_NATIONALITY_BOB).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
