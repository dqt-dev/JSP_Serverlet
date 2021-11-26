<%@ page language="java" contentType= "text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<html>
 <head>
    <body>
        <%
            String temp = "temp";
            session.setAttribute("temp",temp);
        %>
        <h1>Get Current User</h1>
            <form action="http://localhost:8080/WebService/getCurrentUserServlet" method="post">
		        idDevice: <input type="text" name="idDevice" id=""> <br>
		        <input type="submit" value="check">
		        <input type="reset" value="Cancel">
    		</form>
    </body>
 </head>
</html>