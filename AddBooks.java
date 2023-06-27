import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class AddBooks extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
            System.out.println("AddBooks servlet invoked");
            //iniziate the values
            boolean result=false;
            boolean check=false;

            //call the dbhandler
            DBHandler db=new DBHandler();

            //getting the inputs
            String lid=request.getParameter("lid");
            Integer id=Integer.valueOf(lid);

            String  bno=request.getParameter("no");
            Integer no=Integer.valueOf(bno);

    	    String name=request.getParameter("name");
            String author=request.getParameter("author");
            
    
                //to check the login id is available in loginform and add the values
                check=db.checkQueryLid(id);
                if(check){
                    result=db.addQuery(id,no,name,author);
                    System.out.println(result);
                }
                 
                  response.setContentType("text/html");
                   PrintWriter out=response.getWriter();

                //checking success or fail
                if(result){
                    out.println("success");
                }
                else{
                  out.println("Please provid valid inputs");
                }  
            
	}
}