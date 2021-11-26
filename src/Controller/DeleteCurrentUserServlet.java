package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BEAN.CurrentUser;
import Model.BO.ModelBO;

@WebServlet("/DeleteCurrentUserServlet")
public class DeleteCurrentUserServlet extends HttpServlet{

	ModelBO modelBO = new ModelBO();
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Đăng kí tài khoản mới
		try { 
			DeleteCurrentUser(request, response);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void DeleteCurrentUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		
		String idDevice = request.getParameter("idDevice"); // get từ android
		
		CurrentUser currentUser = new CurrentUser(idDevice);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = response.getWriter();
		
		try {
			if(modelBO.DeleteCurrentUser(currentUser))
			{
				printWriter.write("Delete CurrentUser Sucessful!"); 
			}
			else
			{
				printWriter.write("Delete CurrentUser Error!");
			}
				
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printWriter.close(); 
		
	}
}
	
