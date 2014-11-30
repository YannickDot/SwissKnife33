package com.enseirb.swissknife33.presenter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.enseirb.swissknife33.business.BusinessFactory;
import com.enseirb.swissknife33.business.model.Defibrillator;
import com.enseirb.swissknife33.business.model.Nest;
import com.enseirb.swissknife33.business.model.Parking;
import com.enseirb.swissknife33.business.model.PersonalItem;
import com.enseirb.swissknife33.business.model.Toilet;
import com.enseirb.swissknife33.presenter.ui.FetchDefibrillatorListener;
import com.enseirb.swissknife33.presenter.ui.FetchNestListener;
import com.enseirb.swissknife33.presenter.ui.FetchParkingListener;
import com.enseirb.swissknife33.presenter.ui.FetchPersonalItemListener;
import com.enseirb.swissknife33.presenter.ui.FetchToiletListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapManager implements OnMapLongClickListener {

	private BusinessFactory businessFactory = new BusinessFactory();
	private GoogleMap map;
	private int zoomLevel = 14;
	private LatLng centreBordeaux = new LatLng(44.842409, -0.574470);
	public Context context;
	
	public ArrayList<Marker> parkingMarkers = new ArrayList<Marker>();
	public ArrayList<Marker> nestMarkers = new ArrayList<Marker>();
	public ArrayList<Marker> toiletMarkers = new ArrayList<Marker>();
	public ArrayList<Marker> defibrillatorMarkers = new ArrayList<Marker>();
	public ArrayList<Marker> personalMarkers = new ArrayList<Marker>();
	
	public ArrayList<PersonalItem> personalItemsList = new ArrayList<PersonalItem>();

	public GoogleMapManager(MapFragment mapFragment, Context context){
		this.map = mapFragment.getMap();
		this.context = context;
		initMap();

		map.setOnMapLongClickListener((OnMapLongClickListener) this); 
	}

	private void initMap() {
		map.setMyLocationEnabled(true);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(centreBordeaux,
				zoomLevel));
	}

	
	//Parkings Methods
	
	public void renderParkingMarkers(List<Parking> list){
		float color = BitmapDescriptorFactory.HUE_CYAN;

		for(Parking item : list) {
			parkingMarkers.add(
					map.addMarker(new MarkerOptions()
					.icon(BitmapDescriptorFactory.defaultMarker(color))
					.anchor(0.0f, 1.0f)
					.title(item.getName())
					.position(new LatLng(item.getLatitude(), item.getLongitude()))
							));
		}
	}

	public void showParkingMarkers(){
		if(parkingMarkers.isEmpty()){
			businessFactory.getParkingBusiness(context, (FetchParkingListener) context)
			.createFetchParkingsAsyncTask().execute();
		}
		else{
			for(Marker marker : parkingMarkers){
				marker.setVisible(true);
			}
		}
	}

	public void hideParkingMarkers(){
		for(Marker marker : parkingMarkers){
			marker.setVisible(false);
		}
	}

	//Personal Methods
	
	public void renderPersonalItemMarkers(List<PersonalItem> list){
		float color = BitmapDescriptorFactory.HUE_RED;

		for(PersonalItem item : list) {
			personalMarkers.add(
					map.addMarker(new MarkerOptions()
					.icon(BitmapDescriptorFactory.defaultMarker(color))
					.anchor(0.0f, 1.0f)
					.title(item.getName())
					.position(new LatLng(item.getLatitude(), item.getLongitude()))
							));;
		}
	}

	public void showPersonalMarkers(){
		if(personalMarkers.isEmpty()){
			//businessFactory.getPersonalItemBusiness(context, (FetchPersonalItemListener) context)
			//.createFetchPersonalItemsAsyncTask().execute();
		}
		else{
			for(Marker marker : personalMarkers){
				marker.setVisible(true);
			}
		}
	}

	public void hidePersonalMarkers(){
		for(Marker marker : personalMarkers){
			marker.setVisible(false);
		}
	}
	
	//Defibrillators Markers 
	
	public void renderDefibrillatorMarkers(List<Defibrillator> list){
		float color = BitmapDescriptorFactory.HUE_RED;

		for(Defibrillator item : list) {
			defibrillatorMarkers.add(
					map.addMarker(new MarkerOptions()
					.icon(BitmapDescriptorFactory.defaultMarker(color))
					.anchor(0.0f, 1.0f)
					.title(item.getName())
					.position(new LatLng(item.getLatitude(), item.getLongitude()))
							));;
		}
	}

	public void showDefibrillatorMarkers(){
		if(defibrillatorMarkers.isEmpty()){
			//businessFactory.getDefibrillatorBusiness(context, (FetchDefibrillatorListener) context)
			//.createFetchDefibrillatorsAsyncTask().execute();
		}
		else{
			for(Marker marker : defibrillatorMarkers){
				marker.setVisible(true);
			}
		}
	}

	public void hideDefibrillatorMarkers(){
		for(Marker marker : defibrillatorMarkers){
			marker.setVisible(false);
		}
	}
	
	//Nests Methods 
	
	public void renderNestMarkers(List<Nest> list){
		float color = BitmapDescriptorFactory.HUE_GREEN;

		for(Nest item : list) {
			nestMarkers.add(
					map.addMarker(new MarkerOptions()
					.icon(BitmapDescriptorFactory.defaultMarker(color))
					.anchor(0.0f, 1.0f)
					.title(item.getName())
					.position(new LatLng(item.getLatitude(), item.getLongitude()))
							));;
		}
	}

	public void showNestMarkers(){
		if(nestMarkers.isEmpty()){
			businessFactory.getNestBusiness(context, (FetchNestListener) context)
			.createFetchNestsAsyncTask().execute();
		}
		else{
			for(Marker marker : defibrillatorMarkers){
				marker.setVisible(true);
			}
		}
	}

	public void hideNestMarkers(){
		for(Marker marker : nestMarkers){
			marker.setVisible(false);
		}
	}
	
	//Toilets Methods 
	
	public void renderToiletMarkers(List<Toilet> list){
		float color = BitmapDescriptorFactory.HUE_YELLOW;

		for(Toilet item : list) {
			toiletMarkers.add(
					map.addMarker(new MarkerOptions()
					.icon(BitmapDescriptorFactory.defaultMarker(color))
					.anchor(0.0f, 1.0f)
					.title(item.getName())
					.position(new LatLng(item.getLatitude(), item.getLongitude()))
							));;
		}
	}

	public void showToiletMarkers(){
		if(defibrillatorMarkers.isEmpty()){
			businessFactory.getToiletBusiness(context, (FetchToiletListener) context)
			.createFetchToiletsAsyncTask().execute();
		}
		else{
			for(Marker marker : toiletMarkers){
				marker.setVisible(true);
			}
		}
	}

	public void hideToiletMarkers(){
		for(Marker marker : toiletMarkers){
			marker.setVisible(false);
		}
	}
	
	
	/* 	
	color = BitmapDescriptorFactory.HUE_CYAN;
	color = BitmapDescriptorFactory.HUE_BLUE;
	color = BitmapDescriptorFactory.HUE_RED;
	color = BitmapDescriptorFactory.HUE_GREEN;
	color = BitmapDescriptorFactory.HUE_YELLOW;
	color = BitmapDescriptorFactory.HUE_VIOLET;
	 */
	
	@Override
	public void onMapLongClick(LatLng pos) {
		float color = BitmapDescriptorFactory.HUE_VIOLET;
		String markerTitle = "My marker";

		MarkerOptions marker = new MarkerOptions()
		.icon(BitmapDescriptorFactory.defaultMarker(color))
		.anchor(0.0f, 1.0f)
		.title(markerTitle)
		.position(pos);
		
		PersonalItem personalItem = new PersonalItem()
		.setKey(0)
		.setName(markerTitle)
		.setLongitude((float) pos.longitude)
		.setLatitude((float) pos.latitude);

		showPersonalMarkers();
		personalMarkers.add(map.addMarker(marker));
		personalItemsList.add(personalItem);
		

		//context.activatePersonalMarkers(); ??
		//save marker to storage
		//businessFactory.getPersonalItemBusiness(context, (FetchPersonalItemListener) context)
		//.createSavePersonalItemsAsyncTask(personalItemsList).execute();

	}

}
