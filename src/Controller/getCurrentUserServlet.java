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

import Model.BEAN.CurrentUser;
import Model.BEAN.Users;
import Model.BO.ModelBO;

@WebServlet("/getCurrentUserServlet")
public class getCurrentUserServlet extends HttpServlet{

	ModelBO modelBO = new ModelBO();
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Đăng kí tài khoản mới
		try { 
			getCurrentUser(request, response);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void getCurrentUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		
		String idDevice = request.getParameter("idDevice"); // get từ android
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = response.getWriter();
		Gson gson = new Gson();
		
		CurrentUser currentUser = new CurrentUser(idDevice);
		
		if(modelBO.checkCurrentUser(currentUser))
		{
			int ID = modelBO.getID_UserbyidDevice(currentUser);
			Users user = new Users(ID);
			
			Users user1 = modelBO.getUserbyID(user);
			String JsonUser = gson.toJson(user1);
			
			printWriter.write(JsonUser);
		}
		
	}
}
	
