package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public void display(String Title,String Message){
        Stage Windows = new Stage();
        Windows.setTitle(Title);
        Windows.initModality(Modality.APPLICATION_MODAL);
        Windows.setMinWidth(300);
        Windows.setMinHeight(150);
        Label label = new Label(Message);
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        Windows.setScene(scene);
        Windows.showAndWait();
    }
}