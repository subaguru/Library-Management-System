import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ReturnBooks extends HttpServlet{
  public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
            System.out.println("ReturnBooks servlet invoked");
            boolean result=false;
            boolean check=false;
            int update=0;
            DBHandler db=new DBHandler();

            String no=request.getParameter("no");
            Integer iId=Integer.valueOf(no);

                check=db.checkQueryToissueid(iId);
                if(check){
                    result=db.returnQuery(iId);
                    update=db.updeatQuerytoIsReturn(iId);
                    System.out.println(result);
                }
              

                response.setContentType("text/html");
                PrintWriter out=response.getWriter();



                if(update==1){
                    out.println("success");
                }
                else{
                  out.println("Please provid valid inputs");
                }  
            
  }
}