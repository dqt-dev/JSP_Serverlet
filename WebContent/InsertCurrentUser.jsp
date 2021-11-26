<%@ page language="java" contentType= "text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<html>
 <head>
    <body>
        <%
            String temp = "temp";
            session.setAttribute("temp",temp);
        %>
        <h1>Insert Current User</h1>
            <form action="http://localhost:8080/WebService/InsertCurrentUserServlet" method="post">
		        idDevice: <input type="text" name="idDevice" id=""> <br>
		        ID_User: <input type="text" name="ID_User" id=""> <br>
		        <input type="submit" value="check">
		        <input type="reset" value="Cancel">
    		</form>
    </body>
 </head>
</html>