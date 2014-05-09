package org.tasafo.mobile.palestrascoletivas;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class ConsumirJSON extends Activity {

	private EditText edtWeather;

	@Override
	protected void onCreate(Bundle state) {
		super.onCreate(state);
		edtWeather = new EditText(this);

		new DownloadJSON().execute("Belem", "Brasil");
		setContentView(edtWeather);
	}

	class DownloadJSON extends AsyncTask<String, Void, Weather> {

		private ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog = ProgressDialog.show(ConsumirJSON.this, "Aguarde",
					"Por favor, aguarde...");
		}

		@Override
		protected Weather doInBackground(String... params) {

			String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + params[0] + "," + params[1];

			Weather ret = null;

			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(urlString);
			try {
				HttpResponse res = client.execute(get);
				HttpEntity entity = res.getEntity();
				if (entity != null) {
					InputStream in = entity.getContent();
					String json = toString(in);
					in.close();
					ret = getWeather(json);
				}
			} catch (Exception e) {
				Log.e("DEBUG", "Falha ao acessar o webservice", e);
			}
			return ret;
		}

		private String toString(InputStream in) throws IOException {
			byte[] bytes = new byte[1024];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int lidos = 0;
			while ((lidos = in.read(bytes)) > 0) {
				baos.write(bytes, 0, lidos);
			}
			return new String(baos.toByteArray());
		}

		@Override
		protected void onPostExecute(Weather result) {
			super.onPostExecute(result);

			dialog.dismiss();
			if (result != null) {
				edtWeather.setText(result.toString());
			} else {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						ConsumirJSON.this).setTitle("Atenção")
						.setMessage("Não foi possível acessar os dados...")
						.setPositiveButton("OK", null);
				builder.show();
			}
		}

		private Weather getWeather(String json) {
			Weather weather = null;
			try {
				JSONObject jsonWeather = new JSONObject(json);
				weather = new Weather();
				weather.name = jsonWeather.getString("name");
				weather.base = jsonWeather.getString("base");
			} catch (JSONException e) {
				Log.e("DEBUG", e.getMessage());
			}
			return weather;
		}
	}

}

class Weather {
	public String name;
	public String base;

	@Override
	public String toString() {
		return name + " (" + base + ")";
	}

}
