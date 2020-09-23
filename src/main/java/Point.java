import java.math.BigDecimal;

public class Point {
    private BigDecimal xDec;
    private BigDecimal yDec;
    private BigDecimal rDec;
    public Point(String x, String y, String r){
        xDec = new BigDecimal(x.trim().replace(",","."));
        yDec = new BigDecimal(y.trim().replace(",","."));
        rDec = new BigDecimal(r.trim().replace(",","."));
    }

    public void setRDec(String newR){
        rDec = new BigDecimal(newR.trim().replace(",","."));
    }
    public String getX(){return xDec.toString();}
    public String getY(){return yDec.toString();}
    public String getR(){return rDec.toString();}

    public Boolean isHit(){
        if (xDec.compareTo(BigDecimal.ZERO) >= 0 && xDec.compareTo(rDec.divide(BigDecimal.valueOf(2))) <= 0
                && yDec.compareTo(BigDecimal.ZERO) >= 0 && yDec.compareTo(rDec) <= 0) {
            return true;
        }
        if (xDec.compareTo(BigDecimal.ZERO) <= 0 && yDec.compareTo(BigDecimal.ZERO) <= 0
                && (xDec.pow(2).add(yDec.pow(2))).compareTo(rDec.divide(BigDecimal.valueOf(2)).pow(2)) <= 0) {
            return true;
        }
        if (xDec.compareTo(BigDecimal.ZERO) <= 0 && yDec.compareTo(BigDecimal.ZERO) >= 0
                && yDec.compareTo((xDec.divide(BigDecimal.valueOf(2))).add(rDec.divide(BigDecimal.valueOf(2)))) <= 0) {
            return true;
        }
        return false;
    }
}
