<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.io.*, java.util.*, java.sql.*" %>
<%@ page import="javax.servlet.http.*, javax.servlet.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Home</title>
<link rel="stylesheet" type="text/css" href="theme.css">
</head>
<body>
<button onclick="show();">show patient details</button>
 <sql:setDataSource var="mydb" driver="oracle.jdbc.driver.OracleDriver"
       url="jdbc:oracle:thin:@localhost:1521:xe"
       user="vishnunandan90" password="PLhv@123" />
   
   <sql:query dataSource="${mydb}" var="resultSet">
       SELECT * from patients
   </sql:query>
   <div id = "table1">
    <table border="2" width="100%">
       <tr>
           <th>patient id</th>
           <th>patient name</th>
           <th>age</th>
           <th>date of appointment</th>
           <th>timeslot</th>
       </tr>
       <c:forEach var="table" items="${resultSet.rows}">
           <tr>
               <td><c:out value="${table.pid}"/></td>
               <td><c:out value="${table.patientname}"/></td>
               <td><c:out value="${table.age}"/></td>
               <td><c:out value="${table.doa}"/></td>
               <td><c:out value="${table.timeslot}"/></td>
           </tr>
       </c:forEach>    
   </table>
   </div>
	 
   <script src="myjs2.js"></script>
</body>
</html>