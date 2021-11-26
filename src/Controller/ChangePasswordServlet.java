package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BEAN.Users;
import Model.BO.ModelBO;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet{

	ModelBO modelBO = new ModelBO();
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Thay đổi mật khẩu 
		try {
			try {
				PasswordChange(request, response);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void PasswordChange(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, NoSuchAlgorithmException {
	
		int ID =Integer.parseInt(request.getParameter("ID"));
		String password = request.getParameter("password");
		
		String passwordEncode = modelBO.PasswordEncode(password);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = response.getWriter();
		
		Users user = new Users(ID,"",passwordEncode,""); // id,username,pass,displayname
		
		if(modelBO.PasswordChange(user))
		{
			printWriter.write("Change successful");
		}
		else
		{
			printWriter.write("Failed");
		}
		printWriter.close(); 
	}
	
}
