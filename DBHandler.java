import java.sql.*;

public class DBHandler{
    private Connection con=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    private PreparedStatement state=null;
    
    
    
	public DBHandler()  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_Management_System", "root","root");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
        
    }

	 //Add librarian query
     //add the librarian Details
     public Boolean insertQuery(String name,String mailid,String password,String address,String city,String contact){
         Boolean value=false;
         try{
            state = con.prepareStatement("insert into adminsection(L_id,L_Name,L_emailid,L_password,address,city,contact) values(L_id,?,?,?,?,?,?)");
                    
            state.setString(1,name);
            state.setString(2,mailid);
            state.setString(3,password);
            state.setString(4,address);
            state.setString(5,city);
            state.setString(6,contact);
            state.execute();
            value=true;
            System.out.println("error in insert query");
             
            }

            catch(Exception e){
                e.printStackTrace();
            
            }
        return value;
    }
    

    //delete librarian query
    public Boolean deleteQuery(int personid){
     	Boolean value=true;
         try{
            state = con.prepareStatement("delete from adminsection where L_id=?");
                    
            state.setInt(1,personid);
            state.execute();
            System.out.println("error in deletequery");
             
            }

            catch(Exception e){
                value=false;
            
            }
        return value;
    }

    //delete librarian check query
    //check the Lid available in adminsection
    public Boolean checkQueryLidTodelete(int personid) {
            Boolean result=false;
            
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery("select * from adminsection  where  L_id like "+personid);
                while(rs.next()){
                    result=true;
                    System.out.print("Correct peronid");
                }
                
            }

            catch(Exception e) {
                    e.printStackTrace();
                    System.out.print("Invalid inputs");
            }
        return result;
    }

     //librarian login check query
    ////check the Lid available in adminsection
    public Boolean checkQueryLidTologin(int personid) {
            Boolean result=false;
            
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery("select * from adminsection  where  L_id like "+personid);
                while(rs.next()){
                    result=true;
                    System.out.print("Correct peronid");
                }
                
            }

            catch(Exception e) {
                    e.printStackTrace();
                    System.out.print("Invalid inputs");
            }
        return result;
    }
    //login page create query
    public Boolean createQuery(int personid){
         Boolean value;
         try{
            state = con.prepareStatement("insert into loginform(L_id) values(?)");
            value=true;        
            state.setInt(1,personid);
            state.execute();
            System.out.println("error in create query");
             
            }

            catch(Exception e){
                value=false;
            }
        return value;
    }
    //login page check query
    //to check the login id is available in adminsection
    public Boolean checkQueryLid(int personid) {
            Boolean result=false;
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery("select * from loginform  where  L_id like "+personid);
                while(rs.next()){
                    result=true;
                    System.out.print("Correct peronid");
                }
                
            }

            catch(Exception e) {
                    e.printStackTrace();
                    System.out.print("Invalid inputs");
            }
        return result;
    }
     
    //Add books query
    public Boolean addQuery(int id,int no,String name,String author){
         Boolean value;
         try{
            state = con.prepareStatement("insert into librariansection(L_id,B_Id,B_Name,B_Author,B_issued,addeddate) values(?,?,?,?,false,now())");
            value=true;     
            state.setInt(1,id);   
            state.setInt(2,no);
            state.setString(3,name);
            state.setString(4,author);
            state.execute();
            System.out.println("error in add query");
             
            }

            catch(Exception e){
                value=false;
            }
        return value;
    }
    //add the issue book tables
    public Boolean issueQuery(int lid,int bid,int sid, String sname,String scontact){
         Boolean value;
         try{
            state = con.prepareStatement("insert into issuebook(L_id,B_Id,S_Id,S_Name,S_Contact,issuedate,isreturn) values(?,?,?,?,?,now(),false)");
                   
            state.setInt(1,lid);
            state.setInt(2,bid);
            state.setInt(3,sid);
            state.setString(4,sname);
            state.setString(5,scontact);
            state.execute();
            value=true;
            System.out.println("error in issue query");
             
            }

            catch(Exception e){
                value=false;
            }
        return value;
    }
    //check login id and B_id available in the table
    public Boolean checkQuery(int lid,int bno) {
            Boolean result=false;
            
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery("select * from loginform INNER JOIN librariansection on librariansection.B_Id="+bno+" and loginform.L_id=librariansection.L_id");

                while(rs.next()){
                    result=true;
                    System.out.print("Correct L_id and B_Id");
                }
                
            }

            catch(Exception e) {
                    e.printStackTrace();
                    System.out.print("Invalid inputs");
            }
        return result;
    }
    //If issue from the students then update the issued=true;
    public int updateQuery(int bno) {
 
        int status=0;  
        try{  
    
            state=con.prepareStatement("update librariansection set B_issued=? where B_Id like ? ");  
            state.setInt(1,1);  
            state.setInt(2,bno);  
   
              
            state.execute();  
            status=1;
            
        }catch(Exception ex){
        	ex.printStackTrace();
        }  
          
        return status;  

    }
    //insert into returnbooks values to return 
    public Boolean returnQuery(int iId){
     	Boolean value=true;
         try{
            state = con.prepareStatement("insert into returnbook(I_id,isreturn) values(?,false)");
                    
            state.setInt(1,iId);
            state.execute();
            System.out.println("error in returnquery");
             
            }

            catch(Exception e){
                value=false;
            
            }
        return value;
    }
    //to check availblae tha bid
    public Boolean checkQueryToissueid(int iId) {
            Boolean result=false;
            
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery("select * from issuebook  where I_id like "+iId);
                while(rs.next()){
                    result=true;
                    System.out.print("Correct Issue id");
                }
                
            }

            catch(Exception e) {
                    e.printStackTrace();
                    System.out.print("Invalid inputs");
            }
        return result;
    }
    public int updeatQuerytoIsReturn(int iId){

        int status=0;  
        try{  
    
            state=con.prepareStatement("update issuebook set isreturn=? where I_id like ? ");  
            state.setInt(1,1);  
            state.setInt(2,iId);  
   
              
            state.execute();  
            status=1;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }  
          
        return status;  
    }

}




