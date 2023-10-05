package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;

    private final Email email;

    // Data fields

    private final Major major;
    private final Year year;
    private final Description description;
    private final SocialMediaLink socialMedia;

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Major major, Year year, Email email, Description description, SocialMediaLink socialMedia) {
        requireAllNonNull(name, major, year, email, description, socialMedia);
        this.name = name;
        this.major = major;
        this.year = year;
        this.email = email;
        this.description = description;
        this.socialMedia = socialMedia;
    }

    public Name getName() {
        return name;
    }

    public Major getMajor() {
        return major;
    }

    public Year getYear() {
        return year;
    }

    public Email getEmail() {
        return email;
    }

    public Description getDescription() {
        return description;
    }

    public SocialMediaLink getSocialMedia() {
        return socialMedia;
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return name.equals(otherPerson.name)
                && major.equals(otherPerson.major)
                && year.equals(otherPerson.year)
                && email.equals(otherPerson.email)
                && description.equals(otherPerson.description)
                && socialMedia.equals(otherPerson.socialMedia);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, major, year, email, description, socialMedia);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("major", major)
                .add("year", year)
                .add("email", email)
                .add("description", description)
                .add("socialMedia", socialMedia)
                .toString();
    }
}
