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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{

	ModelBO modelBO = new ModelBO();
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Ä�Äƒng kÃ­ tÃ i khoáº£n má»›i
		try { 
			try {
				Register(request, response);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void Register(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordencode = modelBO.PasswordEncode(password);
		String displayname = request.getParameter("displayname");
		
		byte ptext[] = displayname.getBytes();
		String value = new String(ptext, "UTF-8");
		
		Users user = new Users(username,passwordencode,value);
		
		
		if(modelBO.CheckUserExist(user))
		{
			printWriter.write("Username is exist!");
		}
		else
		{
		
			try {
				if(modelBO.Register(user))
				   {
					printWriter.write("Register Sucessful!"); 
				   }
				else
				   {
					printWriter.write("Register Error!");
				   }
				
			}catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		printWriter.close(); 
	}
}
	
