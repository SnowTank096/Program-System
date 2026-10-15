import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
        input.setMaxWidth(250);
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
        stage1.setScene(scene1);
        stage1.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}