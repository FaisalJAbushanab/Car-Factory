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
import phase1.Main;
import phase1.Report;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
/**
 * controller for phase 1
 */
public class Controller1 {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private int days1;
    private int max1;
    private String tempText;
    private String tempFactoriesOutput;
    private String tempWarehousesOutput;
    private String tempRequestsOutput;
    private String tempTableOutput;
    private String tempPercentage2;
    private String tempFactoriesOutput2;

    public Stage getStage() {
        return stage;
    }

    public Scene getScene() {
        return scene;
    }

    public Parent getRoot() {
        return root;
    }

    public int getDays1() {
        return days1;
    }

    public int getMax1() {
        return max1;
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

    public String getTempTableOutput() {
        return tempTableOutput;
    }

    public String getTempPercentage2() {
        return tempPercentage2;
    }

    public String getTempFactoriesOutput2() {
        return tempFactoriesOutput2;
    }

    public String getTempWarehousesOutput2() {
        return tempWarehousesOutput2;
    }

    public String getTempRequestsOutput2() {
        return tempRequestsOutput2;
    }

    public String getTempTableOutput2() {
        return tempTableOutput2;
    }

    public TextArea getPhase1Output() {
        return phase1Output;
    }

    public TextField getPhase1Days() {
        return phase1Days;
    }

    public TextField getPhase1Max() {
        return phase1Max;
    }

    public Label getPercentageOfSuccess1() {
        return percentageOfSuccess1;
    }

    public TextArea getTempOutput2() {
        return tempOutput2;
    }

    public Button getFactoryButton1() {
        return factoryButton1;
    }

    public Button getWarehouseButton1() {
        return warehouseButton1;
    }

    public Button getRequestButton1() {
        return requestButton1;
    }

    public Button getTableButton1() {
        return tableButton1;
    }

    private String tempWarehousesOutput2;
	private String tempRequestsOutput2;
	private String tempTableOutput2;
    @FXML
    private TextArea phase1Output;
    private TextField phase1Days;
    private TextField phase1Max;
    private Label percentageOfSuccess1;
    private TextArea tempOutput2;
    private Button factoryButton1;
    private Button warehouseButton1;
    private Button requestButton1;
    private Button tableButton1;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }

    public void setDays1(int days1) {
        this.days1 = days1;
    }

    public void setMax1(int max1) {
        this.max1 = max1;
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

    public void setTempTableOutput(String tempTableOutput) {
        this.tempTableOutput = tempTableOutput;
    }

    public void setTempPercentage2(String tempPercentage2) {
        this.tempPercentage2 = tempPercentage2;
    }

    public void setTempFactoriesOutput2(String tempFactoriesOutput2) {
        this.tempFactoriesOutput2 = tempFactoriesOutput2;
    }

    public void setTempWarehousesOutput2(String tempWarehousesOutput2) {
        this.tempWarehousesOutput2 = tempWarehousesOutput2;
    }

    public void setTempRequestsOutput2(String tempRequestsOutput2) {
        this.tempRequestsOutput2 = tempRequestsOutput2;
    }

    public void setTempTableOutput2(String tempTableOutput2) {
        this.tempTableOutput2 = tempTableOutput2;
    }

    public void setPhase1Output(TextArea phase1Output) {
        this.phase1Output = phase1Output;
    }

    public void setPhase1Days(TextField phase1Days) {
        this.phase1Days = phase1Days;
    }

    public void setPhase1Max(TextField phase1Max) {
        this.phase1Max = phase1Max;
    }

    public void setPercentageOfSuccess1(Label percentageOfSuccess1) {
        this.percentageOfSuccess1 = percentageOfSuccess1;
    }

    public void setTempOutput2(TextArea tempOutput2) {
        this.tempOutput2 = tempOutput2;
    }

    public void setFactoryButton1(Button factoryButton1) {
        this.factoryButton1 = factoryButton1;
    }

    public void setWarehouseButton1(Button warehouseButton1) {
        this.warehouseButton1 = warehouseButton1;
    }

    public void setRequestButton1(Button requestButton1) {
        this.requestButton1 = requestButton1;
    }

    public void setTableButton1(Button tableButton1) {
        this.tableButton1 = tableButton1;
    }

    /**
     * switches to phase 2
     */
    public void switchToPhase2(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase2.fxml"));
        root = loader.load();
        Controller2 controller = loader.getController();
        controller.getPhase2Days().setText(phase1Days.getText());
        controller.getPhase2Max().setText(phase1Max.getText());
        controller.getPhase2Output().setText(tempOutput2.getText());
        controller.getPercentageOfSuccess2().setText(tempPercentage2);
        
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

        controller.tempPercentage1 = percentageOfSuccess1.getText();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    /**
     * resets simulation
     */
    public void resetSimulation(ActionEvent event) throws IOException {
        phase1Output.setText("");
        percentageOfSuccess1.setText("");
        factoryButton1.setOpacity(0);
        warehouseButton1.setOpacity(0);
        requestButton1.setOpacity(0);
        tableButton1.setOpacity(0);
    }
    /**
     * runs simulation
     */
    public void runSimulation(ActionEvent event) throws IOException, CloneNotSupportedException {
        try {
            days1 = Integer.parseInt(phase1Days.getText());
            max1 = Integer.parseInt(phase1Max.getText());
            if(days1 > 0 && max1 >0) {
                phase1Output.setText("");
                Main run = new Main(days1, max1);

                // output Reports
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
                percentageOfSuccess1.setText(String.format("%s%.2f%s","Percentage Of Success: ", report.getPos(), "%"));
                factoryButton1.setOpacity(1);
                warehouseButton1.setOpacity(1);
                requestButton1.setOpacity(1);
                tableButton1.setOpacity(1);
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
    *link for our JAVADOC
    */
    public void openLink(ActionEvent event) throws URISyntaxException, IOException {
    	Desktop.getDesktop().browse(new URI("https://faisaljabushanab.github.io/javadoc/"));
    }

}