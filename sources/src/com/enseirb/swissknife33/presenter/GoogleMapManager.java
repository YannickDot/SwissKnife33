package com.enseirb.swissknife33.presenter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.enseirb.swissknife33.business.BusinessFactory;
import com.enseirb.swissknife33.business.model.Parking;
import com.enseirb.swissknife33.business.model.PersonalItem;
import com.enseirb.swissknife33.presenter.ui.FetchParkingListener;
import com.enseirb.swissknife33.presenter.ui.FetchPersonalItemListener;
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


	@Override
	public void onMapLongClick(LatLng pos) {
		float color = BitmapDescriptorFactory.HUE_VIOLET;
		String markerTitle = "My marker";

		MarkerOptions marker = new MarkerOptions()
		.icon(BitmapDescriptorFactory.defaultMarker(color))
		.anchor(0.0f, 1.0f)
		.title(markerTitle)
		.position(pos);

		showPersonalMarkers();
		personalMarkers.add(map.addMarker(marker));

		//context.activatePersonalMarkers(); ??
		//save marker to storage

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
	
	
	/* 	
	color = BitmapDescriptorFactory.HUE_CYAN;
	color = BitmapDescriptorFactory.HUE_BLUE;
	color = BitmapDescriptorFactory.HUE_RED;
	color = BitmapDescriptorFactory.HUE_GREEN;
	color = BitmapDescriptorFactory.HUE_YELLOW;
	color = BitmapDescriptorFactory.HUE_VIOLET;
	 */

}
