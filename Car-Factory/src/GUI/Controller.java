package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Controller {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private int days1;
	private int max1;
	public String tempText;
	@FXML
	public TextArea factoriesOutput;
	public TextArea warehousesOutput;
	public TextArea requestsOutput;
	public TextArea tableOutput;
	public Button close;
	
	public void closeWindow(ActionEvent event) {
		Stage stage = (Stage) close.getScene().getWindow();
	    stage.close();
	}
}
