package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BEAN.Chats;
import Model.BO.ModelBO;

@WebServlet("/SendMessageServlet")
public class SendMessageServlet extends HttpServlet{

	ModelBO modelBO = new ModelBO();
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Thêm tin nhắn mới và get toàn bộ tin nhắn của Sender và Receiver
		try { 
			InsertChat(request, response);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	private void InsertChat(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		
		int Id_Sender =Integer.parseInt(request.getParameter("sender")); // get từ android
		int Id_Receiver =Integer.parseInt(request.getParameter("receiver"));
		String Mess = request.getParameter("message");
		
		Chats chat = new Chats(Id_Sender, Id_Receiver, Mess);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = response.getWriter();
		
		if(modelBO.InsertChats(chat))
		{
			printWriter.write("Insert Successful");
		}
		else
		{
			printWriter.write("Insert Failed");
		}
		printWriter.close();
	}
}
	
