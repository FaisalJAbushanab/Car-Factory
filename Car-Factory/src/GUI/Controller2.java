package GUI;

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
import javafx.stage.StageStyle;
import phase2.Main;
import phase2.Report;
import phase2.*;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 * controller for phase 2
 */
public class Controller2 {
	private Stage stage;
	private Scene scene;
	private Parent root;

	private int days2;
	private int max2;
	private String tempText;
	private String tempFactoriesOutput;
	private String tempWarehousesOutput;
	private String tempRequestsOutput;
	private String tempPercentage1;
	private String tempOutput1;
	private String tempFactoriesOutput1;
	private String tempWarehousesOutput1;
	private String tempRequestsOutput1;
	private String tempTableOutput1;
	@FXML
	private TextArea phase2Output;
	private TextField phase2Days;
	private TextField phase2Max;
	private Label percentageOfSuccess2;
	private Button factoryButton2;
	private Button warehouseButton2;
	private Button requestButton2;
	private Button tableButton2;
	private String tempTableOutput;

	public Stage getStage() {
		return stage;
	}

	public Scene getScene() {
		return scene;
	}

	public Parent getRoot() {
		return root;
	}

	public int getDays2() {
		return days2;
	}

	public int getMax2() {
		return max2;
	}

	public String getTempText() {
		return tempText;
	}

	public String getTempFactoriesOutput() {
		return tempFactoriesOutput;
	}

	public String getTempWarehousesOutput() {
		return tempWarehousesOutput;
	}

	public String getTempRequestsOutput() {
		return tempRequestsOutput;
	}

	public String getTempPercentage1() {
		return tempPercentage1;
	}

	public String getTempOutput1() {
		return tempOutput1;
	}

	public String getTempFactoriesOutput1() {
		return tempFactoriesOutput1;
	}

	public String getTempWarehousesOutput1() {
		return tempWarehousesOutput1;
	}

	public String getTempRequestsOutput1() {
		return tempRequestsOutput1;
	}

	public String getTempTableOutput1() {
		return tempTableOutput1;
	}

	public TextArea getPhase2Output() {
		return phase2Output;
	}

	public TextField getPhase2Days() {
		return phase2Days;
	}

	public TextField getPhase2Max() {
		return phase2Max;
	}

	public Label getPercentageOfSuccess2() {
		return percentageOfSuccess2;
	}

	public Button getFactoryButton2() {
		return factoryButton2;
	}

	public Button getWarehouseButton2() {
		return warehouseButton2;
	}

	public Button getRequestButton2() {
		return requestButton2;
	}

	public Button getTableButton2() {
		return tableButton2;
	}

	public String getTempTableOutput() {
		return tempTableOutput;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public void setRoot(Parent root) {
		this.root = root;
	}

	public void setDays2(int days2) {
		this.days2 = days2;
	}

	public void setMax2(int max2) {
		this.max2 = max2;
	}

	public void setTempText(String tempText) {
		this.tempText = tempText;
	}

	public void setTempFactoriesOutput(String tempFactoriesOutput) {
		this.tempFactoriesOutput = tempFactoriesOutput;
	}

	public void setTempWarehousesOutput(String tempWarehousesOutput) {
		this.tempWarehousesOutput = tempWarehousesOutput;
	}

	public void setTempRequestsOutput(String tempRequestsOutput) {
		this.tempRequestsOutput = tempRequestsOutput;
	}

	public void setTempPercentage1(String tempPercentage1) {
		this.tempPercentage1 = tempPercentage1;
	}

	public void setTempOutput1(String tempOutput1) {
		this.tempOutput1 = tempOutput1;
	}

	public void setTempFactoriesOutput1(String tempFactoriesOutput1) {
		this.tempFactoriesOutput1 = tempFactoriesOutput1;
	}

	public void setTempWarehousesOutput1(String tempWarehousesOutput1) {
		this.tempWarehousesOutput1 = tempWarehousesOutput1;
	}

	public void setTempRequestsOutput1(String tempRequestsOutput1) {
		this.tempRequestsOutput1 = tempRequestsOutput1;
	}

	public void setTempTableOutput1(String tempTableOutput1) {
		this.tempTableOutput1 = tempTableOutput1;
	}

	public void setPhase2Output(TextArea phase2Output) {
		this.phase2Output = phase2Output;
	}

	public void setPhase2Days(TextField phase2Days) {
		this.phase2Days = phase2Days;
	}

	public void setPhase2Max(TextField phase2Max) {
		this.phase2Max = phase2Max;
	}

	public void setPercentageOfSuccess2(Label percentageOfSuccess2) {
		this.percentageOfSuccess2 = percentageOfSuccess2;
	}

	public void setFactoryButton2(Button factoryButton2) {
		this.factoryButton2 = factoryButton2;
	}

	public void setWarehouseButton2(Button warehouseButton2) {
		this.warehouseButton2 = warehouseButton2;
	}

	public void setRequestButton2(Button requestButton2) {
		this.requestButton2 = requestButton2;
	}

	public void setTableButton2(Button tableButton2) {
		this.tableButton2 = tableButton2;
	}

	public void setTempTableOutput(String tempTableOutput) {
		this.tempTableOutput = tempTableOutput;
	}

	/**
	 * switches to phase 1
	 */
	public void switchToPhase1(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase1.fxml"));
		root = loader.load();
		Controller1 controller = loader.getController();
		controller.phase1Days.setText(phase2Days.getText());
		controller.phase1Max.setText(phase2Max.getText());
		controller.phase1Output.setText(tempOutput1);
		controller.pos1.setText(tempPercentage1);
		controller.tempOutput2.setText(phase2Output.getText());
		controller.tempPercentage2 = percentageOfSuccess2.getText();
		
		controller.tempFactoriesOutput2 = tempFactoriesOutput;
        controller.tempWarehousesOutput2 = tempWarehousesOutput;
        controller.tempRequestsOutput2 = tempRequestsOutput;
        controller.tempTableOutput2 = tempTableOutput;
		
		if(controller.phase1Output.getText() != "") {
			controller.fBtn1.setOpacity(1);
            controller.wBtn1.setOpacity(1);
            controller.rBtn1.setOpacity(1);
            controller.tBtn1.setOpacity(1);
            
            controller.tempFactoriesOutput = tempFactoriesOutput1;
            controller.tempWarehousesOutput = tempWarehousesOutput1;
            controller.tempRequestsOutput = tempRequestsOutput1;
            controller.tempTableOutput = tempTableOutput1;
		}

		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	/**
	 * resets simulation
	 */
	public void resetSimulation(ActionEvent event) throws IOException {
		phase2Output.setText("");
		percentageOfSuccess2.setText("");
		factoryButton2.setOpacity(0);
		warehouseButton2.setOpacity(0);
		requestButton2.setOpacity(0);
		tableButton2.setOpacity(0);
	}
	/**
	 * runs simulation
	 */
	public void runSimulation(ActionEvent event) throws IOException, CloneNotSupportedException {
		LocalDateTime simulationDate = LocalDateTime.now();
		try {
			days2 = Integer.parseInt(phase2Days.getText());
			max2 = Integer.parseInt(phase2Max.getText());
		
		if(days2 > 0 && max2 >0) {
			phase2Output.setText("");
			Main run = new Main(days2, max2);
			ArrayList<Warehouse> warehouses = run.getWarehouses();
			ArrayList<Factory> factories = run.getFactories();
			ArrayList<Request> requests = run.getRequests();
	
			// Generate Reports
			Report report = new Report(simulationDate, requests, factories, warehouses);
			report.generateReport();
			String mainOutputText = report.getMainReport();
			String warehousesOutputText = report.getWarehousesReport();
			String factoriesOutputText = report.getFactoriesReport();
			String requestsoutputText = report.getRequestsReport();
			String tableOutputText = report.getTableReport();
	
			phase2Output.appendText(mainOutputText);
			tempFactoriesOutput = factoriesOutputText;
			tempWarehousesOutput = warehousesOutputText;
			tempRequestsOutput = requestsoutputText;
			tempTableOutput = tableOutputText;
			percentageOfSuccess2.setText(String.format("%s%.2f%s","Percentage Of Success: ", report.getPos(), "%"));
			factoryButton2.setOpacity(1);
			warehouseButton2.setOpacity(1);
			requestButton2.setOpacity(1);
			tableButton2.setOpacity(1);
		}else {
            popUpError(event);
        }
    } catch(NumberFormatException e){
        popUpError(event);
    }
	}
	/**
	 *button for factories report
	 */
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
	/**
	 *button for warehouses report
	 */
	public void popUpWarehouses(ActionEvent event) throws IOException {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Warehouses.fxml"));
			root = loader.load();
			Controller controller = loader.getController();
			controller.warehousesOutput.setText(tempWarehousesOutput);
			Stage stage = new Stage();
			stage.setTitle("Warehouses info");
			stage.setScene(new Scene(root));

			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 *button for requests report
	 */
	public void popUpRequests(ActionEvent event) throws IOException {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Requests.fxml"));
			root = loader.load();
			Controller controller = loader.getController();
			controller.requestsOutput.setText(tempRequestsOutput);
			Stage stage = new Stage();
			stage.setTitle("Requests info");
			stage.setScene(new Scene(root));

			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 *button for table view
	 */
	public void popUpTable(ActionEvent event) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Table.fxml"));
            root = loader.load();
            Controller controller = loader.getController();
            controller.tableOutput.setText(tempTableOutput);
            Stage stage = new Stage();
            stage.setTitle("Table View");
            stage.setScene(new Scene(root));

            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
	/**
	 * pop up in case of Error
	 */
	public void popUpError(ActionEvent event) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Error.fxml"));
            root = loader.load();
            Controller controller = loader.getController();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Error");
            stage.setScene(new Scene(root));

            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
	/**
	 *link for our JAVADOC
	 */
	public void openLink(ActionEvent event) throws URISyntaxException, IOException {
    	Desktop.getDesktop().browse(new URI("https://faisaljabushanab.github.io/javadoc/"));
    }


}