package timeline.chronolist;

import parser.chronolist.Day;
import parser.chronolist.DayAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class Timeline extends Activity {
	
	private ListView listView1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timeline);
		
		Day daylist[] = new Day[]{
				new Day(),
				new Day(),
				new Day(),
				new Day(),
				new Day(),
				new Day(),
				new Day(),
				new Day(),
				new Day(),
				
		};
	
		
		DayAdapter adapter = new DayAdapter(this, R.layout.list_row, daylist);
		
		listView1 = (ListView)findViewById(R.id.listView1);
		
		listView1.setAdapter(adapter);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_timeline, menu);
		return true;
	}

}
