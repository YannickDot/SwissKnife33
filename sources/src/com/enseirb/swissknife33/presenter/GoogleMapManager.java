package com.enseirb.swissknife33.presenter;

import java.util.List;

import android.content.Context;

import com.enseirb.swissknife33.business.model.Parking;
import com.enseirb.swissknife33.business.model.PersonalItem;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapManager implements OnMapLongClickListener {
	
	private GoogleMap map;
	private int zoomLevel = 15;
	private LatLng centreBordeaux = new LatLng(44.842409, -0.574470);
	public Context context;

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
			map.addMarker(new MarkerOptions()
			.icon(BitmapDescriptorFactory.defaultMarker(color))
			.anchor(0.0f, 1.0f)
			.title(item.getName())
			.position(new LatLng(item.getLatitude(), item.getLongitude()))
			);
		}
	}
	
	public void renderPersonalItemMarkers(List<PersonalItem> list){
		float color = BitmapDescriptorFactory.HUE_RED;
		
		for(PersonalItem item : list) {
			map.addMarker(new MarkerOptions()
			.icon(BitmapDescriptorFactory.defaultMarker(color))
			.anchor(0.0f, 1.0f)
			.title(item.getName())
			.position(new LatLng(item.getLatitude(), item.getLongitude()))
			);
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
	
		map.addMarker(marker);
		//save marker to storage
		
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
