package seedu.address.model.group;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Person;

/**
 * Represents a Group in StudentConnect.
 * Guarantees: details are present and not null, number is immutable.
 */
public class Group {

    private final int number;
    private Set<Person> members = new HashSet<>();

    /**
     * Constructs a {@code Group}.
     *
     * @param number A valid group number.
     */
    public Group(int number) {
        this.number = number;
    }

    /**
     * Constructs a {@code Group}.
     *
     * @param number
     * @param members
     */
    public Group(int number, Set<Person> members) {
        this.number = number;
        this.members = members;
    }

    /**
     * Adds a person to the group.
     *
     * @param person
     */
    public void addMember(Person person) {
        this.members.add(person);
    }

    public int getNumber() {
        return this.number;
    }

    public Set<Person> getMembers() {
        return Collections.unmodifiableSet(members);
    }

    /**
     * Returns true if both groups have the same number.
     * This defines a weaker notion of equality between two groups.
     */
    public boolean isSameGroup(Group otherGroup) {
        if (otherGroup == this) {
            return true;
        }

        return otherGroup != null
                && otherGroup.getNumber() == this.number;
    }

    /**
     * Returns true if both groups have the same number and members.
     * This defines a stronger notion of equality between two groups.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Group)) {
            return false;
        }

        Group otherGroup = (Group) other;
        return number == otherGroup.getNumber()
                && members.equals(otherGroup.members);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("group number", number)
                .add("members", members)
                .toString();
    }
}
