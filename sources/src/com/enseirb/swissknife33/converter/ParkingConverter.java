package com.enseirb.swissknife33.converter;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;

import android.content.Context;

import com.enseirb.swissknife33.business.model.Parking;
import com.enseirb.swissknife33.dao.DAOFactory;
import com.enseirb.swissknife33.dao.model.ParkingDTO;
import com.enseirb.swissknife33.exception.Swissknife33Exception;

public class ParkingConverter {

	private static final int UNDEFINED = -1;
	private DAOFactory daoFactory = new DAOFactory();
	private Context context;
	
	public ParkingConverter(Context context){
		this.context = context;
	}

	public List<Parking> fetch() throws Swissknife33Exception {

		List<ParkingDTO> parkingsDTO = null;
		List<Parking> parkings = new LinkedList<Parking>();

		try {
			parkingsDTO = daoFactory.getParkingDAO(context).fetch();
			for (ParkingDTO p : parkingsDTO) {
				parkings.add(toParking(p));
			}
		} catch (JSONException e) {
			throw new Swissknife33Exception();
		}

		return parkings;
	}

	private Parking toParking(ParkingDTO p) {
		Parking parking = new Parking()
		.setKey(Integer.valueOf(p.getKey()))
		.setDomaniality(p.getDomaniality())
		.setNature(p.getNature())
		.setName(p.getName())
		.setLongitude(Float.valueOf(p.getLongitude()))
		.setLatitude(Float.valueOf(p.getLatitude()));

		parking = setNumberOfSpaceIfPossible(p, parking);
		
		return parking;
	}

	private Parking setNumberOfSpaceIfPossible(ParkingDTO p, Parking parking) {
		String n = p.getNumberOfSpace();
		if ( n != null && n.isEmpty() == false) {
			return parking.setNumberOfSpace(Integer.valueOf(p.getNumberOfSpace()));
		}
		else {
			return parking.setNumberOfSpace(UNDEFINED);
		}
	}
}
