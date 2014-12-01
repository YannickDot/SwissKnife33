package com.enseirb.swissknife33.converter;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;

import android.content.Context;

import com.enseirb.swissknife33.business.model.Defibrillator;
import com.enseirb.swissknife33.dao.DAOFactory;
import com.enseirb.swissknife33.dao.model.DefibrillatorDTO;
import com.enseirb.swissknife33.exception.Swissknife33Exception;

public class DefibrillatorConverter {
	
	private DAOFactory daoFactory = new DAOFactory();
	private Context context;
	
	public DefibrillatorConverter(Context context){
		this.context = context;
	}

	public List<Defibrillator> fetch() throws Swissknife33Exception {

		List<DefibrillatorDTO> defibrillatorsDTO = null;
		List<Defibrillator> defibrillators = new LinkedList<Defibrillator>();

		try {
			defibrillatorsDTO = daoFactory.getDefibrillatorDAO(context).fetch();
			for (DefibrillatorDTO d : defibrillatorsDTO) {
				defibrillators.add(toDefibrillator(d));
			}
		} catch (JSONException e) {
			throw new Swissknife33Exception();
		}

		return defibrillators;
	}

	private Defibrillator toDefibrillator(DefibrillatorDTO d) {

		//TODO: Invalid float exception to fix here ....
		//Number is too large for float representation
		
		Defibrillator defibrillator = new Defibrillator()
		.setKey(Integer.valueOf(d.getKey()))
		.setAddress(d.getAddress())
		.setTown(d.getTown())
		.setZip_code(d.getZip_code())
		.setName(d.getName())
		.setPhone(d.getPhone())
		.setTypology(d.getTypology())
		.setInstalled(d.getInstalled())
		.setInformation(d.getInformation())
		.setLongitude(Double.valueOf(d.getLongitude()))
		.setLatitude(Double.valueOf(d.getLatitude()));
		
		return defibrillator;
	}
}
