package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.application.Platform;
import javafx.scene.input.Clipboard;
import javafx.stage.Stage;

public class HelpWindowTest extends ApplicationTest {

    private HelpWindow helpWindow;

    @Override
    public void start(Stage stage) {
        helpWindow = new HelpWindow();
    }

    @Test
    public void isShowingShouldReturnFalseInitially() {
        assertFalse(helpWindow.isShowing());
    }

    @Test
    public void showShouldMakeIsShowingTrue() {
        Platform.runLater(() -> {
            helpWindow.show();
            assertTrue(helpWindow.isShowing());
        });
    }

    @Test
    public void hideShouldMakeIsShowingFalse() {
        Platform.runLater(() -> {
            helpWindow.show();
            helpWindow.hide();
            assertFalse(helpWindow.isShowing());
        });
    }

    @Test
    public void focusShouldMakeWindowFocused() {
        Platform.runLater(() -> {
            helpWindow.show();
            helpWindow.focus();
            assertTrue(helpWindow.getRoot().isFocused());
        });
    }

    @Test
    public void otherWindowFocusShouldMakeWindowNotFocused() {
        Platform.runLater(() -> {
            helpWindow.show();
            helpWindow.focus();
            Stage otherWindow = new Stage();
            otherWindow.show();
            otherWindow.requestFocus();
            assertFalse(helpWindow.getRoot().isFocused());
        });
    }

    @Test
    public void copyUrlShouldCopyCorrectUrlToClipboard() {
        Platform.runLater(() -> {
            helpWindow.copyUrl();
            Clipboard clipboard = Clipboard.getSystemClipboard();
            assertEquals(HelpWindow.USERGUIDE_URL, clipboard.getString());
        });
    }

    @Test
    public void copyUrlShouldNotThrowExceptionWhenWindowIsNotShown() {
        Platform.runLater(() -> {
            helpWindow.copyUrl();
            assertFalse(helpWindow.isShowing());
        });
    }
}
