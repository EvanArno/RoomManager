package sample;

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

public class Debug {
    public static Boolean stuinformationin(String stuID,String stuName,String colleget,String department,String classId)throws Exception{
        Database.link();
        Connection con = Database.getConnection();
        Statement sta = con.createStatement();
        String sql="SELECT * FROM studentinfo";
        try{
            ResultSet rs=sta.executeQuery(sql);
            String Id = "";
            while(rs.next()){
                Id = rs.getString("stuID");
                if(Id.equals(stuID)){
                    if(rs.getString("stuName").equals(stuName)){
                        if(rs.getString("colleget").equals(colleget)){
                            if(rs.getString("department").equals(department)){
                                if(rs.getString("class").equals(classId)){
                                    if(rs.getString("isCheckIn").equals("0")){
                                        return true;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static Boolean stuinformationout(String stuID,String stuName,String colleget,String department,String classId)throws Exception{
        Database.link();
        Connection con = Database.getConnection();
        Statement sta = con.createStatement();
        String sql="SELECT * FROM studentinfo";
        try{
            ResultSet rs=sta.executeQuery(sql);
            String Id = "";
            while(rs.next()){
                Id = rs.getString("stuID");
                if(Id.equals(stuID)){
                    if(rs.getString("stuName").equals(stuName)){
                        if(rs.getString("colleget").equals(colleget)){
                            if(rs.getString("department").equals(department)){
                                if(rs.getString("class").equals(classId)){
                                    if(rs.getString("isCheckIn").equals("1")){
                                        return true;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
