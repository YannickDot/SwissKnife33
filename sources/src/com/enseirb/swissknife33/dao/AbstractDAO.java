package com.enseirb.swissknife33.dao;

import com.enseirb.swissknife33.dao.model.AbstractDTO;
import com.enseirb.swissknife33.parser.AbstractParser;

public abstract class AbstractDAO <T extends AbstractDTO> {
	
	public String URL = "";
	public AbstractParser<T> parser = null;
}
