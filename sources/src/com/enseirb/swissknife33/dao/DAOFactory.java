package com.enseirb.swissknife33.dao;

import com.enseirb.swissknife33.parser.ParkingParser;

public class DAOFactory {

	private static final String WEBSERVICE_URL_PREFIX= "http://odata.bordeaux.fr/v1/databordeaux/";
	private static final String FORMAT_JSON = "/?format=json";
	private static final String PARKING_URL = "sigparkpub";

	public ParkingDAO getParkingDAO() {
		ParkingDAO dao = new ParkingDAO(WEBSERVICE_URL_PREFIX + PARKING_URL + FORMAT_JSON,
										new ParkingParser());
		return dao;
	}
}
