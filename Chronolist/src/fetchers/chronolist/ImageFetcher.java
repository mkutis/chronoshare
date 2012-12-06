package fetchers.chronolist;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.MediaStore.MediaColumns;
import android.text.format.DateUtils;

public class ImageFetcher {
	
	public String[] photos = null;
	
	
	public ImageFetcher(Context context, long time){
		photos = getPhotos(context, time);
	}
	
	public String[] getPhotos(Context context, long time){
		
		Uri images = MediaStore.Images.Media.INTERNAL_CONTENT_URI; //sets the place to look for images
		
		if(android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)){
			images = MediaStore.Images.Media.EXTERNAL_CONTENT_URI; //switches to SD card if available
		}
		
		Cursor c= context.getContentResolver().query(images, null, null, null, null);	
		long nextday = time + DateUtils.DAY_IN_MILLIS;
	
		String[] photos = new String[c.getCount()];
		photos[0] = "to be replaced";
		  
		if(c.moveToFirst()){
	        for(int i=0 ; i < c.getCount();  i++){
	        
	        	long taken = c.getLong(c.getColumnIndex(MediaColumns.DATE_ADDED))*1000; 
	        	//database only records the taken date in seconds; need to change to milliseconds, so we multi by 1000
	        	
	        	if(taken > time && taken < nextday){
	        		//needs to be changed so that stuff keeps getting added to the list
	        		photos[0]= c.getString(c.getColumnIndex(MediaColumns.DATA)).toString(); 
	        	}
	        
	            c.moveToNext();		
	        }
	
	        c.close();
		}
		
		if(photos[0].contains("to be replaced")){ //if the fetcher doesn't find any photos for the particular day
			photos = null; 
		}
		
		return photos;
		
		
	}

}
