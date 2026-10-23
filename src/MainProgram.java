import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.util.Scanner;

public class MainProgram extends Application {
    @Override
    public void start(Stage stage1) throws Exception {
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);

        TextField inputArea = new TextField();
        inputArea.getStyleClass().add("inputArea");

        VBox terminalLayout = new VBox(outputArea, inputArea);

        VBox.setVgrow(outputArea, Priority.ALWAYS);

        Scene scene1 = new Scene(terminalLayout, 600, 400);
        String cssPath = getClass().getResource("style.css").toExternalForm();
        scene1.setCursor(Cursor.NONE);

        scene1.getStylesheets().add(cssPath);
        stage1.setScene(scene1);
        stage1.show();
        inputArea.requestFocus();
        outputArea.focusedProperty().addListener((obs, oldval, newVal) -> {
            if (newVal) {
                inputArea.requestFocus();
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}