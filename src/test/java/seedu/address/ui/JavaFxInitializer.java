package seedu.address.ui;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * A utility class for initializing and cleaning up JavaFX for headless testing.
 */
public class JavaFxInitializer {

    /**
     * Initializes JavaFX on a separate thread.
     * The JavaFX application will be launched using {@link JavaFXInit}.
     */
    public static void initialize() {
        Thread t = new Thread("JavaFX Init Thread") {
            @Override
            public void run() {
                Application.launch(JavaFxInit.class);
            }
        };
        t.setDaemon(true);
        t.start();
    }

    /**
     * Cleans up the JavaFX initialization if needed.
     * This method can be called after tests are completed to perform any necessary cleanup logic.
     */
    public static void cleanup() {
        JavaFxInit instance = JavaFxInit.getInstance();
        if (instance != null) {
            instance.cleanup();
        }
    }

    /**
     * A JavaFX Application class used for initializing JavaFX.
     */
    public static class JavaFxInit extends Application {
        private static JavaFxInit instance;

        @Override
        public void start(Stage primaryStage) {
            // Save the instance for later cleanup
            instance = this;
            primaryStage.hide();
        }

        /**
         * Performs cleanup logic if needed.
         * This method can be overridden in subclasses to add custom cleanup logic.
         */
        public void cleanup() {
            // Call any cleanup logic here if needed
        }

        /**
         * Gets the instance of the JavaFX initialization class.
         *
         * @return The instance of the JavaFX initialization class.
         */
        public static JavaFxInit getInstance() {
            return instance;
        }
    }
}
