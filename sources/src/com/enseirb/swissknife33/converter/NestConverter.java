package com.enseirb.swissknife33.converter;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;

import android.content.Context;

import com.enseirb.swissknife33.business.model.Nest;
import com.enseirb.swissknife33.dao.DAOFactory;
import com.enseirb.swissknife33.dao.model.NestDTO;
import com.enseirb.swissknife33.exception.Swissknife33Exception;

public class NestConverter {
	
	private DAOFactory daoFactory = new DAOFactory();
	private Context context;
	
	public NestConverter(Context context){
		this.context = context;
	}

	public List<Nest> fetch() throws Swissknife33Exception {

		List<NestDTO> nestsDTO = null;
		List<Nest> nests = new LinkedList<Nest>();

		try {
			nestsDTO = daoFactory.getNestDAO(context).fetch();
			for (NestDTO n : nestsDTO) {
				nests.add(toNest(n));
			}
		} catch (JSONException e) {
			throw new Swissknife33Exception();
		}

		return nests;
	}

	private Nest toNest(NestDTO n) {
		Nest nest = new Nest()
		.setKey(Integer.valueOf(n.getKey()))
		.setShelter_type(n.getShelter_type())
		.setTargeted_species(n.getTargeted_species())
		.setName(n.getName())
		.setLongitude(Double.valueOf(n.getLongitude()))
		.setLatitude(Double.valueOf(n.getLatitude()));
		
		return nest;
	}
}
