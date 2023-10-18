package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label major;
    @FXML
    private Label year;
    @FXML
    private Label email;
    @FXML
    private Label description;
    @FXML
    private FlowPane socialMediaLinks;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        id.setText(displayedIndex + ". ");
        id.setStyle("-fx-font-size: 17px; -fx-text-fill: #FFDB58; -fx-font-family: 'Arial';"); // styling like name
        name.setText(person.getName().fullName);
        major.setText(person.getMajor().value);
        year.setText(person.getYear().value);
        email.setText(person.getEmail().value);
        description.setText(person.getDescription().value);

        person.getSocialMediaLinks().stream()
                .sorted(Comparator.comparing(sm -> sm.socialMediaLink))
                .forEach(sm -> {
                    Label label = new Label(sm.socialMediaLink);
                    label.setStyle("-fx-font-size: 13px; -fx-text-fill: white; -fx-font-family: 'Segoe UI Semibold';");
                    socialMediaLinks.getChildren().add(label);
                });
    }
}



