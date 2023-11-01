package seedu.address.ui;

import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfirmationPopupTest extends ApplicationTest {
    private ConfirmationPopup confirmationPopup;

    @BeforeEach
    public void setup() {
        confirmationPopup = new ConfirmationPopup();
    }

    @Override
    public void start(Stage stage) {
        stage.setScene(confirmationPopup.getRoot().getScene());
        stage.show();
    }

    @Test
    public void testConfirmationPopup() {
        assertFalse(confirmationPopup.isShowing());

        // Show the confirmation popup
        confirmationPopup.show();
        assertTrue(confirmationPopup.isShowing());

        // Close the confirmation popup
        clickOn("#cancelButton");
        assertFalse(confirmationPopup.isShowing());

        // Show the confirmation popup again
        confirmationPopup.show();
        assertTrue(confirmationPopup.isShowing());

        // Confirm the action
        clickOn("#yesButton");
        assertFalse(confirmationPopup.isShowing());
    }
    @Test
    public void testConfirmationPopupShowing() {
        assertFalse(confirmationPopup.isShowing());

        // Show the confirmation popup
        confirmationPopup.show();
        assertTrue(confirmationPopup.isShowing());
    }

    @Test
    public void testConfirmationPopupClose() {
        // Show the confirmation popup
        confirmationPopup.show();
        assertTrue(confirmationPopup.isShowing());

        // Close the confirmation popup
        clickOn("#cancelButton");
        assertFalse(confirmationPopup.isShowing());
    }

    @Test
    public void testConfirmationCallback() {
        // Set a confirmation callback
        boolean[] callbackCalled = { false };
        confirmationPopup.setConfirmationCallback(confirmed -> {
            callbackCalled[0] = true;
        });

        // Show the confirmation popup
        confirmationPopup.show();
        assertTrue(confirmationPopup.isShowing());

        // Confirm the action
        clickOn("#yesButton");
        assertFalse(confirmationPopup.isShowing());
        assertTrue(callbackCalled[0]);
    }

    @Test
    public void testConfirmationPopupFocus() {
        assertFalse(confirmationPopup.isShowing());

        // Show the confirmation popup
        confirmationPopup.show();
        assertTrue(confirmationPopup.isShowing());

        // Focus on the confirmation popup
        confirmationPopup.focus();
    }
}

