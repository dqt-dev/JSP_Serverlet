package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import Model.BEAN.Chats;
import Model.BO.ModelBO;

@WebServlet("/getMessageServlet")
public class getMessageServlet extends HttpServlet{

	ModelBO modelBO = new ModelBO();
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Thêm tin nhắn mới và get toàn bộ tin nhắn của Sender và Receiver
		try { 
			getAllChat(request, response);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
private void getAllChat(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		
		int sender =Integer.parseInt(request.getParameter("sender")); // get từ android
		int receiver =Integer.parseInt(request.getParameter("receiver"));
		
		Chats chat = new Chats(sender, receiver);
		Gson gson = new Gson();
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = response.getWriter();
		
		try {
			ArrayList<Chats> listChat = modelBO.getAllChat(chat);
			String chatsJSON = gson.toJson(listChat);
			printWriter.write(chatsJSON);
		} catch (Exception e) {
			// TODO: handle exception
		}
		printWriter.close();
	}
}
	
