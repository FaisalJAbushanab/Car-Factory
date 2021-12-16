package phase2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Report {
    private ArrayList<Request> requests;
    private ArrayList<Factory> factories;
    private ArrayList<Warehouse> warehouses;
    private static String mainReport = "";
    private static String requestsReport = "";
    private static String factoriesReport = "";
    private static String warehousesReport = "";
    private static String table = "";
    private String name;
    private double pos;


    public Report(LocalDateTime simDate, ArrayList<Request> requests,
                  ArrayList<Factory> factories, ArrayList<Warehouse> warehouses) throws CloneNotSupportedException {

//        for (Warehouse OGwarehouse : warehouses) {
//            Warehouse clonedWarehouse = (Warehouse) OGwarehouse.clone();
//            warehouses.add(clonedWarehouse);
//        }
//        for (Factory OGfactory : factories) {
//            Factory clonedFactory = (Factory) OGfactory.clone();
//            factories.add(clonedFactory);
//        }
//        for (Request OGrequest : requests) {
//            Request clonedRequest = (Request) OGrequest.clone();
//            requests.add(clonedRequest);
//        }
        this.requests = requests;
        this.factories = factories;
        this.warehouses = warehouses;

        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.name = simDate.format(myFormat);
    }

    public void generateReport() throws IOException {
        writeMainReport();
        writeWarehousesReport();
        writeFactoriesReport();
        writeRequestsReport();
        writeTable(requests, factories);
    }

    private void writeTable(ArrayList<Request> requests, ArrayList<Factory> factories) {
    }

    // writes on file the main information of the simulation
    public void writeMainReport() throws IOException {
        int numOfSuccess = 0;
        for (Request request : requests) {
            if (request.getTakenFactory() != null) {
                mainReport += (requests.indexOf(request) + 1) + ": request " + request.getDateRequested() +
                        " found factory#" + (request.getTakenFactoryIndex()) + "\n";
                mainReport += request.getFullfilmentInfo();
                numOfSuccess++;
            } else {
                mainReport += (requests.indexOf(request) + 1) + ": request " + request.getDateRequested() + " did not find a factory!\n";
                mainReport += request.getFullfilmentInfo();
            }
        }
        pos = (double) numOfSuccess / requests.size() * 100;
        writeToFile((name + " Main"), mainReport);
    }

    // writes on file the warehouse information of the simulation
    public void writeWarehousesReport() throws IOException {
        warehousesReport += "Number of warehouse generated: " + warehouses.size() + "\n\n";
        for (Warehouse warehouse : warehouses) {
            warehousesReport += "#" + (warehouses.indexOf(warehouse) + 1) + ": "
                    + warehouse.getWarehouseInformation();
        }
        writeToFile((name + " Warehouses"), warehousesReport);
    }

    // writes on file the factories information of the simulation
    public void writeFactoriesReport() throws IOException {
        factoriesReport += "Number of factories generated: " + factories.size() + "\n\n";
        for (Factory factory : factories) {
            factoriesReport += "#" + (factories.indexOf(factory) + 1) + ": "
                    + factory.getFactoryInformation();
        }
        writeToFile((name + " Factories"), factoriesReport);
    }

    // writes on file the requests information of the simulation
    public void writeRequestsReport() throws IOException {
        requestsReport += "Number of requests generated: " + requests.size() + "\n\n";
        for (Request request : requests) {
            requestsReport += "Request#" + (requests.indexOf(request) + 1) + ":\n";
            requestsReport += request.getComputersInformation();
            requestsReport += request.getFullfilmentInfo();
        }
        writeToFile((name + " Requests"), requestsReport);
    }

    // write to file a report named after simulation date
    private void writeToFile(String name, String report) throws IOException {
        name += ".txt";
        BufferedWriter output = null;
        try {
            File file = new File(name);
            output = new BufferedWriter(new FileWriter(file));
            output.write(report);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }


    public static String getMainReport() {
        return mainReport;
    }

    public static String getRequestsReport() {
        return requestsReport;
    }

    public static String getFactoriesReport() {
        return factoriesReport;
    }

    public static String getWarehousesReport() {
        return warehousesReport;
    }

    public String getName() {
        return name;
    }

    public double getPos() {
        return pos;
    }
}
