package sample.exercise2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.LinkedList;

public class StoreNumbers extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        LinkedList<Integer> integers = new LinkedList<>();

        BorderPane pane = new BorderPane();

        TextField textField = new TextField();
        HBox top = new HBox(new Text("Enter a number: "), textField);
        top.setAlignment(Pos.CENTER);
        pane.setTop(top);

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(true);
        pane.setCenter(textArea);

        Button sort = new Button("Sort");
        Button shuffle = new Button("Shuffle");
        Button reverse = new Button("Reverse");
        HBox buttons = new HBox(sort, shuffle, reverse);
        buttons.setAlignment(Pos.CENTER);
        pane.setBottom(buttons);


        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 2");
        primaryStage.show();

        textField.setOnAction(e -> {
            integers.addLast(Integer.parseInt(textField.getText()));
            updateTextArea(textArea,integers);
        });

        sort.setOnAction(e->{
            Collections.sort(integers);
            updateTextArea(textArea, integers);
        });

        shuffle.setOnAction(e->{
            Collections.shuffle(integers);
            updateTextArea(textArea, integers);
        });

        reverse.setOnAction(e->{
            Collections.reverse(integers);
            updateTextArea(textArea, integers);
        });
    }

    private static void updateTextArea(TextArea textArea, LinkedList<Integer> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        arrayList.forEach(e -> stringBuilder.append(e).append(" "));
        textArea.setText(stringBuilder.toString());
    }
}
