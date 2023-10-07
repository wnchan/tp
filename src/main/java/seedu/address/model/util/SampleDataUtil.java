package seedu.address.model.util;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Description;
import seedu.address.model.person.Email;
import seedu.address.model.person.Major;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.SocialMediaLink;
import seedu.address.model.person.Year;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {

    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Major("Computer Science"), new Year("2"),
                    new Email("alexyeoh@u.nus.edu"), new Description("Friendly person"),
                    new SocialMediaLink("https://example.com/alex")),
            new Person(new Name("Bernice Yu"), new Major("Computer Science"), new Year("2"),
                    new Email("berniceyu@u.nus.edu"), new Description("Colleague from work"),
                    new SocialMediaLink("https://example.com/bernice")),
            new Person(new Name("Charlotte Oliveiro"), new Major("Computer Science"), new Year("2"),
                    new Email("charlotte@u.nus.edu"), new Description("Neighbor"),
                    new SocialMediaLink("https://example.com/charlotte")),
            new Person(new Name("David Li"), new Major("Computer Science"), new Year("2"),
                    new Email("lidavid@u.nus.edu"), new Description("Family member"),
                    new SocialMediaLink("https://example.com/david")),
            new Person(new Name("Irfan Ibrahim"), new Major("Computer Science"), new Year("2"),
                    new Email("irfan@u.nus.edu"), new Description("Classmate"),
                    new SocialMediaLink("https://example.com/irfan")),
            new Person(new Name("Roy Balakrishnan"), new Major("Computer Science"), new Year("2"),
                    new Email("royb@u.nus.edu"), new Description("Colleague from work"),
                    new SocialMediaLink("https://example.com/roy"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }
}

