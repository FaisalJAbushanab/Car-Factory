package carFactory;

import com.sun.source.tree.UsesTree;

public class Report {

    private String report;
    //dates

    public Report(String report) {
        //this.report = setReport();
    }
    public void setReport(String report) {
        report = generateReport();
    }

    private String generateReport() {
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