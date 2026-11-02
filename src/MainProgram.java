import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.util.Scanner;

public class MainProgram extends Application {
    @Override
    public void start(Stage stage1) throws Exception {


        javafx.scene.text.Text outputText =  new javafx.scene.text.Text();

        javafx.scene.text.TextFlow outputArea = new javafx.scene.text.TextFlow(outputText);


        outputArea.getStyleClass().add("outputArea");

        outputArea.setVisible(false);
        outputArea.setManaged(false);

        TextArea inputArea = new TextArea();
        inputArea.getStyleClass().add("inputArea");
        inputArea.setWrapText(true);

        outputText.focusedProperty().addListener((obs, oldval, newVal) -> {
            if (newVal) {
                inputArea.requestFocus();
            }
        });
        outputText.getStyleClass().add("outputText");
        inputArea.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER){
                event.consume();
                outputText.setText("   "+inputArea.getText().trim());
                System.out.println(inputArea.getText());
                inputArea.clear();
                outputArea.setVisible(true);
                outputArea.setManaged(true);

            }
        });
        VBox terminalLayout = new VBox(outputArea,inputArea);
        VBox.setVgrow(inputArea, Priority.ALWAYS);
        Scene scene1 = new Scene(terminalLayout, 2040, 1080);
        String cssPath = getClass().getResource("style.css").toExternalForm();
        scene1.setCursor(Cursor.NONE);

        scene1.getStylesheets().add(cssPath);
        stage1.setScene(scene1);
        stage1.show();
        inputArea.requestFocus();
    }
    public static void main(String[] args) {
        launch(args);
    }
}