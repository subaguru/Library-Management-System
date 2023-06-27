<%@page import="java.sql.*"%>
<html>
<head><title>View</title></head>
<body background="https://cdn.wallpapersafari.com/73/37/XREwJy.jpg">
<%

		try{
		   Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
		   e.printStackTrace();
		}



			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
%>
<h2 align="center"><font color="#F2E4CF"><strong>View Books</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5">

<tr bgcolor="#A96036">
		<td><b>B_No</b></td>
		<td><b>B_Name</b></td>
		<td><b>B_Author</b></td>
		<td><b>B_issued</b></td>
		<td><b>addeddate</b></td>
</tr>
<%
try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_Management_System", "root","root");
		statement = connection.createStatement();

		resultSet = statement.executeQuery("select * from librariansection");
		

while (resultSet.next()) {
%>
<tr bgcolor="#FFCBA4">

	<td><%=resultSet.getObject(2)%></td>
	<td><%=resultSet.getObject(3)%></td>
	<td><%=resultSet.getObject(4)%></td>
	<td><%=resultSet.getObject(5)%></td>
	<td><%=resultSet.getObject(6)%></td>
	
	

</tr>


<%
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>

