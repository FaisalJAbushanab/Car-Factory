package carFactory;

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
    private static String allReport = "";
    private static String allRequestsReport = "";
    private static String allFactoriesReport = "";
    private static String allWarehousesReport = "";
    private String name;
    public double pos;
    
    // New constructor
    public Report() {
    	
    }
    public Report(ArrayList<Request> requests) {
    	this.requests = requests;
    }
    public Report(LocalDateTime simDate, ArrayList<Request> requests,
                  ArrayList<Factory> factories, ArrayList<Warehouse> warehouse) {
        this.requests = requests;
        this.factories = factories;
        this.warehouses = warehouse;
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.name = simDate.format(myFormat);

    }
    
    public ArrayList<String> generateReport(ArrayList<Request> requests) {
    	ArrayList<String> output = new ArrayList<>();
    	String text = String.format("-------------------------------------------------------------------------");
		String text1 = String.format("|%-3s|%-12s|%-13s|%-13s|%-16s|%-12s|", "id\t", "num of comps\t", "required cost\t", "required time\t", "status\t", "requested at\t");
		String text2 = String.format("==============================================");
    	output.add(text);
    	output.add(text1);
    	output.add(text2);
    	
    	int i = 1;
    	int numOfSuccess = 0;
    	for(Request request : requests) {
    		String time = request.getDay() + " - " + request.getHour() + ":" + request.getMinute();
    		String status;
    		if(request.takenFactoryIndex != -1) {
    			status = "success";
    			numOfSuccess++;
    		}else {
    			status = "no factory found";
    		}
    		String textt = String.format("|%-3s|%-12s|%-13s|%-13s|%-16s|%-12s|", i, request.getComputers().size(), request.getSelectedCost(), request.getSelectedTime(), status, time);
    		String dashes = String.format("-------------------------------------------------------------------------");
    		output.add(textt);
    		output.add(dashes);
    		i++;
    	}
    	pos = (double) numOfSuccess/requests.size()*100;
    	return output;
	}

    // writes on file the main information of the simulation
//    public void writeMainReport(String summary) throws IOException {
//        for (Request request: requests) {
//            if (request.getTakenFactory() != null) {
//                allReport += (requests.indexOf(request) + 1) + ": request " + request.getDateRequested() +
//                        " found factory#" + (request.getTakenFactoryIndex()) + "\n";
//                allReport += request.getFullfilmentInfo();
//            } else {
//                allReport += (requests.indexOf(request) + 1) + ": request " + request.getDateRequested() + " did not find a factory!\n";
//                allReport += request.getFullfilmentInfo();
//            }
//        }
//        allReport += summary;
//        writeToFile((name + " Main"), allReport);
//    }
//
//    // writes on file the warehouse information of the simulation
//    public void writeWarehousesReport() throws IOException {
//        allWarehousesReport += "Number of warehouse generated: " + warehouses.size() + "\n\n";
//        for (Warehouse warehouse : warehouses) {
//            allWarehousesReport += "#" + (warehouses.indexOf(warehouse)+1) + ": "
//                    + warehouse.getWarehouseInformation();
//        }
//        writeToFile((name + " Warehouses"), allWarehousesReport);
//    }
//    // writes on file the factories information of the simulation
//    public void writeFactoriesReport() throws IOException {
//        allFactoriesReport += "Number of factories generated: " + factories.size() + "\n\n";
//        for (Factory factory : factories) {
//            allFactoriesReport += "#" + (factories.indexOf(factory)+1) + ": "
//                    + factory.getFactoryInformation();
//        }
//        writeToFile((name + " Factories"), allFactoriesReport);
//    }
//    // writes on file the requests information of the simulation
//    public void writeRequestsReport() throws IOException {
//        allRequestsReport += "Number of requests generated: " + requests.size() + "\n\n";
//        for (Request request : requests) {
//            allRequestsReport += "Request#" + (requests.indexOf(request)+1) + ":\n";
//            allRequestsReport += request.getComputersInformation();
//            allRequestsReport += request.getFullfilmentInfo();
//        }
//        writeToFile((name + " Requests"), allRequestsReport);
//    }
//
//    // write to file a report named after simulation date
//    private void writeToFile(String name, String report) throws IOException {
//        name += ".txt";
//        BufferedWriter output = null;
//        try {
//            File file = new File(name);
//            output = new BufferedWriter(new FileWriter(file));
//            output.write(report);
//        } catch ( IOException e ) {
//            e.printStackTrace();
//        } finally {
//            if (output != null) {
//                output.close();
//            }
//        }
//    }
}