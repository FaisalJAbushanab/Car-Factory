package GUI;

import phase2.*;
import phase2.Main;
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

public class Controller2 {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private int days2;
	private int max2;
	public String tempText;
	public String tempFactoriesOutput;
	public String tempWarehousesOutput;
	public String tempRequestsOutput;
	public String tempPercentage1;
	@FXML
	public TextArea phase2Output;
	public TextField phase2Days;
	public TextField phase2Max;
	public Label pos2;
	public TextArea tempOutput1;
	public Button fBtn2;
	public Button wBtn2;
	public Button rBtn2;
	
	public void switchToPhase1(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase1.fxml"));
		root = loader.load();
		Controller1 controller = loader.getController();
		controller.phase1Days.setText(phase2Days.getText());
		controller.phase1Max.setText(phase2Max.getText());	
		controller.phase1Output.setText(tempOutput1.getText());
		controller.tempOutput2.setText(phase2Output.getText());
		
//		controller.tempPercentage2.setText(pos1.getText());
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void resetSimulation(ActionEvent event) throws IOException {
			phase2Output.setText("");
			pos2.setText("");
			fBtn2.setOpacity(0);
			wBtn2.setOpacity(0);
			rBtn2.setOpacity(0);
	}
	
	public void runSimulation(ActionEvent event) throws IOException, CloneNotSupportedException {
		LocalDateTime simulationDate = LocalDateTime.now();
		phase2Output.setText("");
		days2 = Integer.parseInt(phase2Days.getText());
		max2 = Integer.parseInt(phase2Max.getText());
		
		Main run = new Main(days2, max2);
		ArrayList<Warehouse> warehouses = run.getWarehouses();
		ArrayList<Factory> factories = run.getFactories();
		ArrayList<Request> requests = run.getRequests();

		// Generate Reports
		Report report = new Report(simulationDate, requests, factories, warehouses);
		report.generateReport();
		String mainOutputText = Report.getMainReport();
		//TODO here are other reports
		String warehousesOutputText = Report.getWarehousesReport();
		String factoriesOutputText = Report.getFactoriesReport();
		String requestsoutputText = Report.getRequestsReport();

		phase2Output.appendText(mainOutputText);
	    tempFactoriesOutput = factoriesOutputText;
	    tempWarehousesOutput = warehousesOutputText;
	    tempRequestsOutput = requestsoutputText;
		pos2.setText(String.format("%s%.2f%s","Percentage Of Success: ", report.getPos(), "%"));
		fBtn2.setOpacity(1);
		wBtn2.setOpacity(1);
		rBtn2.setOpacity(1);
	}
	
	public void popUpFactories(ActionEvent event) throws IOException {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Factories.fxml"));
			root = loader.load();
		    Controller controller = loader.getController();
		    controller.factoriesOutput.setText(tempFactoriesOutput);
		    Stage stage = new Stage();
		    stage.setTitle("Factories info");
		    stage.setScene(new Scene(root));  
		    
		    stage.show();
		} catch(Exception e) {
	        e.printStackTrace();
	    }
		
	}
public void popUpWarehouses(ActionEvent event) throws IOException {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Warehouses.fxml"));
			root = loader.load();
		    Controller controller = loader.getController();
		    controller.warehousesOutput.setText(tempWarehousesOutput);
		    Stage stage = new Stage();
		    stage.setTitle("Factories info");
		    stage.setScene(new Scene(root));  
		    
		    stage.show();
		} catch(Exception e) {
	        e.printStackTrace();
	    }
		
	}
public void popUpRequests(ActionEvent event) throws IOException {
	
	try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Requests.fxml"));
		root = loader.load();
	    Controller controller = loader.getController();
	    controller.requestsOutput.setText(tempRequestsOutput);
	    Stage stage = new Stage();
	    stage.setTitle("Factories info");
	    stage.setScene(new Scene(root));  
	    
	    stage.show();
	} catch(Exception e) {
        e.printStackTrace();
    }
	
}
	
}
