package carFactory;

import com.sun.source.tree.UsesTree;

import java.util.ArrayList;

public class Report {
    // TODO REPORT
    private ArrayList<Request> requests;
    private String report;
    //dates

    public Report(ArrayList<Request> requests) {
        this.requests = requests;

    }
    public void setReport(String report) {
        report = generateReport();
    }

    public String generateReport() {
        return null;
    }

    public String getReport() {
        return report;
    }

    public int[] getRequiredMaterials() {
        return null;
    }
    public int getRequiredWorkers() {
        return 0;
    }
    public int getRequiredCost() {
        return 0;
    }
    public int getRequiredTime() {
        return 0;
    }
}