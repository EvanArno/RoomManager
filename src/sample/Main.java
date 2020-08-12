package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
import java.util.Observable;

public class Main extends Application {
    TableView<person> table = new TableView();
    //连接数据库
    @Override
    public void start(Stage primaryStage) throws Exception{
        Font fontBold = Font.font("Times New Roman", FontWeight.BOLD,20);
        // TODO Auto-generated method stub

   /*   ResultSet rs = sta.executeQuery("SELECT * FROM studentInfo");
        while(rs.next()){
            System.out.println(rs.getString("stuName")+"\t");
        }                                                           */



        //页面初始化
        BorderPane pane = new BorderPane();

//=======================================================================================================================
//=======================================================================================================================
        //index界面  pane0
        BorderPane paneindex = new BorderPane();
        paneindex.setPadding(new Insets(20,20,20,20));
        Label p0name = new Label("寝 室 管 理 系 统");
        p0name.setFont(fontBold);
        HBox p0title = new HBox(p0name);
        p0title.setAlignment(Pos.CENTER);
        paneindex.setTop(p0title);



        HBox account = new HBox();
        HBox psw = new HBox();
        VBox pindexaccount = new VBox(10);
        Label laccount = new Label("账 号:");
        Label lpsw = new Label("密 码:");
        TextField tflogin = new TextField();
        PasswordField tfpsw = new PasswordField();
        pindexaccount.getChildren().addAll(account,psw);
        account.getChildren().addAll(laccount,tflogin);
        psw.getChildren().addAll(lpsw,tfpsw);
        paneindex.setCenter(pindexaccount);
        pindexaccount.setAlignment(Pos.CENTER);
        account.setAlignment(Pos.CENTER);
        psw.setAlignment(Pos.CENTER);

        HBox p0login = new HBox(20);
        Button login = new Button("登 陆");
        login.setFont(Font.font("Times New Roman",40));
        login.setMaxWidth(300);
        p0login.getChildren().addAll(login);
        p0login.setAlignment(Pos.CENTER);
        paneindex.setBottom(p0login);



//=======================================================================================================================
//=======================================================================================================================
        //选择房间界面  pane1
        Label name = new Label("寝 室 列 表");
        BorderPane pane2 = new BorderPane();
        pane2.setPadding(new Insets(20,20,20,20));
        name.setFont(fontBold);
        HBox title = new HBox(15);
        title.getChildren().add(name);
        title.setPadding(new Insets(20,20,20,20));
        title.setAlignment(Pos.CENTER);

        GridPane num = new GridPane();
        num.setHgap(5);
        num.setVgap(5);
        num.setPadding(new Insets(20,20,20,20));
        Button[][] room = new Button[5][15];
        for(int i = 1 ; i <= 3 ; i ++){
            for(int j = 1 ; j <= 10 ; j ++){
                int name1 =(i)*100+j;
                room[i][j] = new Button();
                room[i][j].setText(""+name1);
                room[i][j].setStyle("-fx-background-color:yellow;-fx-border-color:white; -fx-border-width:3");
                num.add(room[i][j], j, i);
            }
        }
        num.setAlignment(Pos.CENTER);


        HBox mark = new HBox(15);
        Label yellow = new Label();
        yellow.setPadding(new Insets(5,10,5,10));
        yellow.setStyle("-fx-background-color:yellow;-fx-border-color:yellow; -fx-border-width:3;-fx-border-length:3");
        Label red = new Label();
        red.setPadding(new Insets(5,10,5,10));
        red.setStyle("-fx-background-color:red;-fx-border-color:red; -fx-border-width:3;-fx-border-length:3");
        Label yiman = new Label("已满");
        Label weiman = new Label("未满");
        mark.getChildren().addAll(red,yiman,yellow,weiman);
        mark.setAlignment(Pos.CENTER);
        HBox down = new HBox(15);
        down.setPadding(new Insets(20,20,20,20));
        down.setAlignment(Pos.CENTER);
        Label roomtips = new Label("选择的寝室是：");
        TextField input = new TextField();
        Button in = new Button("进入房间");
        Button intofind = new Button("进入查询界面");
        Button resetpsw = new Button("重置密码");
        Button relogin = new Button("返回登陆界面");
        down.getChildren().addAll(roomtips,input,in,intofind,resetpsw,relogin);
        input.setDisable(true);

        VBox mainpane = new VBox();
        mainpane.setPadding(new Insets(20,20,20,20));
        mainpane.setAlignment(Pos.CENTER);
        mainpane.getChildren().addAll(title,num,mark,down);
        BorderPane pane1 = new BorderPane();
        pane1.setCenter(mainpane);

//=======================================================================================================================
//=======================================================================================================================
        //寝室登记界面 pane2
        HBox P2top1 = new HBox();
        Label P2title = new Label("入 住 与 退 房 登 记 系 统");
        Label P2roomID = new Label();
        HBox P2top2 = new HBox();
        VBox P2top = new VBox();
        P2top1.setPadding(new Insets(30,0,0,0));
        P2title.setFont(fontBold);
        P2top1.setAlignment(Pos.CENTER);
        P2top2.setAlignment(Pos.CENTER);
        P2top1.getChildren().add(P2title);
        P2top2.getChildren().add(P2roomID);
        P2top.getChildren().addAll(P2top1,P2top2);
        pane2.setTop(P2top);
        GridPane P2information = new GridPane();
        P2information.setHgap(20);
        P2information.setVgap(20);
        P2information.setPadding(new Insets(20,20,20,20));
        P2information.setAlignment(Pos.CENTER);
        Label xuehao = new Label("学号");
        Label xueyuan = new Label("学院");
        Label banji = new Label("班级");
        Label xingming = new Label("姓名");
        Label xibie = new Label("系别");
        Label chuanghao = new Label("床号");
        TextField xuehaotf = new TextField();
        TextField xueyuantf = new TextField();
        TextField banjitf = new TextField();
        TextField xingmingtf = new TextField();
        TextField xibietf = new TextField();
        TextField chuanghaotf = new TextField();
        P2information.add(xuehao, 0, 0);
        P2information.add(xingming, 2, 0);
        P2information.add(xueyuan, 0, 1);
        P2information.add(xibie, 2, 1);
        P2information.add(banji, 0, 2);
        P2information.add(chuanghao, 2, 2);
        P2information.add(xuehaotf, 1, 0);
        P2information.add(xingmingtf, 3, 0);
        P2information.add(xueyuantf, 1, 1);
        P2information.add(xibietf, 3, 1);
        P2information.add(banjitf, 1, 2);
        P2information.add(chuanghaotf, 3, 2);
        pane2.setLeft(P2information);
        VBox P2right = new VBox(10);
        Label p2right = new Label("房    \n间    \n布    \n局    \n示    \n意    \n图    ");
        Label p2yellow = new Label();
        p2yellow.setPadding(new Insets(5,10,5,10));
        p2yellow.setStyle("-fx-background-color:yellow;-fx-border-color:yellow; -fx-border-width:3;-fx-border-length:3");
        Label p2red = new Label();
        p2red.setPadding(new Insets(5,10,5,10));
        p2red.setStyle("-fx-background-color:red;-fx-border-color:red; -fx-border-width:3;-fx-border-length:3");
        HBox p2mark1 = new HBox(15);
        HBox p2mark2 = new HBox(15);
        Label p2yiman = new Label("有人");
        Label p2weiman = new Label("没人");
        p2mark1.getChildren().addAll(p2yiman,p2red);
        p2mark2.getChildren().addAll(p2weiman,p2yellow);
        P2right.setAlignment(Pos.CENTER);
        p2right.setFont(fontBold);
        P2right.getChildren().addAll(p2right,p2mark1,p2mark2);
        pane2.setRight(P2right);
        Button p2sure = new Button("确定入住");
        Button p2out = new Button("确定退房");
        Button p2back = new Button("返回");
        HBox p2bottom = new HBox(30);
        p2bottom.setAlignment(Pos.CENTER);
        p2bottom.getChildren().addAll(p2sure,p2out,p2back);
        pane2.setBottom(p2bottom);
        GridPane p2map = new GridPane();
        p2map.setPadding(new Insets(20,20,20,20));
        p2map.setVgap(20);
        p2map.setHgap(20);
        pane2.setCenter(p2map);
        p2map.setAlignment(Pos.CENTER);
        Button yangtai = new Button("阳台");
        yangtai.setStyle("-fx-background-color:pink;-fx-border-color:pink");
        Button no1 = new Button("1号床");
        Button no2 = new Button("2号床");
        Button no3 = new Button("3号床");
        Button no4 = new Button("4号床");
        p2map.add(yangtai,1,0);
        p2map.add(no1,0,1);
        p2map.add(no2,2,1);
        p2map.add(no3,0,2);
        p2map.add(no4,2,2);



//=======================================================================================================================
//=======================================================================================================================
        //查询界面pane3
        BorderPane pane3 = new BorderPane();
        pane3.setPadding(new Insets(20));
        HBox pane3title = new HBox(30);
        pane3title.setPadding(new Insets(30,0,30,0));
        pane3title.setAlignment(Pos.CENTER);
        Label p3title = new Label("查 询 系 统");
        p3title.setFont(fontBold);
        pane3title.getChildren().add(p3title);
        pane3.setTop(pane3title);
        HBox findH1 = new HBox(20);
        HBox findH2 = new HBox(20);
        VBox findV = new VBox(20);
        HBox findtext1 = new HBox(20);
        TextField findtf = new TextField();
        Button findbt = new Button("确认查询");
        findtext1.getChildren().addAll(findtf,findbt);
        ToggleGroup finds = new ToggleGroup();
        RadioButton stuIdFind = new RadioButton("按学号查询");
        stuIdFind.setToggleGroup(finds);
        RadioButton stuNameFind = new RadioButton("按姓名查询");
        stuNameFind.setToggleGroup(finds);
        RadioButton roomIdFind = new RadioButton("按寝室查询");
        roomIdFind.setToggleGroup(finds);
        RadioButton classFind = new RadioButton("按班级查询");
        classFind.setToggleGroup(finds);
        RadioButton departmentFind = new RadioButton("按系别查询");
        departmentFind.setToggleGroup(finds);
        findH1.getChildren().addAll(departmentFind,classFind,stuIdFind);
        findH2.getChildren().addAll(stuNameFind,roomIdFind);
        findV.getChildren().addAll(findH1,findH2,findtext1);
        pane3.setLeft(findV);


        TableColumn stuIdCol = new TableColumn("学号");
        TableColumn collegetCol = new TableColumn("学院");
        TableColumn departmentCol = new TableColumn("系别");
        TableColumn stuNameCol = new TableColumn("姓名");
        TableColumn classCol = new TableColumn("班级");
        TableColumn roomIdCol = new TableColumn("寝室");
        TableColumn bedIdCol = new TableColumn("床号");

        ObservableList<person> data = FXCollections.observableArrayList(
        );
        stuIdCol.setCellValueFactory(
                new PropertyValueFactory<>("stuId"));
        stuNameCol.setCellValueFactory(
                new PropertyValueFactory<>("stuName"));
        collegetCol.setCellValueFactory(
                new PropertyValueFactory<>("colleget"));
        departmentCol.setCellValueFactory(
                new PropertyValueFactory<>("department"));
        classCol.setCellValueFactory(
                new PropertyValueFactory<>("classId"));
        roomIdCol.setCellValueFactory(
                new PropertyValueFactory<>("roomId"));
        bedIdCol.setCellValueFactory(
                new PropertyValueFactory<>("bedId"));
        table.setItems(data);

        table.getColumns().addAll(stuIdCol,stuNameCol,collegetCol,departmentCol,classCol,roomIdCol,bedIdCol);
        pane3.setRight(table);

        Button pane3back = new Button("返回");
        pane3back.setFont(fontBold);
        HBox p3back = new HBox(30);
        p3back.setPadding(new Insets(20));
        p3back.setAlignment(Pos.CENTER);
        p3back.getChildren().add(pane3back);
        pane3.setBottom(p3back);


//=======================================================================================================================
//=======================================================================================================================
        //初始化
        Database.link();
        pane.setCenter(paneindex);
        Scene scene = new Scene(pane);
        primaryStage.setWidth(1000);
        primaryStage.setHeight(500);
        primaryStage.setTitle("寝室管理系统");
        primaryStage.setScene(scene);
        primaryStage.show();
//=======================================================================================================================
//=======================================================================================================================
        //操作
        //操作//登陆按钮paneindex->pane1
        login.setOnAction((ActionEvent) -> {
            try {
                if (check.checkpsw(tflogin.getText(),tfpsw.getText())) {
                    for(int k = 1 ; k <=3 ; k ++){
                        for(int l = 1 ; l <=10 ; l ++){
                            if(!check.checkfull(room[k][l].getText())) {
                                room[k][l].setStyle("-fx-background-color:yellow;-fx-border-color:white;-fx-border-width:3;-fx-border-length:3");
                            }
                            else{
                                room[k][l].setStyle("-fx-background-color:red;-fx-border-color:white;-fx-border-width:3;-fx-border-length:3");
                            }
                        }
                    }
                    pane.setCenter(pane1);
                }
                else{
                    new AlertBox().display("提示", "密码错误");
                    tflogin.clear();
                    tfpsw.clear();
                }
            }catch(Exception e1){
                e1.printStackTrace();
            }
            tflogin.clear();
            tfpsw.clear();
        });

//--------------------------------------------------------------------------------------------------------------------
        //操作//返回登陆界面
        relogin.setOnAction((ActionEvent) -> {
            pane.setCenter(paneindex);
            input.clear();
        });

//--------------------------------------------------------------------------------------------------------------------
        //操作//从pane3查询界面返回pane1房间选择画面
        pane3back.setOnAction((ActionEvent) ->{
            pane.setCenter(pane1);
        });

//--------------------------------------------------------------------------------------------------------------------
        //操作//查询按钮
        findbt.setOnAction((ActionEvent) -> {
            try {
                if (finds.getSelectedToggle() == stuIdFind) {
                    check.tablefind(data, "stuId", findtf.getText());
                }
                if (finds.getSelectedToggle() == stuNameFind) {
                    check.tablefind(data, "stuName", findtf.getText());
                }
                if (finds.getSelectedToggle() == departmentFind) {
                    check.tablefind(data, "department", findtf.getText());
                }
                if (finds.getSelectedToggle() == classFind) {
                    check.tablefind(data, "class", findtf.getText());
                }
                if (finds.getSelectedToggle() == roomIdFind) {
                    check.tablefind(data, "isCheckIn", findtf.getText());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });
//--------------------------------------------------------------------------------------------------------------------
        //操作//进入查找界面
        intofind.setOnAction((ActionEvent) -> {
            try {
                check.tableinitialize(data);
                pane.setCenter(pane3);
                for (int k = 1; k <= 3; k++) {
                    for (int l = 1; l <= 10; l++) {
                        if (!check.checkfull(room[k][l].getText())) {
                            room[k][l].setStyle("-fx-background-color:yellow;-fx-border-color:white;-fx-border-width:3;-fx-border-length:3");
                        } else {
                            room[k][l].setStyle("-fx-background-color:red;-fx-border-color:white;-fx-border-width:3;-fx-border-length:3");
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });

//--------------------------------------------------------------------------------------------------------------------
        //操作//pane1中点击房间按钮
        for(int i = 1 ; i <= 3 ; i ++){
            for(int j = 1 ; j <= 10 ; j ++){
                int a = i;
                int b = j;
                int name1 =i*100+j;
                room[i][j].setOnAction((ActionEvent)->{
                    try{
                        if(!check.checkfull(room[a][b].getText())) {
                            room[a][b].setStyle("-fx-background-color:yellow;-fx-border-color:black;-fx-border-width:3;-fx-border-length:3");
                        }
                        else{
                            room[a][b].setStyle("-fx-background-color:red;-fx-border-color:black;-fx-border-width:3;-fx-border-length:3");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    for(int k = 1 ; k <=3 ; k ++){
                        for(int l = 1 ; l <=10 ; l ++){
                            if(k != a || l != b){
                                try{
                                    if(!check.checkfull(room[k][l].getText())) {
                                        room[k][l].setStyle("-fx-background-color:yellow;-fx-border-color:white;-fx-border-width:3;-fx-border-length:3");
                                    }
                                    else{
                                        room[k][l].setStyle("-fx-background-color:red;-fx-border-color:white;-fx-border-width:3;-fx-border-length:3");
                                    }
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    input.setText(""+name1);
                });
            }
        }
//--------------------------------------------------------------------------------------------------------------------
        //操作//进入房间床位选择界面
        in.setOnAction((ActionEvent)->{
            if(input.getText().trim().isEmpty()){
                new AlertBox().display("提示", "请先选择寝室");
            }
            else{
                checkroomsum(input.getText(),no1,no2,no3,no4);
                P2roomID.setText(input.getText());
                pane.setCenter(pane2);
                try {
                    for (int k = 1; k <= 3; k++) {
                        for (int l = 1; l <= 10; l++) {
                            if (!check.checkfull(room[k][l].getText())) {
                                room[k][l].setStyle("-fx-background-color:yellow;-fx-border-color:white;-fx-border-width:3;-fx-border-length:3");
                            } else {
                                room[k][l].setStyle("-fx-background-color:red;-fx-border-color:white;-fx-border-width:3;-fx-border-length:3");
                            }
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            input.clear();
        });
//--------------------------------------------------------------------------------------------------------------------
        //操作//记录入住信息
        p2sure.setOnAction((ActionEvent) -> {
            try {
                if (Debug.stuinformationin(xuehaotf.getText(),xingmingtf.getText(),xueyuantf.getText(),xibietf.getText(),banjitf.getText())) {
                    check.register(P2roomID.getText(), xuehaotf.getText(), chuanghaotf.getText());
                    checkroomsum(P2roomID.getText(),no1,no2,no3,no4);
                } else {
                    new AlertBox().display("警告", "信息有误\n可能是该学生信息错误\n可能是该学生已入住");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            xingmingtf.clear();
            xuehaotf.clear();
            xueyuantf.clear();
            chuanghaotf.clear();
            banjitf.clear();
            xibietf.clear();
        });
//--------------------------------------------------------------------------------------------------------------------
        //操作//记录退房信息
        p2out.setOnAction((ActionEvent) -> {
            try {
                if (Debug.stuinformationout(xuehaotf.getText(),xingmingtf.getText(),xueyuantf.getText(),xibietf.getText(),banjitf.getText())) {
                    check.cancel(P2roomID.getText(), xuehaotf.getText(), chuanghaotf.getText());
                    checkroomsum(P2roomID.getText(),no1,no2,no3,no4);
                } else {
                    new AlertBox().display("警告", "信息有误\n可能是该学生信息错误\n可能是该学生已退房");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            xingmingtf.clear();
            xuehaotf.clear();
            xueyuantf.clear();
            chuanghaotf.clear();
            banjitf.clear();
            xibietf.clear();
        });

//--------------------------------------------------------------------------------------------------------------------
        //操作//重置密码按钮点击
        resetpsw.setOnAction((ActionEvent)->{
            try {
                new ResetPassword().display();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
//--------------------------------------------------------------------------------------------------------------------
        //操作//从pane2返回pane1
        p2back.setOnAction((ActionEvent)->{
            pane.setCenter(pane1);
            xingmingtf.clear();
            xuehaotf.clear();
            xueyuantf.clear();
            chuanghaotf.clear();
            banjitf.clear();
            xibietf.clear();
        });

    }
    public void checkroomsum(String input,Button no1,Button no2,Button no3,Button no4){
        try {
            if (check.checkroom(input, "bed1")) {
                no1.setStyle("-fx-background-color:yellow;-fx-border-color:yellow");
            } else {
                no1.setStyle("-fx-background-color:red;-fx-border-color:red");
            }
            if (check.checkroom(input, "bed2")) {
                no2.setStyle("-fx-background-color:yellow;-fx-border-color:yellow");
            } else {
                no2.setStyle("-fx-background-color:red;-fx-border-color:red");
            }
            if (check.checkroom(input, "bed3")) {
                no3.setStyle("-fx-background-color:yellow;-fx-border-color:yellow");
            } else {
                no3.setStyle("-fx-background-color:red;-fx-border-color:red");
            }
            if (check.checkroom(input, "bed4")) {
                no4.setStyle("-fx-background-color:yellow;-fx-border-color:yellow");
            } else {
                no4.setStyle("-fx-background-color:red;-fx-border-color:red");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        launch(args);
    }
}