package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.sql.*;

public class ResetPassword {
    public void display()throws Exception{
        Database.link();
        Stage Windows = new Stage();
        Windows.setTitle("修改密码");
        Windows.initModality(Modality.APPLICATION_MODAL);
        Windows.setMinWidth(300);
        Windows.setMinHeight(150);
        Label psw = new Label("密码");
        TextField tfpsws = new TextField();
        HBox H1 = new HBox();
        H1.getChildren().addAll(psw,tfpsws);
        H1.setAlignment(Pos.CENTER);
        HBox H2 = new HBox();
        Button yes = new Button("确定");
        H2.getChildren().addAll(yes);
        H2.setAlignment(Pos.CENTER);
        VBox V1 = new VBox();
        V1.getChildren().addAll(H1,H2);
        V1.setAlignment(Pos.CENTER);

        yes.setOnAction((ActionEvent)->{
            Connection con = Database.getConnection();
            try{
                String sql="UPDATE admininfo SET password = '" + tfpsws.getText() +"' WHERE name = 'admin'";
                PreparedStatement sta = con.prepareStatement(sql);
                sta.executeUpdate();
                sta.close();
                Windows.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        });


        Scene scene = new Scene(V1);
        Windows.setScene(scene);
        Windows.show();
    }

}
