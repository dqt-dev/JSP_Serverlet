package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.BEAN.Users;
import Model.BO.ModelBO;

@WebServlet("/UserTableStateServlet")
public class UserTableStateServlet extends HttpServlet{

	ModelBO modelBO = new ModelBO();
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Ä�Äƒng nháº­p tÃ i khoáº£n
		try {
			UpdateState(request, response);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void UpdateState(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		
		String state = request.getParameter("state");
		
		ModelBO modelBO = new ModelBO();
		modelBO.setUserTableState(state);
	}
	
	private void GetState(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		
		String state = request.getParameter("state");
		
		ModelBO modelBO = new ModelBO();
		modelBO.setUserTableState(state);
		
//		Gson gson = new Gson();
//		String userJSON = gson.toJson(user1);
//		
//		response.setContentType("text/html; charset=UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter printWriter = response.getWriter();
//		
//		try {
//			if(modelBO.checkLogin(user1))
//			{
//				printWriter.write(userJSON);
//			}
//			else
//			{
//				printWriter.write("Username or Password Error");
//			}
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		printWriter.close();
	}
}
