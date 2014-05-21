package org.tasafo.mobile.palestrascoletivas;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class EventActivity extends Activity {

	private Event _event;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event);

		Intent intent = getIntent();
		_event = (Event) intent.getExtras().get("selected");
		((TextView) findViewById(R.id.event_name)).setText(_event.getName().toUpperCase(Locale.getDefault()));
		((TextView) findViewById(R.id.event_edition)).setText(_event.getEdition().toUpperCase(Locale.getDefault()));
		SimpleDateFormat extense = new SimpleDateFormat("d 'de' MMMM 'de' yyyy", Locale.getDefault());
		((TextView) findViewById(R.id.event_date)).setText(extense.format(_event.getDate()));
		((TextView) findViewById(R.id.event_place)).setText(_event.getPlace());
		((TextView) findViewById(R.id.event_description)).setText(_event.getDescription());
		// getSupportActionBar().setUpAsHomeEnabled();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.event_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		  case R.id.event_menu_map:
			  Intent gotoMap = new Intent(Intent.ACTION_VIEW);
		  	gotoMap.setData(Uri.parse("geo:0,0?z=15&q=" + _event.getAddress()));
			  startActivity(gotoMap);
				break;
	    case R.id.event_menu_schedule:
				Toast.makeText(this, "Disponível na próxima versão", Toast.LENGTH_LONG).show();
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}
