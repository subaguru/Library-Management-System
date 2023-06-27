import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class IssueBooks extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
            System.out.println("IssueBooks servlet invoked");
            //iniziate the values
            boolean result=false;
            boolean check=false;
            int update=0;

            //call the dbHandler
            DBHandler db=new DBHandler();

            //getting the inputs
            String id=request.getParameter("lid");
            Integer lid=Integer.valueOf(id);

            String no=request.getParameter("bno");
            Integer bno=Integer.valueOf(no);

    	    String s_id=request.getParameter("sid");
            Integer sid=Integer.valueOf(s_id);

            String sname=request.getParameter("sname");
            String scontact=request.getParameter("scontact");
                //check login id and B_id available in the table
                check=db.checkQuery(lid,bno);
                
                System.out.println(check);
                
                if(check){
                    result=db.issueQuery(lid,bno,sid,sname,scontact);
                    update=db.updateQuery(bno);
                }
               
                 
                  response.setContentType("text/html");
                   PrintWriter out=response.getWriter();

                
                if(update==1){
                    out.println("success");
                }
                else{
                  out.println(update);
                }  
            
	}
}