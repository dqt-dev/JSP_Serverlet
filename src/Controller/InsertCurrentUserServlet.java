package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.BEAN.Users;
import Model.BO.ModelBO;

@WebServlet("/InsertCurrentUserServlet")
public class InsertCurrentUserServlet extends HttpServlet{

	ModelBO ModelBO = new ModelBO();
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Đăng kí tài khoản mới
		try { 
			InsertCurrentUser(request, response);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void InsertCurrentUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		
		int ID_User = Integer.parseInt(request.getParameter("ID_User")); // get từ android
		String idDevice = request.getParameter("idDevice");
		
		Users user = new Users(ID_User); 
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = response.getWriter();
		
		try {
			if(ModelBO.InsertCurentUser(user, idDevice))
			{
				printWriter.write("Insert CurrentUser Sucessful!"); 
			}
			else
			{
				printWriter.write("Insert CurrentUser Error!");
			}
				
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printWriter.close(); 
	}
}
	
