package org.tasafo.mobile.palestrascoletivas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class EventActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_event);

	Intent intent = getIntent();
	Event event = (Event) intent.getExtras().get("selected");
	((TextView) findViewById(R.id.event_name)).setText(event.getName());
	((TextView) findViewById(R.id.event_place)).setText(event.getPlace());
	((TextView) findViewById(R.id.event_date)).setText(event.getDate().toString());
	((TextView) findViewById(R.id.event_description)).setText(event.getDescription());

	// getSupportActionBar().setUpAsHomeEnabled();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.event, menu);
	return true;
    }
}
