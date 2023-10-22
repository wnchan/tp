package seedu.address.model.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Description;
import seedu.address.model.person.Email;
import seedu.address.model.person.Major;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Tutorial;
import seedu.address.model.person.Year;
import seedu.address.model.socialmedialink.SocialMediaLink;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {

    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Major("Computer Science"), new Year("2"),
                    new Email("alexyeoh@u.nus.edu"), new Description("Friendly person"),
                    getTutorialList("01", "20"),
                    getSocialMediaLinkSet("https://example.com/alex")),
            new Person(new Name("Bernice Yu"), new Major("Computer Science"), new Year("2"),
                    new Email("berniceyu@u.nus.edu"), new Description("Colleague from work"),
                    getTutorialList("08", "19"),
                    getSocialMediaLinkSet("https://example.com/bernice")),
            new Person(new Name("Charlotte Oliveiro"), new Major("Computer Science"), new Year("2"),
                    new Email("charlotte@u.nus.edu"), new Description("Neighbour"),
                    getTutorialList("05", "06", "10"),
                    getSocialMediaLinkSet("https://example.com/charlotte")),
            new Person(new Name("David Li"), new Major("Computer Science"), new Year("2"),
                    new Email("lidavid@u.nus.edu"), new Description("Family member"),
                    getTutorialList("11"),
                    getSocialMediaLinkSet("https://example.com/david")),
            new Person(new Name("Irfan Ibrahim"), new Major("Computer Science"), new Year("2"),
                    new Email("irfan@u.nus.edu"), new Description("Classmate"),
                    getTutorialList("07", "18"),
                    getSocialMediaLinkSet("https://example.com/irfan")),
            new Person(new Name("Roy Balakrishnan"), new Major("Computer Science"), new Year("2"),
                    new Email("royb@u.nus.edu"), new Description("Colleague from work"),
                    getTutorialList("11", "19", "22"),
                    getSocialMediaLinkSet("https://example.com/roy"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    public static List<Tutorial> getTutorialList(String... tutorials) {
        return Arrays.stream(tutorials)
            .map(Tutorial::new)
            .collect(Collectors.toList());
    }

    public static Set<SocialMediaLink> getSocialMediaLinkSet(String... strings) {
        return Arrays.stream(strings)
                .map(SocialMediaLink::new)
                .collect(Collectors.toSet());
    }
}
