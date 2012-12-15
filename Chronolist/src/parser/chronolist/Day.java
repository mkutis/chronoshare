package parser.chronolist;


//holds all the content for a certain day, like October 23, 2012. 
public class Day {
	
	public String date, appointment;
	public Message[] messages = new Message[2];
	public String[] photos = new String[3];
	public String[] calls = new String[2];
	
	public Day(){
		super();
		date = "January 30th, 1970";
		Message firstmess = new Message();
		messages[0] = firstmess;
		messages[1] = firstmess;
		appointment = "lolnothingtoday";
		calls[0] = "no one loves you";
	}
	
	public Day(String date, Message[] messages, String[] photos, String appointment, 
			String[] calls){
		super();
		this.date = date;
		this.messages = messages;
		this.photos = photos;
 		this.appointment = appointment;
 		this.calls = calls;
		
	}

}
