package com.enseirb.swissknife33.dao;

import com.enseirb.swissknife33.parser.ParkingParser;

public class DAOFactory {

	private static final String WEBSERVICE_URL_PREFIX= "http://odata.bordeaux.fr/v1/databordeaux/";

	public ParkingDAO getParkingDAO() {
		ParkingDAO dao = new ParkingDAO(WEBSERVICE_URL_PREFIX + "sigparkpub/?format=json",
										new ParkingParser());
		return dao;
	}
}
