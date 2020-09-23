import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class rowData implements Serializable {
    private Point point;
    private Long start;
    private String[] results;

    public rowData(String start, Point point) {
        this.point = point;
        this.start = new Long(start);
        setResults();
    }

    public void setResults() {
        results = new String[]{point.getX(), point.getY(), point.getR(),
                new SimpleDateFormat("dd:MM:yyyy  HH:mm").format(new Date()),
                computeTime(), point.isHit().toString()};
    }

    public String[] getResults() {
        return results;
    }

    public String computeTime() {
        long result = System.nanoTime() - start;
        return Long.toString(result/1000);
    }
}
