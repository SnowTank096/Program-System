import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
        TextField input = new TextField();
        StackPane root = new StackPane();
        Scene scene1 = new Scene(root, 1028, 1028);
        input.setPromptText("Type your text here...");
        input.setPrefSize(250,25);
        input.setMaxSize(250,25);
        input.setFont(Font.font("Arial", FontWeight.BOLD,25));
        input.setOnAction(event -> {
            String text = input.getText();
            Scanner scanner = new Scanner(text);
            if (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        });
        VBox vbox = new VBox(10, input);
        root.getChildren().addAll(input);
        StackPane.setAlignment(input, Pos.TOP_LEFT);
        stage1.setScene(scene1);
        stage1.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}