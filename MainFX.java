import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
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


public class MainFX extends Application {
    
    


    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();

        primaryStage.setTitle("Car Hire");
        Button loginBtn = new Button();
        Label mainTitle = new Label();
        TextField userField = new TextField();
        userField.setPromptText("Enter Username");
        userField.setOnMouseClicked(e -> {
            // userField.setText("new text");
        });
        TextField passField = new TextField();
        passField.setPromptText("Enter Password");
        passField.setOnMouseClicked(e -> {
            // passField.setText("new text");
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
        mainTitle.setLayoutX(200);
        mainTitle.setLayoutY(50);
        userField.setLayoutX(175);
        userField.setLayoutY(100);
        passField.setLayoutX(175);
        passField.setLayoutY(135);
        loginBtn.setLayoutX(210);
        loginBtn.setLayoutY(175);
        root.getChildren().add(mainTitle);
        root.getChildren().add(loginBtn);
        root.getChildren().add(userField);
        root.getChildren().add(passField);
        
        primaryStage.setScene(new Scene(root, 500, 500, false, null));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
