package seedu.address.ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFXInitializer {

    public static void initialize() {
        Thread t = new Thread("JavaFX Init Thread") {
            @Override
            public void run() {
                Application.launch(JavaFXInit.class);
            }
        };
        t.setDaemon(true);
        t.start();
    }

    public static void cleanup() {
        JavaFXInit.getInstance().cleanup();
    }

    public static class JavaFXInit extends Application {
        private static JavaFXInit instance;

        @Override
        public void start(Stage primaryStage) {
            // Save the instance for later cleanup
            instance = this;
            primaryStage.hide();
        }

        public void cleanup() {
            // Call any cleanup logic here if needed
        }

        public static JavaFXInit getInstance() {
            return instance;
        }
    }
}

