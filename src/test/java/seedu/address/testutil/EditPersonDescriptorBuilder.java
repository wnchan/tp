package seedu.address.testutil;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.person.Description;
import seedu.address.model.person.Email;
import seedu.address.model.person.Major;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Tutorial;
import seedu.address.model.person.Year;
import seedu.address.model.socialmedialink.SocialMediaLink;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditPersonDescriptorBuilder {

    private EditPersonDescriptor descriptor;

    public EditPersonDescriptorBuilder() {
        descriptor = new EditPersonDescriptor();
    }

    public EditPersonDescriptorBuilder(EditPersonDescriptor descriptor) {
        this.descriptor = new EditPersonDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public EditPersonDescriptorBuilder(Person person) {
        descriptor = new EditPersonDescriptor();
        descriptor.setName(person.getName());
        descriptor.setMajor(person.getMajor());
        descriptor.setYear(person.getYear());
        descriptor.setEmail(person.getEmail());
        descriptor.setDescription(person.getDescription());
        descriptor.setSocialMediaLinks(person.getSocialMediaLinks());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Major} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withMajor(String major) {
        descriptor.setMajor(new Major(major));
        return this;
    }

    /**
     * Sets the {@code Year} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withYear(String year) {
        descriptor.setYear(new Year(year));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Description} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withDescription(String description) {
        descriptor.setDescription(new Description(description));
        return this;
    }

    /**
     * Parses the {@code socialMediaLinks} into a {@code Set<SocialMediaLink>} and set it to the
     * {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withSocialMediaLinks(String... socialMediaLinks) {
        Set<SocialMediaLink> tagSet = Stream.of(socialMediaLinks).map(SocialMediaLink::new).collect(Collectors.toSet());
        descriptor.setSocialMediaLinks(tagSet);
        return this;
    }

    /**
     * Parses the {@code tutorials} into a {@code Set<Tutorial>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withTutorials(List<Tutorial> tutorials) {
        List<Tutorial> tutorialSet = tutorials.stream()
            .map((Tutorial tutorial) -> new Tutorial(tutorial.getValue()))
            .collect(Collectors.toList());
        descriptor.setTutorials(tutorialSet);
        return this;
    }

    public EditPersonDescriptor build() {
        return descriptor;
    }
}
