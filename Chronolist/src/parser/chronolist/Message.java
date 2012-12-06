package parser.chronolist;

//a simple class for messages to hold all the information associated with an SMS

public class Message {
	
	public String sender, body, time;
	
	
	public Message(){
		super();
		sender = "";
		body = "";
		time = "0";
	}
	
	public Message(String sender, String body, String time){
		this.sender = sender;
		this.body = body;
		this.time = time;
	}
	

}
