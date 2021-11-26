package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import Model.BEAN.Users;
import Model.BO.ModelBO;

@WebServlet("/getAllUserServlet")
public class getAllUserServlet extends HttpServlet{

	ModelBO modelBO = new ModelBO();
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get All users 
		getAllUsers(request, response);
	}
	
private void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws IOException 
{
	Gson gson = new Gson();
	response.setContentType("text/html; charset=UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter printWriter = response.getWriter();
	
	try {
		ArrayList<Users> ListUsers = modelBO.getAllUsers();
		String allUsers = gson.toJson(ListUsers);
		printWriter.write(allUsers);
	} catch (Exception e) {
		// TODO: handle exception
	}
	printWriter.close();
	}
}
	
