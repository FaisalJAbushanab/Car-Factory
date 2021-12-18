package phase1;

import java.util.ArrayList;

public class TableViewer {

    private ArrayList<String> codes  = new ArrayList<String>();
    private ArrayList<String> values = new ArrayList<String>();

    public TableViewer(ArrayList<String> codes, ArrayList<String> values) {
        this.codes  = codes;
        this.values = values;
    }
    public String viewTable(int rows , int cols) {
        //check if the table shows all the values
        if(rows*cols<values.size()) {System.out.println("Table is too small!");return null;}
        String table = "";
        String impliesSymbol = "->";
        //Based on the number of rows find the width of each column.
        int[] widthCols = new int [cols];
        for(int i=0 ; i<values.size() ; i++) {//go through all the values
            if(values.get(i).length()
                    + codes.get(i).length()+
                    impliesSymbol.length()
                    > widthCols[(int) Math.floor(i/rows)]) {
                widthCols[(int) Math.floor(i/rows)] = values.get(i).length() + codes.get(i).length()+impliesSymbol.length();
            }
        }
        //print the table
        String output = "";
        for(int r=0 ; r<rows ; r++) {
            for(int i=r ; i<values.size() ; ) {
                String text = codes.get(i) + impliesSymbol + values.get(i);
                output += String.format("%-"+ widthCols[(int) Math.floor(i/rows)] +"s \t",text);
                i+=rows;
            }
            output += "\n";
        }
        return output;
    }
}
