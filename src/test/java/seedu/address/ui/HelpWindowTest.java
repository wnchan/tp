//package seedu.address.ui;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.junit.jupiter.api.Test;
//import org.testfx.framework.junit5.ApplicationTest;
//
//import javafx.application.Platform;
//import javafx.scene.input.Clipboard;
//import javafx.scene.input.DataFormat;
//import javafx.stage.Stage;
//
//public class HelpWindowTest extends ApplicationTest {
//
//    private HelpWindow helpWindow;
//
//    @Override
//    public void start(Stage stage) {
//        helpWindow = new HelpWindow();
//    }
//
//    @Test
//    public void isShowingShouldReturnFalseInitially() {
//        assertFalse(helpWindow.isShowing());
//    }
//
//    @Test
//    public void showShouldMakeIsShowingTrue() {
//        Platform.runLater(() -> {
//            helpWindow.show();
//            assertTrue(helpWindow.isShowing());
//        });
//    }
//    @Test
//    public void hideShouldMakeIsShowingFalse() {
//        Platform.runLater(() -> {
//            helpWindow.show();
//            helpWindow.hide();
//            assertFalse(helpWindow.isShowing());
//        });
//    }
//
//    @Test
//    public void testCopyUrlMethod() {
//        Platform.runLater(() -> {
//            helpWindow.copyUrl();
//            Clipboard clipboard = Clipboard.getSystemClipboard();
//            DataFormat dataFormat = DataFormat.PLAIN_TEXT;
//            assertTrue(clipboard.hasContent(dataFormat), "Clipboard should contain plain text");
//            String clipboardText = (String) clipboard.getContent(dataFormat);
//            assertEquals(HelpWindow.USERGUIDE_URL, clipboardText, "Copied URL should match the expected URL");
//        });
//    }
//}
