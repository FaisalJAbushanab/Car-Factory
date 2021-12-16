package GUI;

import carFactory.Main;
import carFactory.Report;
import carFactory.Request;
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
import java.util.ArrayList;

public class Controller {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private int days1;
	private int max1;
	public String tempText;
	@FXML
	public TextArea phase1Output;
	public TextField phase1Days;
	public TextField phase1Max;
	public Label pos1;
	public TextArea tempOutput2;
	
	@FXML
	public TextArea phase2Output;
	public TextField phase2Days;
	public TextField phase2Max;
	public TextArea tempOutput1;
	public Label tempPercentage1;
	
	public void switchToPhase1(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase1.fxml"));
		root = loader.load();
		Controller controller = loader.getController();
		controller.phase1Days.setText(phase2Days.getText());
		controller.phase1Max.setText(phase2Max.getText());
		controller.phase1Output.setText(tempOutput1.getText());
		controller.tempOutput2.setText(phase2Output.getText());
		
		controller.pos1.setText(tempPercentage1.getText());
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToPhase2(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase2.fxml"));
		root = loader.load();
		Controller controller = loader.getController();
		controller.phase2Days.setText(phase1Days.getText());
		controller.phase2Max.setText(phase1Max.getText());	
		controller.phase2Output.setText(tempOutput2.getText());
		controller.tempOutput1.setText(phase1Output.getText());
		
		controller.tempPercentage1.setText(pos1.getText());
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void resetSimulation(ActionEvent event) throws IOException {
		Button btn = (Button) event.getSource();
		String btnId = btn.getId();
		if(btnId.equals("reset1")) {
			phase1Output.setText("");
			pos1.setText("");
		}else {
			phase2Output.setText("");
		}
	}
	
	public void runSimulation(ActionEvent event) throws IOException {
	
		Button btn = (Button) event.getSource();
		String btnId = btn.getId();
		if(btnId.equals("run1")) {
			days1 = Integer.parseInt(phase1Days.getText());
			max1 = Integer.parseInt(phase1Max.getText());
			
			Main run = new Main(days1, max1);
			ArrayList<Request> requests = run.getRequests();
			
			// Generate Reports
			Report report = new Report();
			ArrayList<String> outputText = report.generateReport(requests);
			for(String output : outputText) {
				phase1Output.appendText(output + "\n");
			}
			pos1.setText(String.format("%s%.2f%s","Percentage Of Success: ", report.pos, "%"));
		}else {
			phase2Output.setText("");
		}
	}
	
}
