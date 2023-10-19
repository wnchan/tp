package seedu.address.commons.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.model.util.SampleDataUtil;

public class SampleDataUtilTest {

    @Test
    public void getSamplePersons_validData_returnsSamplePersonsArray() {
        Person[] samplePersons = SampleDataUtil.getSamplePersons();
        assertEquals(6, samplePersons.length); // Check if the correct number of sample persons is returned
    }

    @Test
    public void getSampleAddressBook_validData_returnsReadOnlyAddressBook() {
        assertEquals(6, SampleDataUtil.getSampleAddressBook().getPersonList().size());
        // Check if the address book contains the correct number of sample persons
    }

    @Test
    public void getTutorialList_validData_returnsListOfTutorials() {
        String[] tutorialStrings = {"01", "02", "03"};
        assertEquals(3, SampleDataUtil.getTutorialList(tutorialStrings).size());
        // Check if the correct number of tutorials is returned
    }

    @Test
    public void getSocialMediaLinkSet_validData_returnsSetOfSocialMediaLinks() {
        String[] socialMediaLinkStrings = {"https://example.com/1", "https://example.com/2"};
        assertEquals(2, SampleDataUtil.getSocialMediaLinkSet(socialMediaLinkStrings).size());
        // Check if the correct number of social media links is returned
    }
}
