package fetchers.chronolist;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.MediaStore.MediaColumns;

public class ImageFetcher {
	
	public String[] photos = null;
	
	
	public ImageFetcher(Context context){
		photos = getPhotos(context);
		//photos = new String[]{"234"};
	}
	
	public String[] getPhotos(Context context){
		
		Uri images = MediaStore.Images.Thumbnails.INTERNAL_CONTENT_URI;
		
		if(android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)){
			images = MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
		}
		
		
		
	    
		Cursor c= context.getContentResolver().query(images, null, null, null, null);	
		
		String[] photos = new String[c.getCount()];
		  
		if(c.moveToFirst()){
	        for(int i=0 ; i < c.getCount();  i++){
	                photos[i]= c.getString(c.getColumnIndex(MediaColumns.DATA)).toString();
	                c.moveToNext();		
	        }
	
	        c.close();
		}
		
		return photos;
		
		
	}

}
