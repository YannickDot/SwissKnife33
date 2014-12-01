package com.enseirb.swissknife33.converter;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;

import android.content.Context;

import com.enseirb.swissknife33.business.model.Toilet;
import com.enseirb.swissknife33.dao.DAOFactory;
import com.enseirb.swissknife33.dao.model.ToiletDTO;
import com.enseirb.swissknife33.exception.Swissknife33Exception;

public class ToiletConverter {
	
	private DAOFactory daoFactory = new DAOFactory();
	private Context context;
	
	public ToiletConverter(Context context){
		this.context = context;
	}

	public List<Toilet> fetch() throws Swissknife33Exception {

		List<ToiletDTO> toiletsDTO = null;
		List<Toilet> toilets = new LinkedList<Toilet>();

		try {
			toiletsDTO = daoFactory.getToiletDAO(context).fetch();
			for (ToiletDTO t : toiletsDTO) {
				toilets.add(toToilet(t));
			}
		} catch (JSONException e) {
			throw new Swissknife33Exception();
		}

		return toilets;
	}

	private Toilet toToilet(ToiletDTO t) {
		Toilet toilet = new Toilet()
		.setKey(Integer.valueOf(t.getKey()))
		.setAddress(t.getAddress())
		.setName(t.getName())
		.setNeighborhood(t.getNeighborhood())
		.setTypology(t.getTypology())
		.setLongitude(Double.valueOf(t.getLongitude()))
		.setLatitude(Double.valueOf(t.getLatitude()));
		
		return toilet;
	}
}
