import javax.servlet.ServletContext;
import java.util.ArrayList;

public class ResultHandler {
    private ArrayList<String> list;
    ResultHandler(ServletContext context) {
        Object obj = context.getAttribute("results");
        if(obj==null){
            list = new ArrayList<>();
            context.setAttribute("results",list);
        }
        else{
            list = (ArrayList<String>)obj;
        }
    }
    public void setAttributes(String x, String y, String r){
        list.add(x);
        list.add(y);
        list.add(r);
    }
    public ArrayList<String> getResults(){
        return list;
    }
}
