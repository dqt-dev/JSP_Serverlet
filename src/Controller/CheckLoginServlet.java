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

@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet{

	ModelBO modelBO = new ModelBO();
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Ä�Äƒng nháº­p tÃ i khoáº£n
		try {
			CheckLogin(request, response);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
private void CheckLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		
		String username = request.getParameter("username"); // get tá»« android
		String password = request.getParameter("password");
		
		System.out.println(username);
		
		Users user = new Users(username,password); // user chá»‰ cÃ³ username vÃ  password
		Users user_result;
		if(modelBO.checkLogin(user)) {
			int ID = modelBO.getIdbyUsername(user);
			user_result = modelBO.getUserbyID(new Users(ID));
		} else {
			user_result = null;
		}
		
		
		Gson gson = new Gson();
		String userJSON = gson.toJson(user_result);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.write(userJSON);

		printWriter.close();
	}
}
