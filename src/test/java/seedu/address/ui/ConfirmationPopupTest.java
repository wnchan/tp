package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Consumer;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Test;




class ConfirmationPopupTest {

    @Test
    void testYesButtonWorkflow() {
        // Initialize JavaFX toolkit
        new JFXPanel();

        // Run the test on the JavaFX application thread
        Platform.runLater(() -> {
            ConfirmationPopup confirmationPopup = new ConfirmationPopup();

            // Initial state checks
            assertFalse(confirmationPopup.isShowing());
            assertFalse(confirmationPopup.isConfirmed());

            // Set up a simple test double for the callback
            boolean[] callbackInvoked = {false};
            Consumer<Boolean> callback = confirmed -> callbackInvoked[0] = true;

            // Set the callback
            confirmationPopup.setConfirmationCallback(callback);

            // Show the popup
            confirmationPopup.show();

            // Check if the popup is showing
            assertTrue(confirmationPopup.isShowing());

            // Fire the 'yes' button event
            confirmationPopup.yesButton.fire();

            // Check if the confirmation callback was invoked and if the confirmation state is true
            assertTrue(callbackInvoked[0]);
            assertTrue(confirmationPopup.isConfirmed());

            // Close the popup
            confirmationPopup.getRoot().close();

            // Check if the popup is no longer showing
            assertFalse(confirmationPopup.isShowing());
        });
    }

    @Test
    void testCancelButtonWorkflow() {
        // Initialize JavaFX toolkit
        new JFXPanel();

        // Run the test on the JavaFX application thread
        Platform.runLater(() -> {
            ConfirmationPopup confirmationPopup = new ConfirmationPopup();

            // Initial state checks
            assertFalse(confirmationPopup.isShowing());
            assertFalse(confirmationPopup.isConfirmed());

            // Set up a simple test double for the callback
            boolean[] callbackInvoked = {false};
            Consumer<Boolean> callback = confirmed -> callbackInvoked[0] = true;

            // Set the callback
            confirmationPopup.setConfirmationCallback(callback);

            // Show the popup
            confirmationPopup.show();

            // Check if the popup is showing
            assertTrue(confirmationPopup.isShowing());

            // Fire the 'cancel' button event
            confirmationPopup.cancelButton.fire();

            // Check if the confirmation callback was not invoked and if the confirmation state is false
            assertFalse(callbackInvoked[0]);
            assertFalse(confirmationPopup.isConfirmed());

            // Close the popup
            confirmationPopup.getRoot().close();

            // Check if the popup is no longer showing
            assertFalse(confirmationPopup.isShowing());
        });
    }
}
