package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Student's description in StudentConnect.
 * Guarantees: immutable;
 */
public class Description {

    public static final String MESSAGE_CONSTRAINTS = "Descriptions should not be left blank or" 
            + " exceed 150 characters.";

    public final String value;


    /**
     * Constructs a {@code Description} with the specified description value.
     *
     * @param description The description value. Must not be null.
     */
    public Description(String description) {
        requireNonNull(description);
        checkArgument(isValidDescription(description), MESSAGE_CONSTRAINTS);
        value = description;
    }

    /**
     * Returns if a given string is a valid description.
     */
    public static boolean isValidDescription(String value) {
        return value != null && !value.isBlank() && value.length() <= 150;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Description // instanceof handles nulls
                && value.equals(((Description) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

