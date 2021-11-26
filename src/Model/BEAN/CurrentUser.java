package Model.BEAN;

public class CurrentUser {
	private String idDevice;
	private int ID_User;
	public String getIdDevice() {
		return idDevice;
	}
	public void setIdDevice(String idDevice) {
		this.idDevice = idDevice;
	}
	public int getID_User() {
		return ID_User;
	}
	public void setID_User(int iD_User) {
		ID_User = iD_User;
	}
	public CurrentUser(String idDevice,int ID_User)
	{
		this.idDevice = idDevice;
		this.ID_User = ID_User;
	}
	public CurrentUser(String idDevice)
	{
		this.idDevice = idDevice;
	}

}
