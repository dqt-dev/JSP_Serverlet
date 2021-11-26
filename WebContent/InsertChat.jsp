<%@ page language="java" contentType= "text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<html>
 <head>
    <body>
        <%
            String temp = "temp";
            session.setAttribute("temp",temp);
        %>
        <h1>Thêm tin nhắn mới</h1>
            <form action="http://localhost:8080/WebService/SendAndReceiveMessageServlet" method="post">
		        Id_Sender: <input type="text" name="Id_Sender" id=""> <br>
		        Id_Receiver: <input type="text" name="Id_Receiver" id=""> <br>
		        Message: <input type="text" name="Message" id=""> <br>
		        <input type="submit" value="Thêm tin nhắn mới">
		        <input type="reset" value="Cancel">
    		</form>
    </body>
 </head>
</html>