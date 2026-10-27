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
import javafx.scene.input.KeyCode;

import java.util.Scanner;

public class MainProgram extends Application {
    @Override
    public void start(Stage stage1) throws Exception {


        javafx.scene.text.Text outputText =  new javafx.scene.text.Text();

        javafx.scene.text.TextFlow textFlow = new javafx.scene.text.TextFlow(outputText);

        javafx.scene.control.ScrollPane outputArea = new javafx.scene.control.ScrollPane(textFlow);


        outputArea.setFitToWidth(true);
        outputArea.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        outputArea.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
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
        inputArea.setOnKeyPressed(event -> {
            event.consume();
            if (event.getCode() == KeyCode.ENTER){
                System.out.println(inputArea.getText());
                outputArea.setVisible(true);
                outputArea.setManaged(true);
                outputText.setText(inputArea.getText());
                inputArea.clear();
            }
        });
        VBox terminalLayout = new VBox(outputText,inputArea);
        VBox.setVgrow(inputArea, Priority.ALWAYS);
        Scene scene1 = new Scene(terminalLayout, 600, 400);
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