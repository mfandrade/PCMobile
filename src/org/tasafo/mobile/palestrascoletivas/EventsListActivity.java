package org.tasafo.mobile.palestrascoletivas;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class EventsListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_events_list);

	List<Event> list = new FakeEventsDatasource().getAll();
	ArrayAdapter<Event> adapter = new ArrayAdapter<Event>(this, android.R.layout.simple_list_item_1, list);
	ListView eventsList = (ListView) findViewById(R.id.events_list);
	eventsList.setAdapter(adapter);

	eventsList.setOnItemClickListener(new OnItemClickListener() {

	    @Override
	    public void onItemClick(AdapterView<?> adapter, View view, int pos, long id) {
		Toast.makeText(view.getContext(), adapter.getItemAtPosition(pos).toString(), Toast.LENGTH_SHORT).show();
	    }
	});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
    }
}
