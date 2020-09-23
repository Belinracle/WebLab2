import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("")
public class ControllerServlet extends HttpServlet {
    final String pathToAreaCheck = "/resultTable.jsp";
    final String pathToJSP = "/index.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("X");
        String y = req.getParameter("Y");
        String r = req.getParameter("R");
        ServletContext context = getServletContext();
        req.setAttribute("path",req.getRequestURI());
        Validator validator = new Validator();
        if(validator.validate((x==null)?"null":x,(y==null)?"null":y,(r==null)?"null":r)){
            String[] params = new rowData(String.valueOf(System.nanoTime()),new Point(x,y,r)).getResults();
            req.setAttribute("row",params);
            context.getRequestDispatcher(pathToAreaCheck).forward(req,resp);
        }else{
            log((x==null)?"null":x);
            log(y);
            log(r);
            context.getRequestDispatcher(pathToJSP).forward(req,resp);
        }
    }
    public class Validator {
        public boolean validate(String x, String y, String r){
            return (!x.equals("null")&&!y.equals("null")&&!r.equals("null")&&inInterval(x,getBigDec("-3"),getBigDec("5"))&&inInterval(y,getBigDec("-3"),getBigDec("5"))&&checkR(r));
        }
        private boolean inInterval(String param, BigDecimal min, BigDecimal max){
            try {
                BigDecimal bdec = new BigDecimal(param.replace(",", ".").trim());
                boolean b = bdec.compareTo(min) >= 0 && bdec.compareTo(max) <= 0;
                return b;
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
}
