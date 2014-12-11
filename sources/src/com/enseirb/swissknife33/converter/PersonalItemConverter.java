package com.enseirb.swissknife33.converter;

import java.util.ArrayList;
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

		List<PersonalItemDTO> personalItemsDTO = new ArrayList<PersonalItemDTO>();
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
	
	public int save(List<PersonalItem> personalItems) throws Swissknife33Exception{
		List<PersonalItemDTO> personalItemsDTO = new LinkedList<PersonalItemDTO>();
		int saved = 0;
		
		try {
			for (PersonalItem p : personalItems) {
				personalItemsDTO.add(toPersonalItemDTO(p));
			}
			saved = daoFactory.getPersonalItemDAO(context).save(personalItemsDTO);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return saved;
	}

	private PersonalItem toPersonalItem(PersonalItemDTO p) {
		PersonalItem personalItem = new PersonalItem()
		.setKey(Integer.valueOf(p.getKey()))
		.setName(p.getName())
		.setLongitude(Double.valueOf(p.getLongitude()))
		.setLatitude(Double.valueOf(p.getLatitude()));
		
		return personalItem;
	}
	
	private PersonalItemDTO toPersonalItemDTO(PersonalItem p) {
		PersonalItemDTO personalItemDTO = new PersonalItemDTO()
		.setKey(String.valueOf(p.getKey()))
		.setName(p.getName())
		.setLongitude(String.valueOf(p.getLongitude()))
		.setLatitude(String.valueOf(p.getLatitude()));
		
		return personalItemDTO;
	}
}
