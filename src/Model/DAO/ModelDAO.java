package Model.DAO;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

import Model.BEAN.Chats;
import Model.BEAN.CurrentUser;
import Model.BEAN.Users;

public class ModelDAO {

    public Connection getConnection() throws ClassNotFoundException, SQLException
    {
    	Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/CSDL_DA";
	 	Connection connection = DriverManager.getConnection(url, "root", "");
	 	
	 	return connection;
    }
	public boolean checkLogin(Users user) throws ClassNotFoundException, SQLException
    {
    	Connection connection = getConnection();
    	
	 	Statement stmt = connection.createStatement();
	 	String sql = "SELECT * FROM USERS";
	 	ResultSet rs = stmt.executeQuery(sql);
	 	ResultSetMetaData rsmd = rs.getMetaData();
	 	int ColumnCount = rsmd.getColumnCount();
	 	
	 	while(rs.next()){
	 			if(user.getUsername().equals(rs.getObject("username"))){
	 				if(user.getPassword().equals(rs.getString("password"))){
		 		 		return true;
	 				}
	 		 	}
	 	}
	 	connection.close();
		return false;
    }
    public boolean CheckUserExsit(Users user) throws ClassNotFoundException, SQLException
    {
    	Connection connection = getConnection();
    	String sql ="SELECT username FROM USERS";
    	Statement stmt = connection.createStatement();
    	ResultSet rs = stmt.executeQuery(sql);
	 	ResultSetMetaData rsmd = rs.getMetaData();
	 	while(rs.next())
	 	{
	 		if(user.getUsername().equals(rs.getString("username"))) 
	 		{
	 			return true;
	 		}
	 	}
	 	connection.close();
	 	return false;

    }
    public boolean RegisterUser(Users user) throws ClassNotFoundException, SQLException
    {
    	boolean check = false;
    	Connection connection = getConnection();
    	String sql = "INSERT INTO `users` (`ID`, `username`, `password`, `displayname`, `status`, `imageURL`) VALUES (NULL, ?, ?, ?, 'offline', 'default');";
    	PreparedStatement ps = connection.prepareStatement(sql);
    	
    	ps.setString(1, user.getUsername());
    	ps.setString(2, user.getPassword());
    	ps.setString(3, user.getDisplayname());
    	
    	check = ps.executeUpdate() > 0;
    	
    	connection.close();
    	return check;
    }
    public boolean ChangeStatus(Users user) throws ClassNotFoundException, SQLException
    {
    	boolean check = false;
    	Connection connection = getConnection();
    	String sql ="UPDATE `users` SET `status` = ? WHERE `users`.`ID` = ?";
    	PreparedStatement ps = connection.prepareStatement(sql);
    	
    	ps.setString(1,user.getStatus());
    	ps.setInt(2, user.getID());
    	check = ps.executeUpdate() > 0;
    	connection.close();
    	return check;
    }
    public boolean ChangeDisplayname(Users user) throws ClassNotFoundException, SQLException
    {
    	boolean check = false;
    	Connection connection = getConnection();
    	String sql ="UPDATE `users` SET `displayname` = ? WHERE `users`.`ID` = ?";
    	PreparedStatement ps = connection.prepareStatement(sql);
    	
    	ps.setString(1,user.getDisplayname());
    	ps.setInt(2, user.getID());
    	check = ps.executeUpdate() > 0;
    	connection.close();
    	return check;
    }
    public boolean ChangeImageURL(Users user) throws ClassNotFoundException, SQLException
    {
    	boolean check = false;
    	Connection connection = getConnection();
    	String sql ="UPDATE `users` SET `imageURL` = ? WHERE `users`.`ID` = ?";
    	PreparedStatement ps = connection.prepareStatement(sql);
    	
    	ps.setString(1, user.getImageURL());
    	ps.setInt(2, user.getID());
    	check = ps.executeUpdate() > 0;
    	connection.close();
    	return check;
    }
    public boolean InsertCurrentUser(Users user, String idDevice) throws ClassNotFoundException, SQLException
    {
    	boolean check = false;
    	Connection connection = getConnection();
    	String sql ="INSERT INTO `currentuser` (`idDevice`, `ID_User`) VALUES (?, ?)";
    	PreparedStatement ps = connection.prepareStatement(sql);
    	
    	ps.setString(1, idDevice);
    	ps.setInt(2, user.getID());
    	
    	check = ps.executeUpdate() > 0;
    	
    	return check;
    }
    public boolean DeleteCurrentUser(CurrentUser currentUser) throws ClassNotFoundException, SQLException
    {
    	boolean check = false;
    	Connection connection = getConnection();
    	String sql ="DELETE FROM `currentuser` WHERE `currentuser`.`idDevice` = ?";
    	PreparedStatement ps = connection.prepareStatement(sql);
    	
    	ps.setString(1, currentUser.getIdDevice());
    	
    	check = ps.executeUpdate() > 0;
    	
    	return check;
    }
    public boolean checkCurrentUser(CurrentUser currentUser) throws SQLException, ClassNotFoundException
    {
    	boolean check = false;
    	Connection connection = getConnection();
    	
    	String sql_CurrentUser ="SELECT * FROM `currentuser` WHERE idDevice=?";
    	
    	PreparedStatement ps = connection.prepareStatement(sql_CurrentUser);
    	ps.setString(1, currentUser.getIdDevice());
    	ResultSet rs = ps.executeQuery();
    	while(rs.next())
	 	{
	 		if(currentUser.getIdDevice().equals(rs.getString("idDevice"))) 
	 		{
	 			return true;
	 		}
	 	}
	 	connection.close();
	 	return false;
    	
    }
    public int getIDbyUsername(Users user) throws ClassNotFoundException, SQLException
    {
    	Connection connection = getConnection();
    	String sql ="select id from users where username=?";
    	PreparedStatement ps = connection.prepareStatement(sql);
    	ps.setString(1, user.getUsername());
    	
    	ResultSet rs = ps.executeQuery();
    	while(rs.next())
    	{
    		if(rs.getInt("ID") >= 0)
    			return rs.getInt("ID");
    	}
    	connection.close();
    	return -1;
    }
    public int getID_UserbyidDevice(CurrentUser currentUser) throws ClassNotFoundException, SQLException
    {
    	Connection connection = getConnection();
    	String sql ="select `ID_User` from `currentuser` where idDevice=?";
    	PreparedStatement ps = connection.prepareStatement(sql);
    	ps.setString(1, currentUser.getIdDevice());
    	
    	ResultSet rs = ps.executeQuery();
    	while(rs.next())
    	{
    		if(rs.getInt("ID_User") >= 0)
    			return rs.getInt("ID_User");
    	}
    	return -1;
    }
    
    public String getDisplaynamebyUsername(Users user) throws ClassNotFoundException, SQLException
    {
    	Connection connection = getConnection();
    	String sql ="select displayname from users where username=?";
    	PreparedStatement ps = connection.prepareStatement(sql);
    	ps.setString(1, user.getUsername());
    	
    	ResultSet rs = ps.executeQuery();
    	while(rs.next())
    	{
    		if(rs.getString("displayname") != "")
    			return rs.getString("displayname");
    	}
    	return null;
    }
    public boolean PasswordChange(Users user) throws ClassNotFoundException, SQLException
    {
    	boolean check = false;
    	Connection connection = getConnection();
    	String sql ="UPDATE `users` SET `password` = ? WHERE `users`.`ID` = ?";
    	PreparedStatement ps = connection.prepareStatement(sql);
    	
    	ps.setString(1, user.getPassword());
    	ps.setInt(2, user.getID());
    	
    	check = ps.executeUpdate() > 0;
    	
    	return check;
    }
    public Users getUserbyID(Users user) throws SQLException, ClassNotFoundException
    {
    	Users getUser = new Users();
    	Connection connection = getConnection();
    	String sql_CurrentUser ="SELECT * FROM `Users` WHERE ID=?";
    	
    	PreparedStatement ps = connection.prepareStatement(sql_CurrentUser);
    	ps.setInt(1, user.getID());
    	
    	ResultSet rs = ps.executeQuery();
    	
    	while(rs.next())
    	{
    		getUser = new Users(rs.getInt("ID"), rs.getString("username"), rs.getString("password")
    				,rs.getString("displayname"), rs.getString("status"), rs.getString("imageURL"));
    	}
    	connection.close();
    	return getUser;
    }
    public String PasswordEncode(String password) throws NoSuchAlgorithmException
    {
    	MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
//    public ArrayList<Chats> checkisNew(Chats chat) throws ClassNotFoundException, SQLException
//    {
//    	Connection connection = getConnection();
//    	String sql_checkisNew ="select value from isNew where ID = 1";
//    	
//    	Statement stmt;
//    	ResultSet rs;
//    	while(true)
//    	{
//    		stmt = connection.createStatement();
//    		rs = stmt.executeQuery(sql_checkisNew);
//    		while(rs.next())
//    		{
//    			if(rs.getInt("value") == 1)
//    			{
//    				Statement stmt1 = connection.createStatement();
//    				stmt1.executeUpdate("UPDATE isNew SET VALUE = '0' WHERE ID='1'");
//    				stmt1.close();
//    				return getChatsNew(chat);
//    			}
//    		}
//    		stmt.close();
//            rs.close();
//    	}
//    	
//    }
//    public ArrayList<Chats> getChatsNew(Chats chat) throws SQLException, ClassNotFoundException
//    {
//    	Connection connection = getConnection();
//    	ArrayList<Chats> mchat = new ArrayList<Chats>();
//    	
//    	String sql_getChats ="SELECT * FROM `chats` WHERE (Sender = ? and Receiver = ?) or (Sender = ? and Receiver = ?)";
//    	
//    	PreparedStatement ps = connection.prepareStatement(sql_getChats);
//    	
//    	ps.setInt(1, chat.getId_Sender());
//    	ps.setInt(2, chat.getId_Receiver());
//    	ps.setInt(3, chat.getId_Receiver());
//    	ps.setInt(4, chat.getId_Sender());
//    	
//    	ResultSet rs = ps.executeQuery();
//    	
//    	while(rs.next())
//    	{
//    		mchat.add(new Chats(rs.getInt("Sender"), rs.getInt("Receiver"), rs.getString("Message")));
//    	}
//    	connection.close();
//    	return mchat;
//    }
    
    public ArrayList<Chats> getAllChat(Chats chat) throws SQLException, ClassNotFoundException{
    	Connection connection = getConnection();
    	ArrayList<Chats> mchat = new ArrayList<Chats>();
    	
    	String sql_getChats ="SELECT * FROM `chats` WHERE (Sender = ? and Receiver = ?) or (Sender = ? and Receiver = ?)";
    	PreparedStatement ps = connection.prepareStatement(sql_getChats);
    	
    	ps.setInt(1, chat.getSender());
    	ps.setInt(2, chat.getReceiver());
    	ps.setInt(3, chat.getReceiver());
    	ps.setInt(4, chat.getSender());
    	
    	ResultSet rs = ps.executeQuery();
    	
    	while(rs.next())
        {
        	mchat.add(new Chats(rs.getInt("sender"), rs.getInt("receiver"), rs.getString("message")));
        }
    	
        connection.close();
    	
    	return mchat;
    }
    
    
    public ArrayList<Users> getAllUsers() throws SQLException, ClassNotFoundException
    {
    	Connection connection = getConnection();
    	ArrayList<Users> Users = new ArrayList<Users>();
    	
    	String sql_getAllUsers ="SELECT * FROM `users` ";
    	
    	Statement stmt = connection.createStatement();
    	
    	ResultSet rs = stmt.executeQuery(sql_getAllUsers);
    	
    	while(rs.next())
    	{
    		Users.add(new Users(rs.getInt("ID"), rs.getString("username"), rs.getString("password")
    				,rs.getString("displayname"), rs.getString("status"), rs.getString("imageURL")));
    	}
    	connection.close();
    	return Users;
    }
    public boolean InsertChats(Chats chat) throws ClassNotFoundException, SQLException
    {
    	boolean check = false;
    	Connection connection = getConnection();
    	
    	String sql_InsertChats ="INSERT INTO `chats` (`ID`, `Sender`, `Receiver`, `Message`) VALUES (NULL, ?,?,?);";
    	
    	PreparedStatement ps = connection.prepareStatement(sql_InsertChats);
    	
    	ps.setInt(1, chat.getSender());
    	ps.setInt(2, chat.getReceiver());
    	ps.setString(3, chat.getMessage());
    	
    	check = ps.executeUpdate() > 0;
    	
    	connection.close();
    	return check;
    }
    
                
       // user is new
    public boolean setUserTableState(String state) throws ClassNotFoundException, SQLException
    {
    	boolean check = false;
    	Connection connection = getConnection();    	
    	String query ="UPDATE isusernew set value='"+state+"'";
    	PreparedStatement ps = connection.prepareStatement(query);
    	check = ps.executeUpdate() > 0;
    	connection.close();
    	return check;
    }
    
    public String getUserTableState() throws ClassNotFoundException, SQLException
    {
    	String result="";
    	Connection connection = getConnection();    	
    	String query ="Select * from isusernew";
    	Statement stmt = connection.createStatement();
    	
    	ResultSet rs = stmt.executeQuery(query);
    	
    	while(rs.next())
    	{
    		result = rs.getString("value");
    	}
    	connection.close();
    	return result;
    }
    
    // chat is new
    public boolean setChatTableState(String state) throws ClassNotFoundException, SQLException
    {
    	boolean check = false;
    	Connection connection = getConnection();    	
    	String query ="UPDATE ischatnew set value='"+state+"'";
    	PreparedStatement ps = connection.prepareStatement(query);
    	check = ps.executeUpdate() > 0;
    	connection.close();
    	return check;
    }
    public String getChatTableState() throws ClassNotFoundException, SQLException
    {
    	String result="";
    	Connection connection = getConnection();    	
    	String query ="Select * from ischatnew";
    	Statement stmt = connection.createStatement();
    	
    	ResultSet rs = stmt.executeQuery(query);
    	
    	while(rs.next())
    	{
    		result = rs.getString("value");
    	}
    	connection.close();
    	return result;
    }              
}

