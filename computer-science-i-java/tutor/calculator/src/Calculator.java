import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

    private TextField firstOperandField, secondOperandField;
    private Label operatorLabel, resultLabel;
    private TextArea historyArea;

    @Override
    public void start(Stage stage) {
        // construct the elements for the top bar
        firstOperandField = new TextField();
        operatorLabel = new Label("+");
        secondOperandField = new TextField();
        Label equalLabel = new Label("=");
        resultLabel = new Label("result");

        // construct a hbox and set the children (top bar elements) to be held within it
        HBox topBar = new HBox(20, firstOperandField, operatorLabel, secondOperandField, equalLabel, resultLabel);
        topBar.setAlignment(Pos.CENTER);

        // construct a toggle group for the operator buttons
        ToggleGroup operatorGroup = new ToggleGroup();

        Label selectLabel = new Label("Select an Operator:");

        // construct each operator button and set the toggle group to our previously constructed operatorGroup
        RadioButton addButton = new RadioButton("Add (+)");
        addButton.setToggleGroup(operatorGroup);
        addButton.setSelected(true);
        addButton.setOnAction(e -> operatorLabel.setText("+"));

        RadioButton subtractButton = new RadioButton("Subtract (-)");
        subtractButton.setToggleGroup(operatorGroup);
        subtractButton.setOnAction(e -> operatorLabel.setText("-"));

        RadioButton multiplyButton = new RadioButton("Multiply (*)");
        multiplyButton.setToggleGroup(operatorGroup);
        multiplyButton.setOnAction(e -> operatorLabel.setText("*"));

        RadioButton divideButton = new RadioButton("Divide (/)");
        divideButton.setToggleGroup(operatorGroup);
        divideButton.setOnAction(e -> operatorLabel.setText("/"));

        // construct a vbox and set the children (left bar elements) to be held within it
        VBox leftBar = new VBox(20, selectLabel, addButton, subtractButton, multiplyButton, divideButton);
        leftBar.setAlignment(Pos.CENTER_LEFT);

        // construct the history area wherein previous calculations will be stored
        historyArea = new TextArea();

        // construct each operation button
        Button resetButton = new Button("Reset Input");
        resetButton.setOnAction(e -> resetInput());

        Button clearButton = new Button("Clear Calculation Log");
        clearButton.setOnAction(e -> clearCalculationLog());

        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e -> calculate());

        Button quitButton = new Button("Quit");
        quitButton.setOnAction(e -> Platform.exit());

        // construct a hbox and set the children (bottom bar elements) to be held within it
        HBox bottomBar = new HBox(20, resetButton, clearButton, calculateButton, quitButton);
        bottomBar.setAlignment(Pos.CENTER);

        // construct the root layout
        BorderPane root = new BorderPane();
        root.setTop(topBar);
        root.setLeft(leftBar);
        root.setCenter(historyArea);
        root.setBottom(bottomBar);

        // construct insets object to pad the margins of our object areas
        Insets spacing = new Insets(10);
        BorderPane.setMargin(topBar, spacing);
        BorderPane.setMargin(leftBar, spacing);
        BorderPane.setMargin(historyArea, spacing);
        BorderPane.setMargin(bottomBar, spacing);

        // construct and set the scene, set the title, and set it visible
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Programming Assignment 5");
        stage.show();
    }

    /**
     * Reset the input values of the first and second operands.
     */
    private void resetInput() {
        firstOperandField.setText("");
        secondOperandField.setText("");
        resultLabel.setText("result");
    }

    /**
     * Reset the text within the calculation history area.
     */
    private void clearCalculationLog() {
        historyArea.setText("");
    }

    /**
     * Calculate the value of the expression given the input first and second operands and chosen operator.
     */
    private void calculate() {
        // parse the first and second operands
        int firstOperand = Integer.parseInt(firstOperandField.getText());
        int secondOperand = Integer.parseInt(secondOperandField.getText());

        // calculate the result
        int result = calculate(firstOperand, secondOperand);

        // set the text of the resultLabel to the result of the expression
        resultLabel.setText(String.valueOf(result));

        // format the resulting expression as a string
        String strResult = firstOperand + " " + operatorLabel.getText() + " " + secondOperand + " = " + result + "\n";

        // push the expression to the existing calculation history
        historyArea.setText(historyArea.getText() + strResult);
    }

    /**
     * Calculate the result of an expression given the following parameters:
     *
     * @param firstOperand      the first (left) operand.
     * @param secondOperand     the second (right) operand.
     *
     * @return      the result of the expression.
     */
    private int calculate(int firstOperand, int secondOperand) {
        // switch statement to dictate operation based on the text of the operatorLabel
        switch(operatorLabel.getText()) {
            case "+": return firstOperand + secondOperand;
            case "-": return firstOperand - secondOperand;
            case "*": return firstOperand * secondOperand;
            case "/": return firstOperand / secondOperand;
            default: throw new IllegalArgumentException("Invalid operator!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}