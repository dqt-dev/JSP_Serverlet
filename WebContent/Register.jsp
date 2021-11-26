<%@ page language="java" contentType= "text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<html>
 <head>
    <body>
    <h1>Register</h1>
        <%
            String temp = "temp";
            session.setAttribute("temp",temp);
        %>
            <form action="http://localhost:8080/WebService/RegisterServlet" method="post">
		        Username: <input type="text" name="username" id=""> <br>
		        PassWord: <input type="password" name="password" id=""> <br>
		        Displayname: <input type="text" name="displayname" id=""> <br>
		        <input type="submit" value="Login">
		        <input type="reset" value="Cancel">
    		</form>
    </body>
 </head>
</html>