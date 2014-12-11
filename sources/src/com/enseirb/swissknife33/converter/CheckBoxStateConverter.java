package com.enseirb.swissknife33.converter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;

import android.content.Context;

import com.enseirb.swissknife33.business.model.CheckBoxState;
import com.enseirb.swissknife33.dao.DAOFactory;
import com.enseirb.swissknife33.dao.model.CheckBoxStateDTO;
import com.enseirb.swissknife33.exception.Swissknife33Exception;

public class CheckBoxStateConverter {
	
	private DAOFactory daoFactory = new DAOFactory();
	private Context context;

	public CheckBoxStateConverter(Context context){
		this.context = context;
	}

	public List<CheckBoxState> fetch() throws Swissknife33Exception {

		List<CheckBoxStateDTO> checkBoxStateDTO = new ArrayList<CheckBoxStateDTO>();
		List<CheckBoxState> checkBoxStates = new LinkedList<CheckBoxState>();

		try {
			checkBoxStateDTO = daoFactory.getCheckBoxStateDAO(context).fetch();
			for (CheckBoxStateDTO p : checkBoxStateDTO) {
				checkBoxStates.add(toCheckBoxState(p));
			}
		} catch (JSONException e) {
			throw new Swissknife33Exception();
		}

		return checkBoxStates;
	}

	public int save(List<CheckBoxState> checkBoxStates) throws Swissknife33Exception{
		List<CheckBoxStateDTO> checkBoxStateDTO = new LinkedList<CheckBoxStateDTO>();
		int saved = 0;

		try {
			for (CheckBoxState p : checkBoxStates) {
				checkBoxStateDTO.add(toCheckBoxStateDTO(p));
			}
			saved = daoFactory.getCheckBoxStateDAO(context).save(checkBoxStateDTO);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return saved;
	}

	private CheckBoxState toCheckBoxState(CheckBoxStateDTO p) {
		CheckBoxState checkBoxState = new CheckBoxState()
				.setName(p.getName())
				.setState(Boolean.valueOf(p.getState()));

		return checkBoxState;
	}

	private CheckBoxStateDTO toCheckBoxStateDTO(CheckBoxState p) {
		CheckBoxStateDTO checkBoxStateDTO = new CheckBoxStateDTO()
		.setState(String.valueOf(p.getState()))
		.setName(p.getName());

		return checkBoxStateDTO;
	}
}
