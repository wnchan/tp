package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's social media link in StudentConnect.
 * Guarantees: immutable; is valid as declared in {@link #isValidSocialMediaLink(String)}
 */
public class SocialMediaLink {
    private static final String SPECIAL_CHARACTERS = "+_.-:/";
    public static final String MESSAGE_CONSTRAINTS = "Social media links should adhere to the following constraints:\n"
            + "1. It should only contain alphanumeric characters and these special characters: "
            + SPECIAL_CHARACTERS + ".\n"
            + "2. It may not start or end with any special characters.\n"
            + "3. It should be a valid URL or handle for a social media platform.";
    // alphanumeric and special characters
    private static final String ALPHANUMERIC = "[a-zA-Z0-9-:/" + SPECIAL_CHARACTERS + "]+";
    public static final String VALIDATION_REGEX = "^" + ALPHANUMERIC + "$";

    public final String value;

    /**
     * Constructs a {@code SocialMediaLink}.
     *
     * @param socialMediaLink A valid social media link.
     */
    public SocialMediaLink(String socialMediaLink) {
        requireNonNull(socialMediaLink);
        checkArgument(isValidSocialMediaLink(socialMediaLink), MESSAGE_CONSTRAINTS);
        value = socialMediaLink;
    }

    /**
     * Returns if a given string is a valid social media link.
     */
    public static boolean isValidSocialMediaLink(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SocialMediaLink)) {
            return false;
        }

        SocialMediaLink otherLink = (SocialMediaLink) other;
        return value.equals(otherLink.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}

