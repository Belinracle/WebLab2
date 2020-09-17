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
    final String pathToAreaCheck = "AreaCheckServlet";
    final String pathToJSP = "/index.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        String r = req.getParameter("r");
        ServletContext context = getServletContext();
        if(validate(x,y,r)){
            context.getRequestDispatcher(pathToAreaCheck).forward(req,resp);
        }else{
            context.getRequestDispatcher(pathToJSP).forward(req,resp);
        }
    }
    public boolean validate(String x, String y, String r){
        return (x.equals("null")||y.equals("null")||r.equals("null")||!inInterval(x,getBigDec("-3"),getBigDec("5"))||!inInterval(y,getBigDec("-3"),getBigDec("5"))||!checkR(r));
    }
    public boolean inInterval(String param, BigDecimal min, BigDecimal max){
        try {
            BigDecimal bdec = new BigDecimal(param.replace(",", "."));
            return (bdec.compareTo(min)>0 && bdec.compareTo(max)<0);
        }catch (Exception e){
            return false;
        }
    }
    public BigDecimal getBigDec(String str){
        return new BigDecimal(str);
    }
    private boolean checkR(String a) {
        String[] massString = {"1","1.5","2","2.5","3"};
        for (String s : massString) {
            if (a.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
