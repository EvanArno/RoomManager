package sample;


import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.swing.text.Style;
import java.awt.event.ActionEvent;
import java.sql.*;

public class person {
    StringProperty stuId;
    StringProperty stuName;
    StringProperty colleget;
    StringProperty department;
    StringProperty classId;
    StringProperty roomId;
    StringProperty bedId;
    public person(String stuId1,String stuName1,String colleget1,String department1,String classId1,String roomId1,String bedId1){
        this.setstuId(stuId1);
        this.setStuName(stuName1);
        this.setcolleget(colleget1);
        this.setdepartment(department1);
        this.setclassId(classId1);
        this.setroomId(roomId1);
        this.setbedId(bedId1);
    }
    public String getstuId(){return stuIdProperty().get();}
    public void setstuId(String a){stuIdProperty().set(a);}
    public StringProperty stuIdProperty(){
        if(stuId == null) stuId = new SimpleStringProperty(this, "stuId");
        return stuId;
    }
    public String getstuName(){return stuNameProperty().get();}
    public void setStuName(String a){stuNameProperty().set(a);}
    public StringProperty stuNameProperty(){
        if(stuName == null) stuName = new SimpleStringProperty(this, "stuName");
        return stuName;
    }
    public String getcolleget(){return collegetProperty().get();}
    public void setcolleget(String a){collegetProperty().set(a);}
    public StringProperty collegetProperty(){
        if(colleget == null) colleget = new SimpleStringProperty(this, "colleget");
        return colleget;
    }
    public String getdepartment(){return departmentProperty().get();}
    public void setdepartment(String a){departmentProperty().set(a);}
    public StringProperty departmentProperty(){
        if(department == null) department = new SimpleStringProperty(this, "department");
        return department;
    }
    public String getclassId(){return classIdProperty().get();}
    public void setclassId(String a){classIdProperty().set(a);}
    public StringProperty classIdProperty(){
        if(classId == null) classId = new SimpleStringProperty(this, "classId");
        return classId;
    }
    public String getroomId(){return roomIdProperty().get();}
    public void setroomId(String a){roomIdProperty().set(a);}
    public StringProperty roomIdProperty(){
        if(roomId == null) roomId = new SimpleStringProperty(this, "roomId");
        return roomId;
    }
    public String getbedId(){return bedIdProperty().get();}
    public void setbedId(String a){bedIdProperty().set(a);}
    public StringProperty bedIdProperty(){
        if(bedId == null) bedId = new SimpleStringProperty(this, "bedId");
        return bedId;
    }
}
