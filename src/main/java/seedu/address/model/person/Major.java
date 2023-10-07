package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Student's major in StudentConnect.
 * Guarantees: immutable;
 */
public class Major {

    public final String value;

    /**
     * Constructs a {@code Major} with the specified major value.
     *
     * @param major The major value. Must not be null.
     */
    public Major(String major) {
        requireNonNull(major);
        value = major;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Major // instanceof handles nulls
                && value.equals(((Major) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

