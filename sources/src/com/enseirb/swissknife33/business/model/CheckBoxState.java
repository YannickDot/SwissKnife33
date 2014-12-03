package com.enseirb.swissknife33.business.model;

public class CheckBoxState {
	private String name; 
	private boolean state;
	public String getName() {
		return name;
	}
	public CheckBoxState setName(String name) {
		this.name = name;
		return this;
	}
	public boolean getState() {
		return state;
	}
	public CheckBoxState setState(boolean state) {
		this.state = state;
		return this;
	}
}
