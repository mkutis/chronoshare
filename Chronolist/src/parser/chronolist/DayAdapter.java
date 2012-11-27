package parser.chronolist;

import timeline.chronolist.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
	           
	           row.setTag(holder);
		}
		else{
			holder = (DayHolder)row.getTag();
		}
		
		Day day = daylist[position];
		holder.date.setText(day.date);
		
		return row;
		
	}
	
	static class DayHolder{
		TextView date;
	}

}
