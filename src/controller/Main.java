package controller;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public static Stage mainStage;
    @Override
    public void start(Stage primaryStage) throws IOException {
	mainStage = primaryStage;
	Parent root = FXMLLoader.load(getClass().getResource("/Interface/Login.fxml"));
	Scene scene = new Scene(root, 650, 450);
	
	primaryStage.setTitle("Login");
	primaryStage.setScene(scene);
	primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	launch(args);
    }
    
    public static Stage getStage(){
	return mainStage;
    }
}
