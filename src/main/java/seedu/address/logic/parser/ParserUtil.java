package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Description;
import seedu.address.model.person.Email;
import seedu.address.model.person.Major;
import seedu.address.model.person.Name;
import seedu.address.model.person.Tutorial;
import seedu.address.model.person.Year;
import seedu.address.model.socialmedialink.SocialMediaLink;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String major} into a {@code Major}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code major} is invalid.
     */
    public static Major parseMajor(String major) throws ParseException {
        requireNonNull(major);
        String trimmedMajor = major.trim();
        if (!Major.isValidMajor(trimmedMajor)) {
            throw new ParseException(Major.MESSAGE_CONSTRAINTS);
        }
        return new Major(trimmedMajor);
    }

    /**
     * Parses a {@code String year} into a {@code Year}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code year} is invalid.
     */
    public static Year parseYear(String year) throws ParseException {
        requireNonNull(year);
        String trimmedYear = year.trim();
        if (!Year.isValidYear(trimmedYear)) {
            throw new ParseException(Year.MESSAGE_CONSTRAINTS);
        }
        return new Year(trimmedYear);
    }

    /**
     * Parses a {@code String description} into a {@code Description}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code description} is invalid.
     */
    public static Description parseDescription(String description) throws ParseException {
        requireNonNull(description);
        String trimmedDescription = description.trim();
        if (!Description.isValidDescription(trimmedDescription)) {
            throw new ParseException(Description.MESSAGE_CONSTRAINTS);
        }
        return new Description(trimmedDescription);
    }

    /**
     * Parses {@code Collection<String> tutorials} into a {@code Set<Tutorial>}.
     * @throws ParseException if any of the given {@code tutorials} is invalid.
     */
    public static Set<Tutorial> parseTutorials(Collection<String> tutorials) throws ParseException {
        requireNonNull(tutorials);
        Set<Tutorial> tutorialSet = new HashSet<>();
        for (String tutorialString : tutorials) {
            String[] tutorialTokens = tutorialString.split(" ");
            for (String token : tutorialTokens) {
                if (!Tutorial.isValidTutorial(token)) {
                    throw new ParseException(Tutorial.MESSAGE_CONSTRAINTS);
                }
                tutorialSet.add(new Tutorial(token));
            }
        }
        return tutorialSet;
    }

    /**
     * Parses a {@code String socialMediaLink} into a {@code SocialMediaLink}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code socialMediaLink} is invalid.
     */
    public static SocialMediaLink parseSocialMediaLink(String socialMediaLink) throws ParseException {
        requireNonNull(socialMediaLink);
        String trimmedSocialMediaLink = socialMediaLink.trim();
        if (!SocialMediaLink.isValidSocialMediaLink(trimmedSocialMediaLink)) {
            throw new ParseException(SocialMediaLink.MESSAGE_CONSTRAINTS);
        }
        return new SocialMediaLink(trimmedSocialMediaLink);
    }

    /**
     * Parses {@code Collection<String> socialMediaLinks} into a {@code Set<SocialMediaLink>}.
     */
    public static Set<SocialMediaLink> parseSocialMediaLinks(Collection<String> socialMediaLinks)
            throws ParseException {
        requireNonNull(socialMediaLinks);
        final Set<SocialMediaLink> socialMediaLinkSet = new HashSet<>();
        for (String socialMedia : socialMediaLinks) {
            socialMediaLinkSet.add(parseSocialMediaLink(socialMedia));
        }
        return socialMediaLinkSet;
    }
}
