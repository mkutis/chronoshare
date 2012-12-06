package parser.chronolist;

import timeline.chronolist.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DayAdapter extends ArrayAdapter<Day> {
	

	
	Context context;
	int layoutResourceId;
	Day daylist[] = null;
	
	public DayAdapter(Context context, int layoutResourceId, Day[] daylist){
		super(context, layoutResourceId, daylist);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.daylist = daylist;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		View row = convertView;
		DayHolder holder = null;
		
		if(row == null){
		       LayoutInflater inflater = ((Activity)context).getLayoutInflater();
	           row = inflater.inflate(layoutResourceId, parent, false);
	           
	           holder = new DayHolder();
	           holder.date = (TextView)row.findViewById(R.id.date);
	           holder.sender = (TextView)row.findViewById(R.id.sender);
	           holder.body = (TextView)row.findViewById(R.id.body);
	           holder.sender2 = (TextView)row.findViewById(R.id.sender2);
	           holder.body2 = (TextView)row.findViewById(R.id.body2);
	           holder.photo = (ImageView)row.findViewById(R.id.imageView1);
	           holder.appoint = (TextView)row.findViewById(R.id.appointment);
	           holder.call = (TextView)row.findViewById(R.id.call);
	           
	           
	           
	           row.setTag(holder);
		}
		else{
			holder = (DayHolder)row.getTag();
		}
		
		Day day = daylist[position];
		holder.date.setText(day.date);
		
		
	
		holder.sender.setVisibility(View.VISIBLE);
		holder.body.setVisibility(View.VISIBLE);
		holder.sender2.setVisibility(View.VISIBLE);
		holder.body2.setVisibility(View.VISIBLE);
		//holder.appoint.setVisibility(View.GONE);
		holder.call.setVisibility(View.GONE);
		
		
		
		
		if(day.messages.length > 1){
			holder.sender.setText(day.messages[0].sender);
			holder.body.setText(day.messages[0].body);
			holder.sender2.setText(day.messages[1].sender);
			holder.body2.setText(day.messages[1].body);
		}
		if(day.messages.length == 1){
			holder.sender.setText(day.messages[0].sender);
			holder.body.setText(day.messages[0].body);
			holder.sender2.setVisibility(View.GONE);
			holder.body2.setVisibility(View.GONE);
		}
		if(day.messages.length == 0){
			holder.sender.setVisibility(View.GONE);
			holder.body.setVisibility(View.GONE);
			holder.sender2.setVisibility(View.GONE);
			holder.body2.setVisibility(View.GONE);
		}
	
		
		
		if(day.photos != null){
			Bitmap bm = BitmapFactory.decodeFile(day.photos[0]);
			holder.photo.setImageBitmap(Bitmap.createScaledBitmap(bm, 144, 144, false));
			holder.photo.setVisibility(View.VISIBLE);
		}
		else{
			holder.photo.setVisibility(View.GONE);
		}
		
		if(holder.appoint != null){
			holder.appoint.setText(day.appointment);
			holder.appoint.setVisibility(View.VISIBLE);
		}
		
		if(day.calls != null){
			holder.call.setText(day.calls[0]);
			holder.call.setVisibility(View.VISIBLE);
		}
		
		return row;
		
	}
	
	static class DayHolder{
		TextView date;
		TextView sender;
		TextView body;
		TextView sender2;
		TextView body2;
		ImageView photo;
		TextView appoint;
		TextView call;
	}

}
