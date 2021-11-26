//package Model.BO;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import Model.BEAN.Chats;
//import Model.BEAN.CurrentUser;
//import Model.BEAN.Users;
//import Model.DAO.CheckLoginDAO;
//
//public class CheckLoginBO {
//	 CheckLoginDAO checkloginDAO = new CheckLoginDAO();
//	    public boolean checkLogin(Users user) throws ClassNotFoundException, SQLException
//	    {
//	        return checkloginDAO.checkLogin(user);
//	    }
//	    public boolean CheckUserExist(Users user) throws ClassNotFoundException, SQLException
//	    {
//	    	return checkloginDAO.CheckUserExsit(user);
//	    }
//	    public boolean Register(Users user) throws ClassNotFoundException, SQLException
//	    {
//	    	return checkloginDAO.RegisterUser(user);
//	    }
//	    public  boolean PasswordChange(Users user) throws ClassNotFoundException, SQLException {
//			return checkloginDAO.PasswordChange(user);
//		}
//	    public  boolean InsertChats(Chats chat) throws ClassNotFoundException, SQLException {
//			return checkloginDAO.InsertChats(chat);
//		}
//	    public  boolean InsertCurentUser(Users user) throws ClassNotFoundException, SQLException {
//			return checkloginDAO.InsertCurrentUser(user);
//		}
//	    public  boolean DeleteCurrentUser(CurrentUser currentUser) throws ClassNotFoundException, SQLException {
//			return checkloginDAO.DeleteCurrentUser(currentUser);
//		}
//	    public ArrayList<Chats> getChatsNew(Chats chat) throws ClassNotFoundException, SQLException
//	    {
//	    	return checkloginDAO.checkisNew(chat);
//	    }
//	    public ArrayList<Users> getAllUsers() throws ClassNotFoundException, SQLException
//	    {
//	    	return checkloginDAO.getAllUsers();
//	    }
//	    public ArrayList<Chats> getChatsNewNoInsert(Chats chat) throws ClassNotFoundException, SQLException
//	    {
//	    	return checkloginDAO.getChatsNew(chat);
//	    }
//	    public int getIdbyUsername(Users user) throws ClassNotFoundException, SQLException
//	    {
//	    	return checkloginDAO.getIDbyUsername(user);
//	    }
//	    public int getidDevicebyID_User(Users user) throws ClassNotFoundException, SQLException
//	    {
//	    	return checkloginDAO.getidDevicebyID_User(user);
//	    }
//	    public String getDisplaynamebyUsername(Users user) throws ClassNotFoundException, SQLException
//	    {
//	    	return checkloginDAO.getDisplaynamebyUsername(user);
//	    }
//}
