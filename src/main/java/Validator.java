import java.math.BigDecimal;

public class Validator {
    public boolean validate(String x, String y, String r){
        return (!x.equals("null")&&!y.equals("null")||!r.equals("null")&&inInterval(x,getBigDec("-3"),getBigDec("5"))&&inInterval(y,getBigDec("-3"),getBigDec("5"))&&checkR(r));
    }
    private boolean inInterval(String param, BigDecimal min, BigDecimal max){
        try {
            BigDecimal bdec = new BigDecimal(param.replace(",", "."));
            return (bdec.compareTo(min)>0 && bdec.compareTo(max)<0);
        }catch (Exception e){
            return false;
        }
    }
    private BigDecimal getBigDec(String str){
        return new BigDecimal(str);
    }
    private boolean checkR(String a) {
        String[] massString = {"1","1.5","2","2.5","3"};
        for (String s : massString) {
            if (a.replace(",",".").equals(s)) {
                return true;
            }
        }
        return false;
    }
}
