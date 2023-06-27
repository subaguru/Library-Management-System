import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class AdminLogin extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
            System.out.println("AdminLogin servlet invoked");

            //getting the inputs
            String mailid=request.getParameter("mailid");
    	    String password=request.getParameter("password");
 
       	   	
   
            response.setContentType("text/html");
	        PrintWriter out=response.getWriter();
       	   
     
		    if(mailid.equals("admin@123.com")&& password.equals("admin123")){
		         out.println("success");
		    }
		    else{
		         out.println("Incorrect mailid and password");
		    }	 
	
	}
}
