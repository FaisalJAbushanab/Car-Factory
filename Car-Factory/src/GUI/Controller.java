package GUI;

import carFactory.*;
import carFactory.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
	
	
}
