package com.enseirb.swissknife33.converter;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;

import android.content.Context;

import com.enseirb.swissknife33.business.model.PersonalItem;
import com.enseirb.swissknife33.dao.DAOFactory;
import com.enseirb.swissknife33.dao.model.PersonalItemDTO;
import com.enseirb.swissknife33.exception.Swissknife33Exception;

public class PersonalItemConverter {
	private DAOFactory daoFactory = new DAOFactory();
	private Context context;
	
	public PersonalItemConverter(Context context){
		this.context = context;
	}

	public List<PersonalItem> fetch() throws Swissknife33Exception {

		List<PersonalItemDTO> personalItemsDTO = null;
		List<PersonalItem> personalItems = new LinkedList<PersonalItem>();

		try {
			personalItemsDTO = daoFactory.getPersonalItemDAO(context).fetch();
			for (PersonalItemDTO p : personalItemsDTO) {
				personalItems.add(toPersonalItem(p));
			}
		} catch (JSONException e) {
			throw new Swissknife33Exception();
		}

		return personalItems;
	}

	private PersonalItem toPersonalItem(PersonalItemDTO p) {
		PersonalItem personalItem = new PersonalItem()
		.setKey(Integer.valueOf(p.getKey()))
		.setName(p.getName())
		.setLongitude(Float.valueOf(p.getLongitude()))
		.setLatitude(Float.valueOf(p.getLatitude()));
		
		return personalItem;
	}

}
