import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.RootPaneContainer;

import Models.Car;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
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
    Car selectedCar = new Car(null, null, null, null, null, null, null);
    HBox topNav = new HBox();
        VBox leftNav = new VBox();
        VBox midNav = new VBox();
        VBox bottomNav = new VBox();

    private void authPage(Pane root, VBox vBox) {

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
        vBox.getChildren().add(mainTitle);
        vBox.getChildren().add(userField);
        vBox.getChildren().add(passField);
        vBox.getChildren().add(loginBtn);
        root.getChildren().add(vBox);

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

    private Car carSelector(StackPane root, VBox HBox) {
        //create tableview with cars data
        //add to vbox
        showCars();

        TableView tableView = new TableView();
        TableColumn<String, String> column1 = 
        new TableColumn<>("Cars");
        
        column1.setCellValueFactory(
            new PropertyValueFactory<>("Make"));
        
        tableView.getColumns().add(column1);
        //set Car object as tableview items 
        //iterate through carList and add to tableview   
        for (int i = 0; i < carList.size(); i++) {
            tableView.getItems().add(new Car(carList.get(i), 
            null, null, null, null, null, null));
        }     

        //set size of tableview
        tableView.setMaxSize(600, 200);
        tableView.setMinSize(300, 200);

        //if cell is selected
        tableView.setOnMouseClicked(e -> {
            //get selected cell
            selectedCar = (Car) tableView.getSelectionModel().getSelectedItem();
            System.out.println(selectedCar.getMake());
            //create new car object with selected car
            SearchCars sc = new SearchCars();
            //cut selectedcar at the first comma
            String[] splitCar = selectedCar.getMake().split(",");
            selectedCar.setMake(splitCar[0]);
            //search for car in database
            Car result = sc.searchForCar(carList, selectedCar.getMake());
            centerNav(root, result);
        });

        HBox.getChildren().add(tableView);
        root.getChildren().add(HBox);
        return selectedCar;
    }

    

    private void mainView(VBox vBox, Car chosenCar, StackPane root) {
        //put midNav higher up
        midNav.setTranslateY(-100);
        HBox HBox = new HBox();
        HBox.setAlignment(javafx.geometry.Pos.CENTER);
        Label mainTitle = new Label();
        mainTitle.setText("Welcome to Car Hire System");
        mainTitle.setFont(new Font("Arial", 20));

        Label bookingCar = new Label();
        bookingCar.setText("Would you like to Book This " + chosenCar.getMake() + "?");
        bookingCar.setFont(new Font("Arial", 20));

        Label bookingTime = new Label();
        bookingTime.setText("How many Days Would you Like to Book this Car For?");
        bookingTime.setFont(new Font("Arial", 20));



        Button yesBtn = new Button();
        Button noBtn = new Button();
        Button one_week = new Button();
        Button two_weeks = new Button();
        Button three_weeks = new Button();
        Button four_weeks = new Button();
        TextField card_field = new TextField();
        Button submit_btn = new Button();

        yesBtn.setText("Yes");
        yesBtn.setOnAction(e -> {
            System.out.println("Yes");
            bookingCar.setText("How many Days Would you Like to Book this Car For?");
            HBox.getChildren().clear();
            HBox.getChildren().add(one_week);
            HBox.getChildren().add(two_weeks);
            HBox.getChildren().add(three_weeks);
            HBox.getChildren().add(four_weeks);
        });

        noBtn.setText("No");
        noBtn.setOnAction(e -> {
            System.out.println("No");
        });

        one_week.setText("1 Week");
        one_week.setOnAction(e -> {
            System.out.println("1 Week");
            HireCar hc = new HireCar();
            hc.hireCar(chosenCar, 7);
            HBox.getChildren().clear();
            HBox.getChildren().add(card_field);
            midNav.getChildren().add(submit_btn);
        });
        two_weeks.setText("2 Weeks");
        two_weeks.setOnAction(e -> {
            System.out.println("2 Weeks");
            HireCar hc = new HireCar();
            hc.hireCar(chosenCar, 14);
            HBox.getChildren().clear();
            HBox.getChildren().add(card_field);
            midNav.getChildren().add(submit_btn);
        });
        three_weeks.setText("3 Weeks");
        three_weeks.setOnAction(e -> {
            System.out.println("3 Weeks");
            HireCar hc = new HireCar();
            hc.hireCar(chosenCar, 21);
            HBox.getChildren().clear();
            HBox.getChildren().add(card_field);
            midNav.getChildren().add(submit_btn);
        });
        four_weeks.setText("4 Weeks");
        four_weeks.setOnAction(e -> {
            System.out.println("4 Weeks");
            HireCar hc = new HireCar();
            hc.hireCar(chosenCar, 28);
            HBox.getChildren().clear();
            HBox.getChildren().add(card_field);
            midNav.getChildren().add(submit_btn);
        });

        card_field.setPromptText("Enter Card Number");
        card_field.setMaxWidth(200);
        card_field.setOnMouseClicked(e -> {
            card_field.setText(card_field.getText());

        });

        submit_btn.setText("Submit");
        submit_btn.setOnAction(e -> {
            System.out.println("Submit");
            int card_number = Integer.parseInt(card_field.getText());
            if (enterPayment(card_number)) {
                System.out.println("Payment Successful");
                midNav.getChildren().clear();
                if (addProgress(root))
                    resultPage(root, chosenCar);
            } else {
                System.out.println("Payment Failed");
            }
        });


        midNav.getChildren().add(mainTitle);
        midNav.getChildren().add(bookingCar);
        midNav.getChildren().add(HBox);
        HBox.getChildren().add(yesBtn);
        HBox.getChildren().add(noBtn);
        root.getChildren().add(midNav);


    }   

    private boolean addProgress(StackPane root) {
        
        midNav.setTranslateY(-100);
        ProgressIndicator progressInd = new ProgressIndicator();
        // //add a delay 
        Long delay = 500L;
        Long period = 500L; 
        //increase progress every 0.5 seconds
        TimerTask task = new TimerTask() {
            double progress = 0;
            @Override //override run method
            public void run() { 
                if(progressInd.getProgress() >= 1) {
                    cancel();
                    progressInd.setVisible(false);
                    
                }
                progress += 0.1; //increase progress by 10%
                Platform.runLater(() -> { //update JavaFX thread
                    progress += 0.2; 
                    System.out.println("Progress: " + progressInd.getProgress());
                    progressInd.setProgress(progress); //update progress indicator 
                });
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, delay, period); //start timer and perform task

        //move progressInd to center of the scene
        progressInd.setLayoutY((root.getHeight() - progressInd.getHeight()) / 2);
        progressInd.setLayoutX((root.getWidth() - progressInd.getWidth()) / 2);

        midNav.getChildren().add(progressInd);

        if (progressInd.getProgress() >= 1.0) {
            return true;
        } else {
            System.out.println("Progress Incomplete");
            return false;
        }

    }

    private void resultPage(StackPane root, Car chosenCar ) {
        showCars();
        SearchCars sc = new SearchCars();
        Car updatedCar = sc.searchForCar(carList, chosenCar.getMake());

        midNav.setTranslateY(-100);
        Label congrats = new Label();
        congrats.setText("Congratulations!");
        congrats.setFont(new Font("Arial", 40));
        Label result = new Label();
        result.setText("You have successfully booked a " + updatedCar.getMake()
         + " from" + updatedCar.getStartTime() + " to" + updatedCar.getEndTime());

        midNav.getChildren().add(congrats);
        midNav.getChildren().add(result);

        root.getChildren().add(midNav);
    }

    private boolean enterPayment(int card) {        
        
        PaymentHandler ph = new PaymentHandler();
        
        if (!ph.handlePaymentRequest(card)) {
            return false;
        }
        return true;
    }

    private void centerNav(StackPane root, Car chosenCar) {
        VBox centerScene = new VBox();
        root.getChildren().add(centerScene);
        centerScene.setTranslateX(150);
        centerScene.setTranslateY(100);
        mainView(centerScene, chosenCar, root);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        StackPane root = new StackPane();

        //set up Hbox and VBox
        
        // HBox bottomNav = new HBox();

        root.getChildren().add(topNav);
        root.getChildren().add(leftNav);

        //center vbox at center of scene

        
        topNav.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        topNav.setSpacing(130);
        topNav.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        midNav.setAlignment(javafx.geometry.Pos.CENTER);
        bottomNav.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);

        primaryStage.setTitle("Car Hire");

        //Set Authentication Screen
        // authPage(centerScene);

        
        navBar(topNav);
        carSelector(root, bottomNav);
        // authPage(root, midNav);

        
        primaryStage.setScene(new Scene(root, 500, 500, false, null));
        primaryStage.show();


    }

    private ObservableList<List<String>> showCars() {
       //create observable list of cars
       CarList cl = new CarList();
       carList = cl.showCars();
       ObservableList<List<String>> cars = FXCollections.observableArrayList();
        cars.add(carList);

        for (List<String> car : cars) {
            System.out.println(car);
        }

         return cars;

    }

    public static void main(String[] args) {
        // create list of cars
        CarList car = new CarList();
        car.startCarList();
        launch(args);
    }
}
