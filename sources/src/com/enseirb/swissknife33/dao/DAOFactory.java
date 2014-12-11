package com.enseirb.swissknife33.dao;

import android.content.Context;

import com.enseirb.swissknife33.parser.CheckBoxStateParser;
import com.enseirb.swissknife33.parser.DefibrillatorParser;
import com.enseirb.swissknife33.parser.NestParser;
import com.enseirb.swissknife33.parser.ParkingParser;
import com.enseirb.swissknife33.parser.PersonalItemParser;
import com.enseirb.swissknife33.parser.ToiletParser;

public class DAOFactory {

	private static final String WEBSERVICE_URL_PREFIX= "http://odata.bordeaux.fr/v1/databordeaux/";
	private static final String FORMAT_JSON = "/?format=json";
	private static final String PARKING_URL = "sigparkpub";
	private static final String DEFIBRILATOR_URL = "defibrillateurs";
	private static final String NEST_URL = "abrisfaune";
	private static final String TOILET_URL = "sigsanitaire";

	public ParkingDAO getParkingDAO(Context context) {
		ParkingDAO dao = new ParkingDAO(WEBSERVICE_URL_PREFIX + PARKING_URL + FORMAT_JSON,
				new ParkingParser(), context);
		return dao;
	}

	public PersonalItemDAO getPersonalItemDAO(Context context) {
		PersonalItemDAO dao = new PersonalItemDAO(new PersonalItemParser(), 
				context);
		return dao;
	}

	public DefibrillatorDAO getDefibrillatorDAO(Context context) {
		DefibrillatorDAO dao = new DefibrillatorDAO(WEBSERVICE_URL_PREFIX + DEFIBRILATOR_URL + FORMAT_JSON, 
				new DefibrillatorParser(), context);
		return dao;
	}

	public NestDAO getNestDAO(Context context) {
		NestDAO dao = new NestDAO(WEBSERVICE_URL_PREFIX + NEST_URL + FORMAT_JSON, 
				new NestParser(), context);
		return dao;
	}

	public ToiletDAO getToiletDAO(Context context) {
		ToiletDAO dao = new ToiletDAO(WEBSERVICE_URL_PREFIX + TOILET_URL + FORMAT_JSON, 
				new ToiletParser(), context);
		return dao;
	}

	public CheckBoxStateDAO getCheckBoxStateDAO(Context context) {
		CheckBoxStateDAO dao = new CheckBoxStateDAO(new CheckBoxStateParser(), 
				context);
		return dao;
	}
}
