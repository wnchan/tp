package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.tutorial.Tutorial;

/**
 * Jackson-friendly version of {@link Tutorial}.
 */
public class JsonAdaptedTutorial {

    private final String tutorial;

    /**
     * Constructs a {@code JsonAdaptedTutorial} with the given {@code tutorial}.
     */
    @JsonCreator
    public JsonAdaptedTutorial(String tutorial) {
        this.tutorial = tutorial;
    }

    /**
     * Converts a given {@code Tutorial} into this class for Jackson use.
     */
    public JsonAdaptedTutorial(Tutorial source) {
        tutorial = source.value;
    }

    @JsonValue
    public String getTutorial() {
        return tutorial;
    }

    /**
     * Converts this Jackson-friendly adapted tutorial object into the model's {@code Tutorial} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tutorial.
     */
    public Tutorial toModelType() throws IllegalValueException {
        if (!Tutorial.isValidTutorial(tutorial)) {
            throw new IllegalValueException(Tutorial.MESSAGE_CONSTRAINTS);
        }
        return new Tutorial(tutorial);
    }
}
