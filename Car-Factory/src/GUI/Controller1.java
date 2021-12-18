package GUI;

import phase1.*;
import phase1.Main;
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

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller1 {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private int days1;
    private int max1;
    public String tempText;
    public String tempFactoriesOutput;
    public String tempWarehousesOutput;
    public String tempRequestsOutput;
    public String tempTableOutput;
    public String tempPercentage2;
    public String tempFactoriesOutput2;
	public String tempWarehousesOutput2;
	public String tempRequestsOutput2;
	public String tempTableOutput2;
    @FXML
    public TextArea phase1Output;
    public TextField phase1Days;
    public TextField phase1Max;
    public Label pos1;
    public TextArea tempOutput2;
    public Button fBtn1;
    public Button wBtn1;
    public Button rBtn1;
    public Button tBtn1;
    

    public void switchToPhase2(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase2.fxml"));
        root = loader.load();
        Controller2 controller = loader.getController();
        controller.phase2Days.setText(phase1Days.getText());
        controller.phase2Max.setText(phase1Max.getText());
        controller.phase2Output.setText(tempOutput2.getText());
        controller.pos2.setText(tempPercentage2);
        
        controller.tempOutput1 = phase1Output.getText();
        controller.tempFactoriesOutput1 = tempFactoriesOutput;
        controller.tempWarehousesOutput1 = tempWarehousesOutput;
        controller.tempRequestsOutput1 = tempRequestsOutput;
        controller.tempTableOutput1 = tempTableOutput;
        
        if(controller.phase2Output.getText() != "") {
			controller.fBtn2.setOpacity(1);
            controller.wBtn2.setOpacity(1);
            controller.rBtn2.setOpacity(1);
            controller.tBtn2.setOpacity(1);
            
            controller.tempFactoriesOutput = tempFactoriesOutput2;
            controller.tempWarehousesOutput = tempWarehousesOutput2;
            controller.tempRequestsOutput = tempRequestsOutput2;
            controller.tempTableOutput = tempTableOutput2;
		}

        controller.tempPercentage1 = pos1.getText();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void resetSimulation(ActionEvent event) throws IOException {
        phase1Output.setText("");
        pos1.setText("");
        fBtn1.setOpacity(0);
        wBtn1.setOpacity(0);
        rBtn1.setOpacity(0);
        tBtn1.setOpacity(0);
    }

    public void runSimulation(ActionEvent event) throws IOException, CloneNotSupportedException {
        LocalDateTime simulationDate = LocalDateTime.now();
        try {
            days1 = Integer.parseInt(phase1Days.getText());
            max1 = Integer.parseInt(phase1Max.getText());
            if(days1 > 0 && max1 >0) {
                phase1Output.setText("");
                Main run = new Main(days1, max1);
                ArrayList<Warehouse> warehouses = run.getWarehouses();
                ArrayList<Factory> factories = run.getFactories();
                ArrayList<Request> requests = run.getRequests();

                // Generate Reports
                Report report = run.getReport();
                String mainOutputText = report.getMainReport();
                String warehousesOutputText = report.getWarehousesReport();
                String factoriesOutputText = report.getFactoriesReport();
                String requestsOutputText = report.getRequestsReport();
                String tableOutputText = report.getTableReport();

                phase1Output.appendText(mainOutputText);
                tempFactoriesOutput = factoriesOutputText;
                tempWarehousesOutput = warehousesOutputText;
                tempRequestsOutput = requestsOutputText;
                tempTableOutput = tableOutputText;
                pos1.setText(String.format("%s%.2f%s","Percentage Of Success: ", report.getPos(), "%"));
                fBtn1.setOpacity(1);
                wBtn1.setOpacity(1);
                rBtn1.setOpacity(1);
                tBtn1.setOpacity(1);
            }else {
                popUpError(event);
            }
        } catch(NumberFormatException e){
            popUpError(event);
        }

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

}