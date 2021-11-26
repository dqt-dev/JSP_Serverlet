//package Model.DAO;
//
//import java.sql.*;
//import java.util.ArrayList;
//
//import Model.BEAN.Chats;
//import Model.BEAN.CurrentUser;
//import Model.BEAN.Users;
//
//public class CheckLoginDAO {
//
//    public Connection getConnection() throws ClassNotFoundException, SQLException
//    {
//    	Class.forName("com.mysql.jdbc.Driver");
//		String url ="jdbc:mysql://localhost:3306/CSDL_DA";
//	 	Connection connection = DriverManager.getConnection(url, "root", "");
//	 	
//	 	return connection;
//    }
//	public boolean checkLogin(Users user) throws ClassNotFoundException, SQLException
//    {
//    	Connection connection = getConnection();
//    	
//	 	Statement stmt = connection.createStatement();
//	 	String sql = "SELECT * FROM USERS";
//	 	ResultSet rs = stmt.executeQuery(sql);
//	 	ResultSetMetaData rsmd = rs.getMetaData();
//	 	int ColumnCount = rsmd.getColumnCount();
//	 	
//	 	while(rs.next()){
//	 			if(user.getUsername().equals(rs.getObject("username"))){
//	 				if(user.getPassword().equals(rs.getString("password"))){
//		 		 		return true;
//	 				}
//	 		 	}
//	 	}
//	 	connection.close();
//		return false;
//    }
//    public boolean CheckUserExsit(Users user) throws ClassNotFoundException, SQLException
//    {
//    	Connection connection = getConnection();
//    	String sql ="SELECT username FROM USERS";
//    	Statement stmt = connection.createStatement();
//    	ResultSet rs = stmt.executeQuery(sql);
//	 	ResultSetMetaData rsmd = rs.getMetaData();
//	 	int ColumnCount = rsmd.getColumnCount();
//	 	while(rs.next())
//	 	{
//	 		if(user.getUsername().equals(rs.getString("username"))) 
//	 		{
//	 			return true;
//	 		}
//	 	}
//	 	connection.close();
//	 	return false;
//
//    }
//    public boolean RegisterUser(Users user) throws ClassNotFoundException, SQLException
//    {
//    	boolean check = false;
//    	Connection connection = getConnection();
//    	String sql ="INSERT INTO `users` (`ID`, `username`, `password`, `displayname`) VALUES (NULL,?,?,?);";
//    	PreparedStatement ps = connection.prepareStatement(sql);
//    	
//    	ps.setString(1, user.getUsername());
//    	ps.setString(2, user.getPassword());
//    	ps.setString(3, user.getDisplayname());
//    	
//    	check = ps.executeUpdate() > 0;
//    	
//    	return check;
//    }
//    public boolean InsertCurrentUser(Users user) throws ClassNotFoundException, SQLException
//    {
//    	boolean check = false;
//    	Connection connection = getConnection();
//    	String sql ="INSERT INTO `curentuser` (`idDevice`, `ID_User`) VALUES (NULL, ?)";
//    	PreparedStatement ps = connection.prepareStatement(sql);
//    	
//    	ps.setInt(1, user.getID());
//    	
//    	check = ps.executeUpdate() > 0;
//    	
//    	return check;
//    }
//    public boolean DeleteCurrentUser(CurrentUser currentUser) throws ClassNotFoundException, SQLException
//    {
//    	boolean check = false;
//    	Connection connection = getConnection();
//    	String sql ="DELETE FROM `curentuser` WHERE `curentuser`.`idDevice` = ?";
//    	PreparedStatement ps = connection.prepareStatement(sql);
//    	
//    	ps.setInt(1, currentUser.getIdDevice());
//    	
//    	check = ps.executeUpdate() > 0;
//    	
//    	return check;
//    }
//    public int getIDbyUsername(Users user) throws ClassNotFoundException, SQLException
//    {
//    	Connection connection = getConnection();
//    	String sql ="select id from users where username=?";
//    	PreparedStatement ps = connection.prepareStatement(sql);
//    	ps.setString(1, user.getUsername());
//    	
//    	ResultSet rs = ps.executeQuery();
//    	while(rs.next())
//    	{
//    		if(rs.getInt("ID") >= 0)
//    			return rs.getInt("ID");
//    	}
//    	return -1;
//    }
//    public int getidDevicebyID_User(Users user) throws ClassNotFoundException, SQLException
//    {
//    	Connection connection = getConnection();
//    	String sql ="select idDevice from users where ID_User=?";
//    	PreparedStatement ps = connection.prepareStatement(sql);
//    	ps.setInt(1, user.getID());
//    	
//    	ResultSet rs = ps.executeQuery();
//    	while(rs.next())
//    	{
//    		if(rs.getInt("ID") >= 0)
//    			return rs.getInt("ID");
//    	}
//    	return -1;
//    }
//    public String getDisplaynamebyUsername(Users user) throws ClassNotFoundException, SQLException
//    {
//    	Connection connection = getConnection();
//    	String sql ="select displayname from users where username=?";
//    	PreparedStatement ps = connection.prepareStatement(sql);
//    	ps.setString(1, user.getUsername());
//    	
//    	ResultSet rs = ps.executeQuery();
//    	while(rs.next())
//    	{
//    		if(rs.getString("displayname") != "")
//    			return rs.getString("displayname");
//    	}
//    	return null;
//    }
//    public boolean PasswordChange(Users user) throws ClassNotFoundException, SQLException
//    {
//    	boolean check = false;
//    	Connection connection = getConnection();
//    	String sql ="UPDATE `users` SET `password` = ? WHERE `users`.`ID` = ?";
//    	PreparedStatement ps = connection.prepareStatement(sql);
//    	
//    	ps.setString(1, user.getPassword());
//    	ps.setInt(2, getIDbyUsername(user));
//    	
//    	check = ps.executeUpdate() > 0;
//    	
//    	return check;
//    }
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
//    public ArrayList<Users> getAllUsers() throws SQLException, ClassNotFoundException
//    {
//    	Connection connection = getConnection();
//    	ArrayList<Users> Users = new ArrayList<Users>();
//    	
//    	String sql_getAllUsers ="SELECT * FROM `users` ";
//    	
//    	Statement stmt = connection.createStatement();
//    	
//    	ResultSet rs = stmt.executeQuery(sql_getAllUsers);
//    	
//    	while(rs.next())
//    	{
//    		Users.add(new Users(rs.getInt("ID"), rs.getString("username"), rs.getString("password"),rs.getString("displayname")));
//    	}
//    	connection.close();
//    	return Users;
//    }
//    public boolean InsertChats(Chats chat) throws ClassNotFoundException, SQLException
//    {
//    	boolean check = false;
//    	Connection connection = getConnection();
//    	
//    	String sql_InsertChats ="INSERT INTO `chats` (`ID`, `Sender`, `Receiver`, `Message`) VALUES (NULL, ?,?,?);";
//    	
//    	PreparedStatement ps = connection.prepareStatement(sql_InsertChats);
//    	
//    	ps.setInt(1, chat.getId_Sender());
//    	ps.setInt(2, chat.getId_Receiver());
//    	ps.setString(3, chat.getMess());
//    	
//    	check = ps.executeUpdate() > 0;
//    	
//    	connection.close();
//    	return check;
//    }
//    
//
//}
//
