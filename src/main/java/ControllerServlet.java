import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class ControllerServlet extends HttpServlet {
    private final String pathToAreaCheck = "/resultTable.jsp";
    private final String pathToJSP = "/index.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("X");
        String y = req.getParameter("Y");
        String r = req.getParameter("R");
        ServletContext context = getServletContext();
        if (context.getAttribute("rows")==null)context.setAttribute("rows",new RowsOfData());
        req.setAttribute("path",req.getRequestURI());
        Validator validator = new Validator();
        if(validator.validate((x==null)?"null":x,(y==null)?"null":y,(r==null)?"null":r)){
            RowData newRow = new RowData(String.valueOf(System.nanoTime()),new Point(x,y,r));
            req.setAttribute("row",newRow);
            RowsOfData rows = (RowsOfData)context.getAttribute("rows");
            rows.addRow(newRow);
            context.getRequestDispatcher(pathToAreaCheck).forward(req,resp);
        }else{
            context.getRequestDispatcher(pathToJSP).forward(req,resp);
        }
    }
}
