<%@ page language="java" contentType= "text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<html>
 <head>
    <body>
    <h1>Change ImageURL</h1>
        <%
            String temp = "temp";
            session.setAttribute("temp",temp);
        %>
            <form action="http://localhost:8080/WebService/ChangeImageURLServlet" method="post">
		        ID: <input type="text" name="ID" id=""> <br>
		        ImageURL: <input type="text" name="imageURL" id=""> <br>
		        <input type="submit" value="Login">
		        <input type="reset" value="Cancel">
    		</form>
    </body>
 </head>
</html>