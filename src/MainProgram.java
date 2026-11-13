import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.geometry.Insets;
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
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram extends Application {
    public static Text outputText =  new Text();
    public static String programRunning = "commands";
    public static TextArea inputArea = new TextArea();
    public static TextFlow outputArea = new TextFlow(outputText);
    private static Timeline animation1 = new Timeline();
    @Override
    public void start(Stage stage1) throws Exception {
        TerminalController controller = new TerminalController();
        controller.initialize();
        outputArea.getStyleClass().add("outputArea");

        outputArea.setVisible(false);
        outputArea.setManaged(false);
        outputArea.setPadding(new Insets(0,0,0,20));
        outputText.getStyleClass().add("outputText");
        inputArea.getStyleClass().add("inputArea");
        inputArea.setWrapText(true);
        VBox terminalLayout = new VBox(outputArea,inputArea);
        VBox.setVgrow(inputArea, Priority.ALWAYS);
        Scene scene1 = new Scene(terminalLayout, 2040, 1080);
        String cssPath = getClass().getResource("style.css").toExternalForm();
        scene1.setCursor(Cursor.NONE);

        scene1.getStylesheets().add(cssPath);
        stage1.setScene(scene1);
        stage1.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    public static void displayText(String text)
    {
        animation1.stop();
        animation1.getKeyFrames().clear();
        Duration delay = Duration.millis((double) 1000/text.length());
        for(int i = 0; i < text.length(); i++)
        {
            final int index = i;
            KeyFrame frame = new KeyFrame(
                    delay.multiply(index + 1),
                    e -> outputText.setText(outputText.getText() + text.charAt(index))

            );
            animation1.getKeyFrames().add(frame);
        }
        animation1.play();
    }

    public static void commands(String text)
    {
        text = text.toLowerCase();

        if (text.equals("help"))
        {
            displayText("Valid commands include:\nhelp\nmath");
        } else
        if (text.equals("math"))
        {
            programRunning = "math";
            displayText("Please enter the equation:");
        } else
        {
            displayText("Please enter a valid command or type help for valid commands.");
        }

    }
    public static class TerminalController {
        public void initialize() {
            inputArea.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    event.consume();
                    if (programRunning.equals("commands")) {
                        commands(inputArea.getText().trim());
                    } else if (programRunning.equals("math")) {
                        Calculator.math(inputArea.getText().trim());
                    }
                    System.out.println(inputArea.getText());
                    inputArea.clear();
                    outputArea.setVisible(true);
                    outputArea.setManaged(true);
                    outputText.setText("");
                }
            });
        }
    }
    public static class Calculator {
        public static void math(String input)
        {
            ArrayList<Double> numbers = new ArrayList<>();
            ArrayList<Character> operators = new ArrayList<>();
            String num = "";

            int inputLength = input.length();
            for (int i = 0; i < inputLength; i++) {
                char char1 = input.charAt(i);
                if (Character.isDigit(char1) || char1 == '.') {
                    num += char1;
                } else if (char1 == '+' || char1 == '-' || char1 == '*' || char1 == '/') {
                    numbers.add(Double.parseDouble(num));
                    operators.add(char1);
                    num = "";
                }
            }

            if (!num.isEmpty()) {
                numbers.add(Double.parseDouble(num));
            }

            for (int i = 0; i < numbers.size(); i++) {
                double num1 = numbers.get(0);
                double num2 = numbers.get(1);
                if (operators.contains('*')) {
                    int index = operators.indexOf('*');

                }
            }
        }
    }

}