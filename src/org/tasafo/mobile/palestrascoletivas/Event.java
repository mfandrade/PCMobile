package org.tasafo.mobile.palestrascoletivas;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;

public class Event implements Serializable {

    private static final long serialVersionUID = -7284427379090548417L;
    private String _name;
    private String _edition;
    private String _description;
    private Date _startDate;
    private Integer _days;
    private String _address; // street + district + state + country

    public Event() {
    }

    public Event(String name, String edition, String description, String date, Integer days, String address) {
	setName(name);
	setEdition(edition);
	setDescription(description);
	setDate(date);
	setDays(days);
	setAddress(address);
    }

    public Event(JSONObject json) throws IllegalArgumentException {

	try {
	    setName(json.getString("name"));
	    setEdition(json.getString("edition"));
	    setDescription(json.getString("description"));
	    setDate(json.getString("start_date"));
	    setDays(Integer.parseInt(json.getString("days")));
	    String address = "";
	    String street = json.getString("street");
	    String district = json.getString("district");
	    String state = json.getString("state");
	    String country = json.getString("country");
	    if (street != null) {
		address = street;
	    }
	    if (district != null) {
		address += ", " + district;
	    }
	    if (state != null) {
		address += ", " + state;
	    }
	    if (country != null) {
		address += ", " + country;
	    }
	    setAddress(address);

	} catch (JSONException e) {
	    throw new IllegalArgumentException(e.getMessage());
	}
    }

    @Override
    public String toString() {
	return _name + " - " + _edition;
    }

    public String getName() {
	return _name;
    }

    public void setName(String name) {
	_name = name;
    }

    public String getEdition() {
	return _edition;
    }

    public void setEdition(String edition) {
	_edition = edition;
    }

    public String getDescription() {
	return _description;
    }

    public void setDescription(String description) {
	_description = description;
    }

    public Date getDate() {
	return _startDate;
    }

    public void setDate(Date startDate) {
	_startDate = startDate;

    }

    public void setDate(String ymd) {
	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
	try {
	    _startDate = dateFormatter.parse(ymd);
	} catch (ParseException e) {
	    throw new IllegalArgumentException(e.getMessage());
	}
    }

    public Integer getDays() {
	return _days;
    }

    public void setDays(Integer days) {
	_days = days;
    }

    public String getAddress() {
	return _address;
    }

    public void setAddress(String address) {
	_address = address;
    }

}
