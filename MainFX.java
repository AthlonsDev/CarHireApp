import java.util.ArrayList;
import java.util.List;

import Models.Car;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;


public class MainFX extends Application {

    List<String> carList = new ArrayList<>();

    
    private void authPage(Pane root) {

        Button loginBtn = new Button();
        Label mainTitle = new Label();
        TextField userField = new TextField();
        userField.setPromptText("Enter Username");
        userField.setOnMouseClicked(e -> {            
            userField.setText(userField.getText().toString());
        });
        TextField passField = new TextField();
        passField.setPromptText("Enter Password");
        passField.setOnMouseClicked(e -> {
            passField.setText(passField.getText().toString());
        });
        
        mainTitle.setText("Car Hire System");
        loginBtn.setText("Log In");
        loginBtn.setOnAction(e -> {
            System.out.println("Username: " + userField.getText());
            System.out.println("password: " + passField.getText());

            RegisterCustomer rc = new RegisterCustomer(null, null);
            if (rc.registerCustomer(userField.getText(), passField.getText()))
                root.getChildren().clear();                

        });
        userField.setMaxSize(200, 50);
        passField.setMaxSize(200, 50);
        loginBtn.setMaxSize(200, 50);
        mainTitle.setFont(new Font("Arial", 20));
        mainTitle.setLayoutX(75);
        loginBtn.setLayoutX(100);
        userField.setLayoutX(100);
        passField.setLayoutX(100);
        root.getChildren().add(mainTitle);
        root.getChildren().add(userField);
        root.getChildren().add(passField);
        root.getChildren().add(loginBtn);

    }

    private void navBar(HBox HBox) {
        //add navbar to hbox
        Button homeBtn = new Button();
        Button logoutBtn = new Button();
        Label mainTitle = new Label();
        mainTitle.setText("Car Hire System");
        homeBtn.setText("Logo");
        logoutBtn.setText("Log Out");
        logoutBtn.setOnAction(e -> {
            System.out.println("Logout");
        });
        mainTitle.setFont(new Font("Arial", 20));

        HBox.getChildren().add(homeBtn);
        HBox.getChildren().add(mainTitle);
        HBox.getChildren().add(logoutBtn);
    }

    private void carSelector(VBox VBox) {
        //create tableview with cars data
        //add to vbox
        // showCars();
        // Car cars = new Car(null, null, null, null, null, null, null);
        TableView tableView = new TableView();

        TableColumn<String, String> column1 = 
        new TableColumn<>("Car");
        
        column1.setCellValueFactory(
            new PropertyValueFactory<>("Make"));
        
        tableView.getColumns().add(column1);
        //set Car object as tableview items 
        //iterate through carList and add to tableview        

        tableView.getItems().add(new Car("Ford", "Focus", "2018", "1.6", "Pet", "1.5", "true"));
        tableView.getItems().add(new Car("Ford", "Focus", "2018", "1.6", "Pet", "1.5", "true"));
        tableView.getItems().add(new Car("Ford", "Focus", "2018", "1.6", "Pet", "1.5", "true"));


        VBox.getChildren().add(tableView);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();

        //set up Hbox and VBox
        HBox topNav = new HBox();
        VBox centerScene = new VBox();
        VBox leftNav = new VBox();

        root.setTop(topNav);
        root.setCenter(centerScene);
        root.setLeft(leftNav);

        //center vbox at center of scene
        centerScene.setTranslateX(150);
        centerScene.setTranslateY(100);
        
        topNav.setAlignment(javafx.geometry.Pos.CENTER);
        topNav.setSpacing(100);
        topNav.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));


        primaryStage.setTitle("Car Hire");

        //Set Authentication Screen
        // authPage(centerScene);
        // navBar(topNav);
        carSelector(leftNav);
        
        primaryStage.setScene(new Scene(root, 500, 500, false, null));
        primaryStage.show();


    }

    private List<String> showCars() {
        // get a list of all cars
        CarList cl = new CarList();
        carList = cl.showCars();

        for (String car : carList) {
            System.out.println(car);
        }
        return carList;
    }

    public static void main(String[] args) {
        // create list of cars
        CarList car = new CarList();
        car.startCarList();
        launch(args);
    }
}
