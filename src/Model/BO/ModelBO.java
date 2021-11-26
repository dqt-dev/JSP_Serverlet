package Model.BO;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.BEAN.Chats;
import Model.BEAN.CurrentUser;
import Model.BEAN.Users;
import Model.DAO.ModelDAO;

public class ModelBO {
	 ModelDAO ModelDAO = new ModelDAO();
	    public boolean checkLogin(Users user) throws ClassNotFoundException, SQLException
	    {
	        return ModelDAO.checkLogin(user);
	    }
	    public boolean CheckUserExist(Users user) throws ClassNotFoundException, SQLException
	    {
	    	return ModelDAO.CheckUserExsit(user);
	    }
	    public boolean Register(Users user) throws ClassNotFoundException, SQLException
	    {
	    	return ModelDAO.RegisterUser(user);
	    }
	    public  boolean PasswordChange(Users user) throws ClassNotFoundException, SQLException {
			return ModelDAO.PasswordChange(user);
		}
	    public  boolean InsertChats(Chats chat) throws ClassNotFoundException, SQLException {
			return ModelDAO.InsertChats(chat);
		}
	    public  boolean InsertCurentUser(Users user,String idDevice) throws ClassNotFoundException, SQLException {
			return ModelDAO.InsertCurrentUser(user,idDevice);
		}
	    public  boolean checkCurrentUser(CurrentUser currentUser) throws ClassNotFoundException, SQLException {
			return ModelDAO.checkCurrentUser(currentUser);
		}
	    public boolean DeleteCurrentUser(CurrentUser currentUser) throws ClassNotFoundException, SQLException {
			return ModelDAO.DeleteCurrentUser(currentUser);
		}
	    public String PasswordEncode(String password) throws NoSuchAlgorithmException
	    {
	    	return ModelDAO.PasswordEncode(password);
	    }
//	    public ArrayList<Chats> getChatsNew(Chats chat) throws ClassNotFoundException, SQLException
//	    {
//	    	return ModelDAO.checkisNew(chat);
//	    }
	    public ArrayList<Users> getAllUsers() throws ClassNotFoundException, SQLException
	    {
	    	return ModelDAO.getAllUsers();
	    }
//	    public ArrayList<Chats> getChatsNewNoInsert(Chats chat) throws ClassNotFoundException, SQLException
//	    {
//	    	return ModelDAO.getChatsNew(chat);
//	    }
	    public ArrayList<Chats> getAllChat(Chats chat) throws ClassNotFoundException, SQLException{
	    	return ModelDAO.getAllChat(chat);
	    }
	    public int getIdbyUsername(Users user) throws ClassNotFoundException, SQLException
	    {
	    	return ModelDAO.getIDbyUsername(user);
	    }
	    public int getID_UserbyidDevice(CurrentUser currentUser) throws ClassNotFoundException, SQLException
	    {
	    	return ModelDAO.getID_UserbyidDevice(currentUser);
	    }
	    public String getDisplaynamebyUsername(Users user) throws ClassNotFoundException, SQLException
	    {
	    	return ModelDAO.getDisplaynamebyUsername(user);
	    }
	    public Users getUserbyID(Users user) throws ClassNotFoundException, SQLException
	    {
	    	return ModelDAO.getUserbyID(user);
	    }
	    
	    
	    
	    
	    // is user new
	    public boolean setUserTableState(String state) throws ClassNotFoundException, SQLException
	    {
	    	return ModelDAO.setUserTableState(state);
	    }    
	    public String getUserTableState() throws ClassNotFoundException, SQLException
	    {
	    	return ModelDAO.getUserTableState();
	    }
	    
	    
	    // is chat new
	    public boolean setChatTableState(String state) throws ClassNotFoundException, SQLException
	    {
	    	return ModelDAO.setChatTableState(state);
	    }
	    public boolean ChangeDisplayname(Users user) throws ClassNotFoundException, SQLException
	    {
	    	return ModelDAO.ChangeDisplayname(user);
	    }
	    public String getChatTableState() throws ClassNotFoundException, SQLException
	    {
	    	return ModelDAO.getChatTableState();
	    }
	    
	    
	    // change status and imageURL
	    public boolean ChangeStatus(Users user) throws ClassNotFoundException, SQLException
	    {
	    	return ModelDAO.ChangeStatus(user);
	    }
	    public boolean ChangeImageURL(Users user) throws ClassNotFoundException, SQLException
	    {
	    	return ModelDAO.ChangeImageURL(user);
	    }
}
