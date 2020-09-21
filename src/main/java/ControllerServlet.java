import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("")
public class ControllerServlet extends HttpServlet {
    final String pathToAreaCheck = "/areaCheck";
    final String pathToJSP = "/index.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("X");
        String y = req.getParameter("Y");
        String r = req.getParameter("R");
        ServletContext context = getServletContext();
        req.setAttribute("path",req.getRequestURI());
        Validator validator = new Validator();
        ResultHandler resultHandler = new ResultHandler(context);
        if(false){
            resultHandler.setAttributes(x,y,r);
            context.getRequestDispatcher(pathToAreaCheck).forward(req,resp);
        }else{
            context.getRequestDispatcher(pathToJSP).forward(req,resp);
        }
    }
}
