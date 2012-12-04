package fetchers.chronolist;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class TextFetcher {
	
	public String[] senders = null;
	public String[] body = null;
	public String[] time = null;
	
	public TextFetcher(Context context){
		senders = getSenders(context);
		body = getBody(context);
		time = getTime(context);
		//senders[0] = "Peter";
		//getSenders(context);
	}
	
	public String[] getSenders(Context context){
		Uri uri = Uri.parse("content://sms/inbox");
		Cursor c= context.getContentResolver().query(uri, null, null ,null,null);
		
		String[] number = new String[c.getCount()];
		                
		if(c.moveToFirst()){
		        for(int i=0;i<1000;i++){
		   
		                number[i]=c.getString(c.getColumnIndexOrThrow("address")).toString();
		               // System.out.println(number[i]);
		                c.moveToNext();
		                
		        }
		
		c.close();
		}
		return number;
	}
	
	public String[] getBody(Context context){
		Uri uri = Uri.parse("content://sms/inbox");
		Cursor c= context.getContentResolver().query(uri, null, null ,null,null);
		
		String[] body = new String[c.getCount()];
		                
		if(c.moveToFirst()){
		        for(int i=0;i<1000;i++){
		        	
	
		        	
		                body[i]=c.getString(c.getColumnIndexOrThrow("body")).toString();
		                c.moveToNext();
		        }
		
		c.close();
		}
		return body;
	}
	
	public String[] getTime(Context context){
		Uri uri = Uri.parse("content://sms/inbox");
		Cursor c= context.getContentResolver().query(uri, null, null ,null,null);
		
		String[] time = new String[c.getCount()];
		                
		if(c.moveToFirst()){
		        for(int i=0;i<1000;i++){
		        	
	
		        	
		                time[i]=c.getString(c.getColumnIndexOrThrow("date")).toString();
		                c.moveToNext();
		        }
		
		c.close();
		}
		return time;
	}
	
	

}
