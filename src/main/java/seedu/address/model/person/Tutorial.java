package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Student's tutorial in StudentConnect.
 * Guarantees: immutable;
 */
public class Tutorial {

    public static final String MESSAGE_CONSTRAINTS = "Tutorials should be integers between 01 and 22, "
                                                        + "separated by a comma.";

    public final String value;

    /**
     * Constructs a {@code Tutorial} with the specified tutorial value.
     *
     * @param tutorial The tutorial value. Must not be null.
     */
    public Tutorial(String tutorial) {
        requireNonNull(tutorial);
        checkArgument(isValidTutorial(tutorial), MESSAGE_CONSTRAINTS);
        value = formatTutorial(tutorial);
    }

    /**
     * Formats the tutorial to have leading zeros for numbers between 1 and 9 for consistency.
     */
    private String formatTutorial(String tutorial) {
        int tutorialNumber = Integer.parseInt(tutorial);
        return String.format("%02d", tutorialNumber);
    }

    /**
     * Returns if a given string is a valid tutorial number between 01 and 22.
     */
    public static boolean isValidTutorial(String tutorial) {
        try {
            int tutorialNumber = Integer.parseInt(tutorial);
            return tutorialNumber >= 1 && tutorialNumber <= 22;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "T" + formatTutorial(value);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof Tutorial // instanceof handles nulls
            && value.equals(((Tutorial) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
