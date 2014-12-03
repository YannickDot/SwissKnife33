package com.enseirb.swissknife33.presenter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.location.Location;
import android.os.Vibrator;
import android.provider.SyncStateContract.Constants;

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
	private int zoomLevel = 12;
	private LatLng centreBordeaux = new LatLng(44.842409, -0.574470);
	public Context context;
	private Location locationService;
	private LatLng myLocation;
	private Vibrator vibration;
	private int VIBRATION_DURATION = 25;
	
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
		
		this.vibration = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
		map.setOnMapLongClickListener((OnMapLongClickListener) this);
		map.setMyLocationEnabled(true);
		centerMapOnMyLocation();
	}

	private void initMap() {
		map.setMyLocationEnabled(true);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(centreBordeaux,
				zoomLevel));
	}
	
	private void centerMapOnMyLocation() {

	    map.setMyLocationEnabled(true);

	    locationService = map.getMyLocation();

	    if (locationService != null) {
	        myLocation = new LatLng(locationService.getLatitude(),
	                locationService.getLongitude());
	        map.addMarker(new MarkerOptions()
			.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
			.anchor(0.0f, 1.0f)
			.title("MyPos")
			.position(myLocation));
		    map.animateCamera(CameraUpdateFactory.newLatLngZoom(myLocation,16));
	    }
	    
	}

	
	//Parkings Methods
	
	public void renderParkingMarkers(List<Parking> list){

		for(Parking item : list) {
			parkingMarkers.add(
					map.addMarker(new MarkerOptions()
					.icon(BitmapDescriptorFactory.defaultMarker(item.getColor()))
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

		for(PersonalItem item : list) {
			personalMarkers.add(
					map.addMarker(new MarkerOptions()
					.icon(BitmapDescriptorFactory.defaultMarker(item.getColor()))
					.anchor(0.0f, 1.0f)
					.title(item.getName())
					.position(new LatLng(item.getLatitude(), item.getLongitude()))
							));;
		}
	}

	public void showPersonalMarkers(){
		if(personalMarkers.isEmpty()){
			businessFactory.getPersonalItemBusiness(context, (FetchPersonalItemListener) context)
			.createFetchPersonalItemsAsyncTask().execute();
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

		for(Defibrillator item : list) {
			defibrillatorMarkers.add(
					map.addMarker(new MarkerOptions()
					.icon(BitmapDescriptorFactory.defaultMarker(item.getColor()))
					.anchor(0.0f, 1.0f)
					.title(item.getName())
					.position(new LatLng(item.getLatitude(), item.getLongitude()))
							));;
		}
	}

	public void showDefibrillatorMarkers(){
		if(defibrillatorMarkers.isEmpty()){
			businessFactory.getDefibrillatorBusiness(context, (FetchDefibrillatorListener) context)
			.createFetchDefibrillatorsAsyncTask().execute();
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

		for(Nest item : list) {
			nestMarkers.add(
					map.addMarker(new MarkerOptions()
					.icon(BitmapDescriptorFactory.defaultMarker(item.getColor()))
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

		for(Toilet item : list) {
			toiletMarkers.add(
					map.addMarker(new MarkerOptions()
					.icon(BitmapDescriptorFactory.defaultMarker(item.getColor()))
					.anchor(0.0f, 1.0f)
					.title(item.getName())
					.position(new LatLng(item.getLatitude(), item.getLongitude()))
							));;
		}
	}

	public void showToiletMarkers(){
		if(toiletMarkers.isEmpty()){
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
		.setLongitude(pos.longitude)
		.setLatitude(pos.latitude);

		showPersonalMarkers();
		personalMarkers.add(map.addMarker(marker));
		personalItemsList.add(personalItem);
		
		vibration.vibrate(VIBRATION_DURATION);
		
		((MainActivity) context).activatePersonalMarkers();
		
		//save marker to storage
		businessFactory.getPersonalItemBusiness(context, (FetchPersonalItemListener) context)
		.createSavePersonalItemsAsyncTask(personalItemsList).execute();

	}

}
