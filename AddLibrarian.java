import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class AddLibrarian extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
            System.out.println("AddLibrarian servlet invoked");
            //iniziate the variable
            Boolean result=false;

            //Call the DB handler
            DBHandler db=new DBHandler();

            //getting the inputs
            String name=request.getParameter("name");
            String mailid=request.getParameter("mailid");
            String password=request.getParameter("password");
            String address=request.getParameter("address");
            String city=request.getParameter("city");
            String contact=request.getParameter("contact");
            
                //insertQuery Call
                result=db.insertQuery(name,mailid,password,address,city,contact);
                
                  
                  response.setContentType("text/html");
                   PrintWriter out=response.getWriter();
                   
                 
                if(result){
                    out.println("success");
                }
                else{
                  out.println("Please provid valid inputs");
                }  
            
	}
}