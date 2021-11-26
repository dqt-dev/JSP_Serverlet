package Model.BEAN;

public class Chats {
	private int sender, receiver, Id;
	private String message;
	
	public Chats(int Id_Sender,int Id_Receiver, String Mess )
	{
		this.sender = Id_Sender;
		this.receiver = Id_Receiver;
		this.message = Mess;
	}
	
	public Chats(int Id_Sender,int Id_Receiver)
	{
		this.sender = Id_Sender;
		this.receiver = Id_Receiver;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
