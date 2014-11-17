package com.enseirb.swissknife33.dao.model;



public class ParkingDTO extends AbstractDTO{
	private String cle;
    private String domanialite;
    private String nature;
    private String nom;
    private String nombre_de_places;
    private String x_long;
    private String y_lat;
    
	public void setCle(String cle) {
		this.cle = cle;
	}

	public void setDomanialite(String domanialite) {
		this.domanialite = domanialite;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNombre_de_places(String nombre_de_places) {
		this.nombre_de_places = nombre_de_places;
	}

	public void setX_long(String x_long) {
		this.x_long = x_long;
	}

	public void setY_lat(String y_lat) {
		this.y_lat = y_lat;
	}

	public ParkingDTO(){
		
		
	}
}
