import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LibrarianLogin extends HttpServlet{
  public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
            System.out.println("LibrarianLogin servlet invoked");
            //iniziate the values
            boolean result=false;
            boolean check=false;

            //call the dbhandler
            DBHandler db=new DBHandler();

            //getting the inputs

            String personid=request.getParameter("personid");
            Integer id=Integer.valueOf(personid);

                check=db.checkQueryLidTologin(id);
                if(check){
                    result=db.createQuery(id);
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