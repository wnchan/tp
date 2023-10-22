package seedu.address.testutil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.address.model.person.Description;
import seedu.address.model.person.Email;
import seedu.address.model.person.Major;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Tutorial;
import seedu.address.model.person.Year;
import seedu.address.model.socialmedialink.SocialMediaLink;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_MAJOR = "Computer Science";
    public static final String DEFAULT_YEAR = "2";
    public static final String DEFAULT_EMAIL = "amy@u.nus.edu";
    public static final String DEFAULT_DESCRIPTION = "CS nerd";

    private Name name;
    private Major major;
    private Year year;
    private Email email;
    private Description description;
    private List<Tutorial> tutorials;
    private Set<SocialMediaLink> socialMediaLinks;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        major = new Major(DEFAULT_MAJOR);
        year = new Year(DEFAULT_YEAR);
        email = new Email(DEFAULT_EMAIL);
        description = new Description(DEFAULT_DESCRIPTION);
        tutorials = new ArrayList<>();
        socialMediaLinks = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        major = personToCopy.getMajor();
        year = personToCopy.getYear();
        email = personToCopy.getEmail();
        description = personToCopy.getDescription();
        tutorials = new ArrayList<>(personToCopy.getTutorials());
        socialMediaLinks = new HashSet<>(personToCopy.getSocialMediaLinks());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code socialMediaLinks} into a {@code Set<SocialMediaLink>} and set it to the {@code Person} that
     * we are building.
     */
    public PersonBuilder withSocialMediaLinks(String ... socialMediaLinks) {
        this.socialMediaLinks = SampleDataUtil.getSocialMediaLinkSet(socialMediaLinks);
        return this;
    }

    /**
     * Parses the {@code tutorials} into a {@code List<Tutorial>}
     * and sets it to the {@code Person} that we are building.
     *
     * @param tutorials A varargs of tutorial strings. Tutorial strings should be a 2-digit number between 01 and 22.
     * @return The updated {@code PersonBuilder} with the tutorials set.
     */
    public PersonBuilder withTutorials(String... tutorials) {
        this.tutorials = SampleDataUtil.getTutorialList(tutorials);
        return this;
    }


    /**
     * Sets the {@code Description} of the {@code Person} that we are building.
     */
    public PersonBuilder withDescription(String description) {
        this.description = new Description(description);
        return this;
    }

    /**
     * Sets the {@code Major} of the {@code Person} that we are building.
     */
    public PersonBuilder withMajor(String major) {
        this.major = new Major(major);
        return this;
    }

    /**
     * Sets the {@code Year} of the {@code Person} that we are building.
     */
    public PersonBuilder withYear(String year) {
        this.year = new Year(year);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    public Person build() {
        return new Person(name, major, year, email, description, tutorials, socialMediaLinks);
    }

}
