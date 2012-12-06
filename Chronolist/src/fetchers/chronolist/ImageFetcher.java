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
		//photos = new String[]{"234"};
	}
	
	public String[] getPhotos(Context context, long time){
		
		Uri images = MediaStore.Images.Media.INTERNAL_CONTENT_URI; //sets the place to look for images
		
		if(android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)){
			images = MediaStore.Images.Media.EXTERNAL_CONTENT_URI; //switches to SD card if available
		}
		
		Cursor c= context.getContentResolver().query(images, null, null, null, null);	
		//System.out.println("****" + time + "****");
		//System.out.println(DateUtils.DAY_IN_MILLIS);
		long nextday = time + DateUtils.DAY_IN_MILLIS;
		//System.out.println(nextday);
		
		String[] photos = new String[c.getCount()];
		photos[0] = "to be replaced";
		  
		if(c.moveToFirst()){
	        for(int i=0 ; i < c.getCount();  i++){
	        
	        	long taken = c.getLong(c.getColumnIndex(MediaColumns.DATE_ADDED))*1000;
	        	//System.out.println(taken);
	        	
	        	
	        	if(taken > time && taken < nextday){
	        		//needs to be changed so that stuff keeps getting added to the list
	        		photos[0]= c.getString(c.getColumnIndex(MediaColumns.DATA)).toString(); 
	        	}
	        
	            c.moveToNext();		
	        }
	
	        c.close();
		}
		
		if(photos[0].contains("to be replaced")){
			photos = null; 
		}
		
		return photos;
		
		
	}

}
