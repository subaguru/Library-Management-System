import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class DeleteLibrarian extends HttpServlet{
  public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
            System.out.println("DeleteLibrarian servlet invoked");
            //iniziate the values;
            boolean result=false;
            boolean check=false;

            //call th dbhandler
            DBHandler db=new DBHandler();

            //getting the inputs
            String personid=request.getParameter("personid");
            //convert string to int
            Integer id=Integer.valueOf(personid);

                check=db.checkQueryLidTodelete(id);
                if(check){
                    result=db.deleteQuery(id);
                    System.out.println(result);
                }
                
                response.setContentType("text/html");
                PrintWriter out=response.getWriter();

                if(result){
                    out.println("success");
                }
                else{
                  out.println("Please provid valid Librarian id");
                }  
            
  }
}