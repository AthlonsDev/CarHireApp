import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import Models.Car;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainFX extends Application {

    List<String> carList = new ArrayList<>();
    Car selectedCar = new Car(null, null, null, null, null, null, null);
    VBox loginNav = new VBox();
    HBox topNav = new HBox();
    VBox leftNav = new VBox();
    VBox midNav = new VBox();
    VBox bottomNav = new VBox();

    private void authPage(StackPane root, VBox vBox) {
        
        Button loginBtn = new Button();
        Label mainTitle = new Label();
        TextField userField = new TextField();
        Label errLabel = new Label();
        errLabel.setTextFill(Color.RED);
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
            if (rc.registerCustomer(userField.getText(), passField.getText())) {
                System.out.println("Login Successful");
                vBox.getChildren().clear(); 
                startApp(root);
            } else {
                System.out.println("Login Failed Add red label");
                userField.setStyle("-fx-border-color: red");
                passField.setStyle("-fx-border-color: red");
                errLabel.setText("Login Failed");
            }           

        });

        userField.setMaxSize(200, 50);
        passField.setMaxSize(200, 50);
        loginBtn.setMaxSize(200, 50);
        mainTitle.setFont(new Font("Arial", 20));
        vBox.getChildren().add(mainTitle);
        vBox.getChildren().add(userField);
        vBox.getChildren().add(passField);
        vBox.getChildren().add(loginBtn);
        vBox.getChildren().add(errLabel);
        root.getChildren().add(vBox);

    }

    private void navBar(StackPane root, HBox HBox) {
        //add navbar to hbox
        Button logoutBtn = new Button();
        Label mainTitle = new Label();
        mainTitle.setText("Car Hire System");
        // logoutBtn.setText("Log Out");
        ImageView icon = new ImageView("logout.png");
        icon.setFitHeight(25);
        icon.setFitWidth(25);
        logoutBtn.setGraphic(icon);
        logoutBtn.setCursor(Cursor.HAND);
        logoutBtn.setOnAction(e -> {
            System.out.println("Logout");

            root.getChildren().clear();
            startLogin(root, loginNav);
        });

        mainTitle.setFont(new Font("Arial", 20));
        HBox.getChildren().addAll(logoutBtn, mainTitle);
        root.getChildren().add(HBox);
    }

    private Car carSelector(StackPane root, VBox HBox) {
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
            midNav.getChildren().clear();
            mainView(result, root);
        });

        HBox.getChildren().add(tableView);
        if(!(root.getChildren().contains(HBox)))
            root.getChildren().add(HBox);
        return selectedCar;
    }

    

    private void mainView(Car chosenCar, StackPane root) {
        midNav.getChildren().clear();
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

        yesBtn.setCursor(Cursor.HAND);
        noBtn.setCursor(Cursor.HAND);   
        one_week.setCursor(Cursor.HAND);
        two_weeks.setCursor(Cursor.HAND);
        three_weeks.setCursor(Cursor.HAND);
        four_weeks.setCursor(Cursor.HAND);
        submit_btn.setCursor(Cursor.HAND);

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
            HBox.getChildren().clear();
            midNav.getChildren().clear();
            welcomeMessage(root);
        });

        String priceString = chosenCar.getPrice();
        //cut the price string to just the number
        priceString = priceString.substring(2, priceString.indexOf("/"));
        //when reloading the $ seems to appear, so if it does this will take care of it
        if(priceString.contains("$")) {
            priceString = priceString.replace("$", "");
        }
        System.out.println("price: " + priceString);
        int carPrice = Integer.parseInt(priceString); //convert price to integer

        one_week.setText("1 Week");
        one_week.setOnAction(e -> {
            System.out.println("1 Week");
            HireCar hc = new HireCar();
            hc.hireCar(chosenCar, 7);
            HBox.getChildren().clear();
            bookingCar.setText("It Will be " + carPrice*7 + " Please Enter Your Card Number");
            HBox.getChildren().add(card_field);
            midNav.getChildren().add(submit_btn);
        });
        two_weeks.setText("2 Weeks");
        two_weeks.setOnAction(e -> {
            System.out.println("2 Weeks");
            HireCar hc = new HireCar();
            hc.hireCar(chosenCar, 14);
            HBox.getChildren().clear();
            bookingCar.setText("It Will be " + carPrice*14 + " Please Enter Your Card Number");
            HBox.getChildren().add(card_field);
            midNav.getChildren().add(submit_btn);
        });
        three_weeks.setText("3 Weeks");
        three_weeks.setOnAction(e -> {
            System.out.println("3 Weeks");
            HireCar hc = new HireCar();
            hc.hireCar(chosenCar, 21);
            HBox.getChildren().clear();
            bookingCar.setText("It Will be " + carPrice*21 + " Please Enter Your Card Number");
            HBox.getChildren().add(card_field);
            midNav.getChildren().add(submit_btn);
        });
        four_weeks.setText("4 Weeks");
        four_weeks.setOnAction(e -> {
            System.out.println("4 Weeks");
            HireCar hc = new HireCar();
            hc.hireCar(chosenCar, 28);
            HBox.getChildren().clear();
            bookingCar.setText("It Will be " + carPrice*28 + " Please Enter Your Card Number");
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
                addProgress(root, chosenCar); //add progress bar to simulate the payment process
                
            } else {
                System.out.println("Payment Failed");
            }
        });


        midNav.getChildren().add(mainTitle);
        midNav.getChildren().add(bookingCar);
        midNav.getChildren().add(HBox);
        HBox.getChildren().add(yesBtn);
        HBox.getChildren().add(noBtn);
        if(!(root.getChildren().contains(midNav)))
            root.getChildren().add(midNav);


    }   
    private void addProgress(StackPane root, Car chosenCar) {
        
        midNav.setTranslateY(-100);
        ProgressIndicator progressInd = new ProgressIndicator();
        // //add a delay
        Long delay = 2000L;
        Long period = 2000L; 

        TimerTask task = new TimerTask() {
            public void run() {
                progressInd.setVisible(false); //hide the progress bar
                Platform.runLater(() -> resultPage(root, chosenCar)); //run the result page after the delay
                // stop the timer 
                this.cancel();  //cancel the timer once it has run
            }
        };
    
        Timer timer = new Timer();
        timer.schedule(task, delay, period); //start timer and perform task
        midNav.getChildren().add(progressInd);
    }

    private Runnable resultPage(StackPane root, Car chosenCar) {
        showCars(); //update the car list
        bottomNav.getChildren().clear();
        carSelector(root, bottomNav); //update the tableview
        SearchCars sc = new SearchCars();
        Car updatedCar = sc.searchForCar(carList, chosenCar.getMake()); //get the updated car

        midNav.setTranslateY(-100);
        Button reloadButton = new Button();
        reloadButton.setText("Home");
        Label congrats = new Label();
        congrats.setText("Congratulations!");
        congrats.setFont(new Font("Arial", 40));
        Label result = new Label();
        result.setText("You have successfully booked a " + updatedCar.getMake()
         + " from" + updatedCar.getStartTime() + " to" + updatedCar.getEndTime());

        reloadButton.setOnAction(e -> {
            System.out.println("Home");
            midNav.getChildren().clear();
            welcomeMessage(root);
        });

        midNav.getChildren().add(congrats);
        midNav.getChildren().add(result);
        midNav.getChildren().add(reloadButton);
        if(!(root.getChildren().contains(midNav)))
            root.getChildren().add(midNav);
        return null;
    }

    private boolean enterPayment(int card) {        
        
        PaymentHandler ph = new PaymentHandler();
        
        if (!ph.handlePaymentRequest(card)) {
            return false;
        }
        return true;
    }

    private void welcomeMessage(StackPane root) {
        Label mainMessage = new Label();
        midNav.setTranslateY(-100);
        mainMessage.setText("Welcome to Car Hire"  + '\n' + "Please Select a Car from the list below");
        mainMessage.setTextAlignment(TextAlignment.CENTER);
        mainMessage.setFont(new Font("Arial", 20));
        midNav.getChildren().add(mainMessage);
        if(!(root.getChildren().contains(midNav)))
            root.getChildren().add(midNav);
    }

    private void startApp(StackPane root) {

        navBar(root, topNav);
        welcomeMessage(root);
        carSelector(root, bottomNav);
        
    }

    private void startLogin(StackPane root, VBox loginNav) {
        authPage(root, loginNav);
    }

    private void splashScreen(StackPane root) {
        Long delay = 2000L;
        Long period = 2000L; 

        ImageView image = new ImageView("Logo.png"); //show logo
        image.setFitWidth(250);
        image.setFitHeight(100);
        image.setTranslateY(-100);
        
        TimerTask task = new TimerTask() {
            public void run() {
                image.setVisible(false); //hide the Image
                Platform.runLater(() -> startLogin(root, loginNav)); //run the result page after the delay
                // stop the timer 
                this.cancel();  //cancel the timer once it has run
            }
        };
    
        Timer timer = new Timer();
        timer.schedule(task, delay, period); //start timer and perform task
        root.getChildren().add(image);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        StackPane root = new StackPane();

        // startLogin(root, loginNav);
        splashScreen(root);

        loginNav.setAlignment(javafx.geometry.Pos.CENTER);
        loginNav.setMaxHeight(220);        
        topNav.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        topNav.setSpacing(100);
        topNav.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        midNav.setAlignment(javafx.geometry.Pos.CENTER);
        midNav.setMaxHeight(220);
        topNav.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        bottomNav.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);
        bottomNav.setMaxHeight(250);
        bottomNav.setTranslateY(125);

        primaryStage.setTitle("Car Hire");
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
