package parser.chronolist;

public class Day {
	
	public String date;
	public Message[] messages = new Message[2];
	public String[] photos = new String[3];
	
	public Day(){
		super();
		date = "January 30th, 1970";
		Message firstmess = new Message();
		messages[0] = firstmess;
		messages[1] = firstmess;
	}
	
	public Day(String date, Message[] messages, String[] photos){
		super();
		this.date = date;
		this.messages = messages;
		this.photos = photos;
 		
		
	}

}
