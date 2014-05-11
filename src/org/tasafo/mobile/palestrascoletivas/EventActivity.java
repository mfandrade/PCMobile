package org.tasafo.mobile.palestrascoletivas;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

import java.text.*;
import java.util.*;

public class EventActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event);

		Intent intent = getIntent();
		Event event = (Event) intent.getExtras().get("selected");
		((TextView) findViewById(R.id.event_name)).setText(event.getName().toUpperCase(Locale.getDefault()));
		((TextView) findViewById(R.id.event_edition)).setText(event.getEdition().toUpperCase(Locale.getDefault()));
		SimpleDateFormat extense = new SimpleDateFormat("d 'de' MMMM 'de' yyyy", Locale.getDefault());
		((TextView) findViewById(R.id.event_date)).setText(extense.format(event.getDate()));
		((TextView) findViewById(R.id.event_place)).setText(event.getPlace());
		((TextView) findViewById(R.id.event_description)).setText(event.getDescription());
		// getSupportActionBar().setUpAsHomeEnabled();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.event_menu, menu);
		return true;
	}
}
