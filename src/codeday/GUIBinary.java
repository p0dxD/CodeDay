/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeday;

import static codeday.BinaryConverter.breakSentence;
import static codeday.BinaryConverter.countOnes;
import static codeday.BinaryConverter.countZeros;
import static codeday.BinaryConverter.getBinaryValues;
import static codeday.BinaryConverter.getCountOnes;
import static codeday.BinaryConverter.getCountZeros;
import static codeday.BinaryConverter.printbinaryValues;
import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Joseph
 */
public class GUIBinary extends Application {

    TextArea tf = new TextArea();
    TextArea tfResult = new TextArea();
    Button btnSend = new Button("Send");
    Label ones = new Label("Ones: ");
    Label zeros = new Label("Zeros: ");

    @Override
    public void start(Stage primaryStage) {
        btnSend.getStyleClass().add("green");
        tf.getStyleClass().add("custom-text-field");
        tfResult.getStyleClass().add("custom-text-field");
        //clickSend(tf,tfResult);
        btnSend.setOnMouseClicked(e -> {
            clickSend(tf, tfResult);
        });
        tfResult.setText(getBinaryValues().toString());
        Scene scene = new Scene(setUpGui(), 250, 220);
        scene.getStylesheets().add(new File("styleButtons.css").toURI().toString());
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Music out of binary");
        primaryStage.show();
//        RoomNumberAnnotator test  = new RoomNumberAnnotator();

    }

    /**
     * This is the method to clal when send is clicked
     *
     * @param tf the text field of input
     * @param tfResult the textfield of output that will store the answer
     */
    public void clickSend(TextArea tf, TextArea tfResult) {
        breakSentence(tf.getText());
        countOnes(BinaryConverter.getBinaryValues());
        countZeros(BinaryConverter.getBinaryValues());
        printbinaryValues();
        tfResult.setText(getBinaryValues().toString());
        ones.setText("Ones: " + getCountOnes());
        zeros.setText("Zeros: " + getCountZeros());
        //System.out.println("\nOnes: " + getCountOnes());
        //System.out.println("\nZeros: " + getCountZeros());
    }
    /**
     * This will just display the GUI
     * @return the pane with all the setup
     */
    public BorderPane setUpGui() {
        GridPane grid = new GridPane();
        BorderPane pane = new BorderPane();
        //TextArea test = new TextArea("This is a test");/////////////////////////////////////////////////////////
        pane.getStyleClass().add("right-page-turn");
        ones.getStyleClass().add("label");
        zeros.getStyleClass().add("label");
        //grid.getStyleClass().add("right-page-turn");
        Button btnClose = new Button("Close");
        btnClose.getStyleClass().add("red");
        btnClose.setOnMouseClicked(e -> {
            System.exit(0);
        });
        //This is for putting tooltips on all the items including 
        //labels and such
        btnSend.setTooltip(new Tooltip("Click here to send text"));
        btnClose.setTooltip(new Tooltip("Click here to exit"));
        ones.setTooltip(new Tooltip("This is the number of ones contained"));
        zeros.setTooltip(new Tooltip("This is the number of zeros contained"));
        tf.setTooltip(new Tooltip("Here you can enter the text to convert"));
        tfResult.setTooltip(new Tooltip("Here is the result of that text obtained"));
        tfResult.setTooltip(new Tooltip("Here is the result of that text obtained"));
        btnSend.setFocusTraversable(false);
        //grid.add(test, 3, 1);
        grid.add(btnSend, 2, 1);
        grid.add(btnClose, 2, 4);
        grid.add(ones, 0, 6);
        grid.add(zeros, 0, 7);
        tf.setPrefHeight(90);
        tf.setPrefWidth(200);
        tf.setText("Here input your text");
        grid.add(tf, 0, 1);
        grid.add(tfResult, 0, 4);
        tfResult.setPrefHeight(90);
        tfResult.setPrefWidth(200);
        pane.setCenter(grid);
        //This will put a delimiter on the TextArea
        tf.setWrapText(true);
        tfResult.setWrapText(true);
        return pane;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
