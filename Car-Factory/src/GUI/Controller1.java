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
    @FXML
    public TextArea phase1Output;
    public TextField phase1Days;
    public TextField phase1Max;
    public Label pos1;
    public TextArea tempOutput2;
    public Button fBtn1;
    public Button wBtn1;
    public Button rBtn1;

    public void switchToPhase2(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase2.fxml"));
        root = loader.load();
        Controller2 controller = loader.getController();
        controller.phase2Days.setText(phase1Days.getText());
        controller.phase2Max.setText(phase1Max.getText());
        controller.phase2Output.setText(tempOutput2.getText());
        controller.tempOutput1.setText(phase1Output.getText());

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
    }

    public void runSimulation(ActionEvent event) throws IOException, CloneNotSupportedException {
        LocalDateTime simulationDate = LocalDateTime.now();
        phase1Output.setText("");
        try {
            days1 = Integer.parseInt(phase1Days.getText());
            max1 = Integer.parseInt(phase1Max.getText());
            if(days1 > 0 && max1 >0) {
                Main run = new Main(days1, max1);
                ArrayList<Warehouse> warehouses = run.getWarehouses();
                ArrayList<Factory> factories = run.getFactories();
                ArrayList<Request> requests = run.getRequests();

                // Generate Reports
                Report report = new Report(simulationDate, requests, factories, warehouses);
                report.generateReport();
                String mainOutputText = Report.getMainReport();
                String warehousesOutputText = Report.getWarehousesReport();
                String factoriesOutputText = Report.getFactoriesReport();
                String requestsOutputText = Report.getRequestsReport();
                String tableOutputText = Report.getTableReport();

                phase1Output.appendText(tableOutputText);
                tempFactoriesOutput = factoriesOutputText;
                tempWarehousesOutput = warehousesOutputText;
                tempRequestsOutput = requestsOutputText;
                pos1.setText(String.format("%s%.2f%s","Percentage Of Success: ", report.getPos(), "%"));
                fBtn1.setOpacity(1);
                wBtn1.setOpacity(1);
                rBtn1.setOpacity(1);
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

}