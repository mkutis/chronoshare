package fetchers.chronolist;

import java.sql.Date;
import java.util.HashSet;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.format.DateUtils;

public class Calendarfaux{
	
	public long lDate;
	public String appointment;
	
	public Calendarfaux(Context context, long lDate){
		appointment = fetch(context, lDate);
	}
	
	public String fetch(Context context, long lDate){
		
	    	//convert the input date into a string of millisecond
	    	//Long lDate = takenDate.getTime();
	    	String sDate = String.valueOf(lDate);
	    	
	    	// Fetch a list of all calendars synced with the device, their display names and whether the
			// user has them selected for display.
	    	ContentResolver contentResolver = context.getContentResolver();
	        final Cursor cursor = contentResolver.query(Uri.parse("content://com.android.calendar/calendars"),
	                (new String[] { "_id", "displayName", "selected" }), null, null, null);
	
	        HashSet<String> calendarIds = new HashSet<String>();                    
	        while (cursor.moveToNext()) {                       
	            final String _id = cursor.getString(0);
	            final String displayName = cursor.getString(1);
	            final Boolean selected = !cursor.getString(2).equals("0");                      
	            //System.out.println("Id: " + _id + " Display Name: " + displayName + " Selected: " + selected);
	            calendarIds.add(_id);
	        }
	    	
	     
	     // For each calendar, fetch all the events from start of the day to the end of the day.
	    StringBuilder displayText = new StringBuilder();
		for (String id : calendarIds) {
			Uri.Builder builder = Uri.parse("content://com.android.calendar/instances/when").buildUpon();
			ContentUris.appendId(builder, lDate);
			ContentUris.appendId(builder, lDate + DateUtils.DAY_IN_MILLIS);

			Cursor eventCursor = contentResolver.query(builder.build(),
					new String[] { "title", "begin", "end", "allDay"}, "Calendars._id=" + id,
					null, "startDay ASC, startMinute ASC"); 
			// For a full list of available columns see http://tinyurl.com/yfbg76w
	
			while (eventCursor.moveToNext()) {
				final String title = eventCursor.getString(0);
				final Date begin = new Date(eventCursor.getLong(1));
				final Date end = new Date(eventCursor.getLong(2));
				final Boolean allDay = !eventCursor.getString(3).equals("0");
				
				displayText.append("Title: " + title + " Begin: " + begin + " End: " + end +
						" All Day: " + allDay);
			}
		}
		return displayText.toString();
	
	}
}