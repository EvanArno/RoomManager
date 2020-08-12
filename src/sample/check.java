package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
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

public class check {
    Statement sta;

    public static boolean checkpsw(String login,String psw)throws SQLException{
        Connection con = Database.getConnection();
        Statement sta = con.createStatement();
        String sql="SELECT password FROM admininfo WHERE name = '" + login +"'";
        try{
            ResultSet rs=sta.executeQuery(sql);//返回结果集
            String name="";
            rs.next();
            name = rs.getString("password");
            if(name.equals(psw)){
                //System.out.print("number1:"+number1);
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean checkroom(String roomID,String no)throws SQLException{
        Connection con = Database.getConnection();
        Statement sta = con.createStatement();
        String sql="SELECT * FROM roominfo WHERE roomId = '" + roomID +"'";
        try {
            ResultSet rs=sta.executeQuery(sql);
            while (rs.next()) {
                String room = rs.getString(no);
                if(room.equals("无")){
                    return true;
                }
                else{
                    return false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        sta.close();
        return false;
    }
    public static void register(String roomID,String number,String chuanghao) throws Exception{
        Connection con = Database.getConnection();
        String bed = "bed" + chuanghao;
        String sql1 = "UPDATE studentinfo SET isCheckIn = '"+ roomID +"' WHERE stuID = '" + number +"'";
        String sql2 = "UPDATE roominfo SET " + bed + " = '"+ number +"' WHERE roomId = '" + roomID +"'";
        String sql3 = "UPDATE studentinfo SET bedId = '"+ chuanghao +"' WHERE stuID = '" + number +"'";
        try{
            PreparedStatement sta1 = con.prepareStatement(sql1);
            PreparedStatement sta2 = con.prepareStatement(sql2);
            PreparedStatement sta3 = con.prepareStatement(sql3);
            sta1.executeUpdate();
            sta2.executeUpdate();
            sta3.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void cancel(String roomID,String number,String chuanghao) throws Exception{
        Connection con = Database.getConnection();
        String bed = "bed" + chuanghao;
        String sql1 = "UPDATE studentinfo SET isCheckIn = 0 WHERE stuID = '" + number +"'";
        String sql2 = "UPDATE roominfo SET " + bed + " = '无' WHERE roomId = '" + roomID +"'";
        String sql3 = "UPDATE studentinfo SET bedId = 0 WHERE stuID = '" + number +"'";
        try{
            PreparedStatement sta1 = con.prepareStatement(sql1);
            PreparedStatement sta2 = con.prepareStatement(sql2);
            PreparedStatement sta3 = con.prepareStatement(sql3);
            sta1.executeUpdate();
            sta2.executeUpdate();
            sta3.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Boolean checkfull(String roomID) throws Exception{
        Connection con = Database.getConnection();
        Statement sta = con.createStatement();
        String sql="SELECT * FROM roominfo WHERE roomId = '" + roomID +"'";
        try {
            ResultSet rs=sta.executeQuery(sql);
            while (rs.next()) {
                String room1 = rs.getString("bed1");
                String room2 = rs.getString("bed2");
                String room3 = rs.getString("bed3");
                String room4 = rs.getString("bed4");
                if(room1.equals("无")){
                    return false;
                }
                if(room2.equals("无")){
                    return false;
                }
                if(room3.equals("无")){
                    return false;
                }
                if(room4.equals("无")){
                    return false;
                }
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        sta.close();
        return true;
    }
    public static void tableinitialize(ObservableList<person> data) throws Exception{
        Connection con = Database.getConnection();
        Statement sta = con.createStatement();
        String sql="SELECT * FROM studentinfo";
        data.clear();
        try{
            ResultSet rs=sta.executeQuery(sql);
            while(rs.next()){
                data.add(new person(rs.getString("stuId"),rs.getString("stuName"),rs.getString("colleget"),
                        rs.getString("department"),rs.getString("class"),rs.getString("isCheckIn"),
                        rs.getString("bedId")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void tablefind(ObservableList<person> data,String a,String b) throws Exception{
        Connection con = Database.getConnection();
        Statement sta = con.createStatement();
        String sql="SELECT * FROM studentinfo WHERE "+ a +" = '"+ b + "'";
        data.clear();
        try{
            ResultSet rs=sta.executeQuery(sql);
            while(rs.next()){
                data.add(new person(rs.getString("stuId"),rs.getString("stuName"),rs.getString("colleget"),
                        rs.getString("department"),rs.getString("class"),rs.getString("isCheckIn"),
                        rs.getString("bedId")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
