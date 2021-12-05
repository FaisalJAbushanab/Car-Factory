package carFactory;

import com.sun.source.tree.UsesTree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Report {
    // TODO REPORT
    private ArrayList<Request> requests;
    private static String allReport;
    private String report;
    //dates

    public Report(ArrayList<Request> requests) {
        this.requests = requests;

    }

//    public void setReport(String report) {
//        report = generateReport();
//    }
//
    public void writeAllReport() {
        // Import the IOException class to handle errors
        String name = "date";
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void generateReport() {

    }
//
//    public String getReport() {
//        return report;
//    }












//    public int[] getRequiredMaterials() {
//        return null;
//    }
//    public int getRequiredWorkers() {
//        return 0;
//    }
//    public int getRequiredCost() {
//        return 0;
//    }
//    public int getRequiredTime() {
//        return 0;
//    }
}