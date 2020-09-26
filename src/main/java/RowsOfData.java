import java.util.ArrayList;

public class RowsOfData {
    private ArrayList<RowData> rows;
    public RowsOfData(){
        rows = new ArrayList<>();
    }
    public void addRow(RowData row ){
        rows.add(0,row);
    }
    public ArrayList<RowData> getRows(){
        return rows;
    }
}
