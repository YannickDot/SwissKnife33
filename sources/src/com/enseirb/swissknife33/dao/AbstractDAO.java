package com.enseirb.swissknife33.dao;

import com.enseirb.swissknife33.parser.AbstractParser;

public abstract class AbstractDAO <T> {
	public String URL = "";
	public AbstractParser<?> parser = null;
}
