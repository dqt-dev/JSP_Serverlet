<%@ page language="java" contentType= "text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<html>
 <head>
    <body>
    <h1>Change Password</h1>
        <%
            String temp = "temp";
            session.setAttribute("temp",temp);
        %>
            <form action="http://localhost:8080/WebService/ChangePasswordServlet" method="post">
		        ID: <input type="text" name="ID" id=""> <br>
		        Password: <input type="text" name="password" id=""> <br>
		        <input type="submit" value="Login">
		        <input type="reset" value="Cancel">
    		</form>
    </body>
 </head>
</html>