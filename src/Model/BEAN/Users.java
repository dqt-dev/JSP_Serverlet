package Model.BEAN;

public class Users {
	private int ID;
	private String displayname,password,username,status,imageURL;

	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Users(String username, String password, String displayname)
	{
		this.username = username;
		this.password = password;
		this.displayname = displayname;
	}
	
	public Users(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	public Users(String username)
	{
		this.username = username;
	}
	public Users(int ID, String username, String password, String Displayname)
	{
		this.ID =ID;
		this.username = username;
		this.password = password;
		this.displayname = Displayname;
	}
	public Users(int ID, String username, String password, String Displayname,String Status,String imageURL)
	{
		this.ID =ID;
		this.username = username;
		this.password = password;
		this.displayname = Displayname;
		this.status = Status;
		this.imageURL = imageURL;
	}
	
	public Users(int ID)
	{
		this.ID =ID;
	}
	public Users(int ID,String Status,String ImageURL)
	{
		this.ID =ID;
		this.status = Status;
		this.imageURL =ImageURL;
	}
	public Users()
	{
	}
}
