package com.enseirb.swissknife33.dao.model;

public class ToiletsDTO extends AbstractDTO{
	private String cle;
	private String adresse;
	private String nom;
	private String quartier;
	private String typologie;
	private String x_long;
	private String y_lat;
	public void setCle(String cle) {
		this.cle = cle;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}
	public void setTypologie(String typologie) {
		this.typologie = typologie;
	}
	public void setX_long(String x_long) {
		this.x_long = x_long;
	}
	public void setY_lat(String y_lat) {
		this.y_lat = y_lat;
	}
	
}
