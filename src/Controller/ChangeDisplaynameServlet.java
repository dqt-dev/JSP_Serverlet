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

@WebServlet("/ChangeDisplaynameServlet")
public class ChangeDisplaynameServlet extends HttpServlet{

	ModelBO modelBO = new ModelBO();
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ChangeImageURL
		try {
			DisplaynameChange(request, response);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void DisplaynameChange(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
	
		int ID = Integer.parseInt(request.getParameter("ID"));
		String displayname = request.getParameter("displayname");
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = response.getWriter();
		
		Users user = new Users(ID,"","",displayname); // ID,Username,password,Displayname
		
		
		if(modelBO.ChangeDisplayname(user))
		{
			printWriter.write("Change Displayname successful");
		}
		else
		{
			printWriter.write("Failed");
		}
		printWriter.close(); 
	}
	
}
