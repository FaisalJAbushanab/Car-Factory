package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class RunGUI extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Phase1.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.getIcons().add(new Image("icon.png"));
			stage.setTitle("Computer Factory Simulator");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}  
}
