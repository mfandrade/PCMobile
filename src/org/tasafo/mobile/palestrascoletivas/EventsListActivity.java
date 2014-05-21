package org.tasafo.mobile.palestrascoletivas;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

import java.io.*;
import java.util.*;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import org.json.*;

public class EventsListActivity extends Activity {

	private static final String EVENTS_ENDPOINT = "http://179.215.196.50:3000/events.json";
	private ListView _eventsListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events_list);

		new Updater().execute(EVENTS_ENDPOINT);

		_eventsListView = (ListView) findViewById(R.id.events_list);
		_eventsListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int pos,
					long id) {
				Intent gotoEvent = new Intent(EventsListActivity.this,
						EventActivity.class);
				Event event = (Event) adapter.getItemAtPosition(pos);
				gotoEvent.putExtra("selected", event);
				startActivity(gotoEvent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.main_menu_new:
			Toast.makeText(this, "Disponível na próxima versão", Toast.LENGTH_LONG).show();
			break;
		case R.id.main_menu_refresh:
			new Updater().execute(EVENTS_ENDPOINT);
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	class Updater extends AsyncTask<String, Void, List<Event>> {

		private ProgressDialog progress;

		@Override
		protected List<Event> doInBackground(String... params) {
			String url = params[0];
			List<Event> ret = null;

			HttpClient client = new DefaultHttpClient();
			HttpGet req = new HttpGet(url);
			try {
				HttpResponse res = client.execute(req);
				HttpEntity entity = res.getEntity();
				if (entity != null) {
					InputStream in = entity.getContent();
					String json = toString(in);
					in.close();
					ret = getEventsList(json);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return ret;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			progress = ProgressDialog.show(EventsListActivity.this, "Por favor, aguarde...", "Atualizando eventos.");
		}

		@Override
		protected void onPostExecute(List<Event> res) {
			super.onPostExecute(res);

			progress.dismiss();
			if (res != null) {
				ArrayAdapter<Event> adapter = new ArrayAdapter<Event>(EventsListActivity.this, android.R.layout.simple_list_item_1, res);
				_eventsListView.setAdapter(adapter);

			} else {
				AlertDialog.Builder builder = new AlertDialog.Builder(EventsListActivity.this)
					.setTitle("Atenção!")
					.setMessage("Não foi possível acessar os eventos.")
					.setPositiveButton("OK", null);
				builder.show();
			}
		}

		private List<Event> getEventsList(String json) {
			List<Event> ret = null;
			try {
				JSONArray events = new JSONArray(json);
				JSONObject event = null;
				ret = new LinkedList<Event>();
				for (int i = 0; i < events.length(); i++) {
					event = events.getJSONObject(i);
					ret.add(new Event(event));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return ret;
		}

		private String toString(InputStream in) throws IOException {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			byte[] buffer = new byte[1024];
			int qtd = 0;
			while ((qtd = in.read(buffer)) > 0) {
				baos.write(buffer, 0, qtd);
			}
			return new String(baos.toByteArray());
		}
	}
}
