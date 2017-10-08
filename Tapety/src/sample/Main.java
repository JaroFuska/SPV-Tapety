package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Label pocetRiadkovLabel = new Label("POCET RIADKOV:");
        TextField pocetRiadkovTF = new TextField ();
        Button btnPlus1 = new Button("+");
        Button btnMinus1 = new Button("-");
        HBox hb = new HBox();
        hb.getChildren().addAll(pocetRiadkovLabel, pocetRiadkovTF, btnPlus1, btnMinus1);
        hb.setSpacing(10);

        pocetRiadkovTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    pocetRiadkovTF.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        Label pocetStlpcovLabel = new Label("POCET STLPCOV:");
        TextField pocetStlpcovTF = new TextField ();
        Button btnPlus2 = new Button("+");
        Button btnMinus2 = new Button("-");
        HBox hb2 = new HBox();
        hb2.getChildren().addAll(pocetStlpcovLabel, pocetStlpcovTF, btnPlus2, btnMinus2);
        hb2.setSpacing(10);

        pocetStlpcovTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    pocetStlpcovTF.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        Label velkostStvorcaLabel = new Label("VELKOST STVORCA:");
        TextField velkostStvorcaTF = new TextField ();
        Button btnPlus3 = new Button("+");
        Button btnMinus3 = new Button("-");
        HBox hb3 = new HBox();
        hb3.getChildren().addAll(velkostStvorcaLabel, velkostStvorcaTF, btnPlus3, btnMinus3);
        hb3.setSpacing(10);

        velkostStvorcaLabel.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    velkostStvorcaLabel.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        Label pocetTapietLabel = new Label("POCET TAPIET:");
        TextField pocetTapietTF = new TextField ();
        Button btnPlus4 = new Button("+");
        Button btnMinus4 = new Button("-");
        HBox hb4 = new HBox();
        hb4.getChildren().addAll(pocetTapietLabel, pocetTapietTF, btnPlus4, btnMinus4);
        hb4.setSpacing(10);

        pocetTapietTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    pocetTapietTF.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        Button btnStart = new Button("START");
        Button btnUkazka = new Button("UKAZKA");

        btnPlus1.setPrefSize(25, 25);
        btnMinus1.setPrefSize(25, 25);
        btnPlus2.setPrefSize(25, 25);
        btnMinus2.setPrefSize(25, 25);
        btnPlus3.setPrefSize(25, 25);
        btnMinus3.setPrefSize(25, 25);
        btnPlus4.setPrefSize(25, 25);
        btnMinus4.setPrefSize(25, 25);

        pocetRiadkovTF.setMaxWidth(35);
        pocetStlpcovTF.setMaxWidth(35);
        velkostStvorcaTF.setMaxWidth(35);
        pocetTapietTF.setMaxWidth(35);


        primaryStage.setTitle("TAPETY");
        GridPane gridPane = new GridPane();
        gridPane.add(pocetRiadkovLabel, 0, 1);
        gridPane.add(pocetRiadkovTF, 1, 1);
        gridPane.add(btnPlus1, 2, 1);
        gridPane.add(btnMinus1, 3, 1);

        gridPane.add(pocetStlpcovLabel, 0, 2);
        gridPane.add(pocetStlpcovTF, 1, 2);
        gridPane.add(btnPlus2, 2, 2);
        gridPane.add(btnMinus2, 3, 2);

        gridPane.add(velkostStvorcaLabel, 0, 3);
        gridPane.add(velkostStvorcaTF, 1, 3);
        gridPane.add(btnPlus3, 2, 3);
        gridPane.add(btnMinus3, 3, 3);

        gridPane.add(pocetTapietLabel, 0, 4);
        gridPane.add(pocetTapietTF, 1, 4);
        gridPane.add(btnPlus4, 2, 4);
        gridPane.add(btnMinus4, 3, 4);

        gridPane.add(btnStart, 1, 7);
        btnStart.setMinWidth(95);
        GridPane.setColumnSpan(btnStart, 4);

        gridPane.add(btnUkazka, 1, 8);
        btnUkazka.setMinWidth(95);
        GridPane.setColumnSpan(btnUkazka, 4);

        btnMinus1.setOnMouseClicked(event -> {
            minus(pocetRiadkovTF);
        });
        btnMinus2.setOnMouseClicked(event -> {
            minus(pocetStlpcovTF);
        });
        btnMinus3.setOnMouseClicked(event -> {
            minus(velkostStvorcaTF);
        });
        btnMinus4.setOnMouseClicked(event -> {
            minus(pocetTapietTF);
        });


        btnPlus1.setOnMouseClicked(event -> {
            plus(pocetRiadkovTF);
        });
        btnPlus2.setOnMouseClicked(event -> {
            plus(pocetStlpcovTF);
        });
        btnPlus3.setOnMouseClicked(event -> {
            plus(velkostStvorcaTF);
        });
        btnPlus4.setOnMouseClicked(event -> {
            plus(pocetTapietTF);
        });

        PlayGround pg = new PlayGround(400, 400);

        btnUkazka.setOnMouseClicked(event -> {
            if (!pocetRiadkovTF.getText().equals("") && !pocetStlpcovTF.getText().equals("") &&
                    !velkostStvorcaTF.getText().equals("") && !pocetTapietTF.getText().equals("")) {
                pg.paint(Integer.parseInt(pocetStlpcovTF.getText()), Integer.parseInt(pocetRiadkovTF.getText()));
                generate_objects(Integer.parseInt(pocetStlpcovTF.getText()), Integer.parseInt(pocetRiadkovTF.getText()), Integer.parseInt(pocetTapietTF.getText()));
            }
        });

        gridPane.add(pg, 6, 1);

        gridPane.setRowSpan(pg, 12);



        gridPane.setVgap(20);
        gridPane.setHgap(5);
        Scene scene = new Scene(gridPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private void generate_objects(int y, int x, int n) {
        boolean field [][] = new boolean[x][y];
        for (int i = 0; i < n; i++) {
            //TODO
        }
    }

    private void minus(TextField tf) {
        if (tf.getText() != null && !tf.getText().equals("") && !tf.getText().equals("0")) {
            tf.setText((Integer.parseInt(tf.getText()) - 1) + "");
        } else if (tf.getText().equals("0")) {
            tf.setText("0");
        } else {
            tf.setText("0");
        }
    }

    private void plus(TextField tf) {
        if (tf.getText() != null && !tf.getText().equals("")) {
            tf.setText((Integer.parseInt(tf.getText()) + 1) + "");
        } else {
            tf.setText("1");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
