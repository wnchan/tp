package seedu.address.ui;

import java.util.Comparator;
import java.util.stream.Collectors;

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
    private Label tutorials;
    @FXML
    private FlowPane socialMediaLinks;
    @FXML
    private Label nationality;

    @FXML
    private HBox nationalityBox;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        id.setText(displayedIndex + ". ");
        id.setStyle("-fx-font-size: 17px; -fx-text-fill: #E7BE34; -fx-font-family: 'Arial';");
        name.setText(person.getName().fullName);
        nationality.setText(person.getNationality().value);
        if (person.getNationality().value.equals("local")) {
            nationalityBox.setStyle("-fx-background-color: rgba(77,152,60,0.82); -fx-background-radius: 10;");
        } else {
            nationalityBox.setStyle("-fx-background-color: rgba(17,63,3,0.68); -fx-background-radius: 10;");
        }
        major.setText(person.getMajor().value);
        year.setText("Y" + person.getYear().value);
        email.setText(person.getEmail().value);
        description.setText(person.getDescription().value);
        String tutorialsText = person.getTutorials().stream()
            .map(t -> "T" + t.getValue())
            .sorted()
            .collect(Collectors.joining(", "));
        tutorials.setText(tutorialsText);
        person.getSocialMediaLinks().stream()
            .sorted(Comparator.comparing(sm -> sm.socialMediaLink))
            .forEach(sm -> {
                Label label = new Label(sm.socialMediaLink);
                label.setStyle("-fx-font-size: 13px; -fx-text-fill: white; -fx-font-family: 'Segoe UI Semibold';");
                socialMediaLinks.getChildren().add(label);
            });
    }
}
