package com.enseirb.swissknife33.presenter;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.enseirb.swissknife33.R;
import com.enseirb.swissknife33.business.model.Parking;
import com.enseirb.swissknife33.business.model.PersonalItem;
import com.enseirb.swissknife33.presenter.ui.FetchParkingListener;
import com.enseirb.swissknife33.presenter.ui.FetchPersonalItemListener;
import com.google.android.gms.maps.MapFragment;

public class MainActivity extends Activity implements
NavigationDrawerFragment.NavigationDrawerCallbacks,
FetchParkingListener, 
FetchPersonalItemListener{
//,
//FetchNestListener,
// ... 

	private NavigationDrawerFragment mNavigationDrawerFragment;

	private CheckBox toiletsBox;
	private CheckBox parkingsBox;
	private CheckBox nestsBox;
	private CheckBox defibrillatorsBox;
	private CheckBox personalBox;

	private GoogleMapManager googleMapManager; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);

		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));

		toiletsBox = (CheckBox) findViewById(R.id.toiletsBox);
		parkingsBox = (CheckBox) findViewById(R.id.parkingsBox);
		nestsBox = (CheckBox) findViewById(R.id.nestsBox);
		defibrillatorsBox = (CheckBox) findViewById(R.id.defibrillatorsBox);
		personalBox = (CheckBox) findViewById(R.id.personalItemBox);
		// Getting reference to map
		MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
		googleMapManager = new GoogleMapManager(mapFragment, this);

		checkBoxJob();

		// Getting Parking data. See bottom of the code to tell how to process it

	}
	
	@Override
	public void onNavigationDrawerItemSelected(int position) {

	}

	public void checkBoxJob(){
		toiletsBoxJob();
		parkingsBoxJob();
		nestsBoxJob();
		defibrillatorsBoxJob();
		personalBoxJob();
	}
	
	private void toiletsBoxJob() {
		toiletsBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(toiletsBox.isChecked()){
					toiletsBox.setText("Toilets checked");
				}
				else{
					toiletsBox.setText("Toilets unchecked");
				}
			}
		});
	}

	private void parkingsBoxJob() {
		parkingsBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(parkingsBox.isChecked()){
					googleMapManager.showParkingMarkers();
				}
				else{
					//REmove parking markers
					googleMapManager.hideParkingMarkers();
				}				
			}
		});
	}
	
	private void nestsBoxJob() {
		nestsBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(nestsBox.isChecked()){
					nestsBox.setText("Nests checked");
				}
				else{
					nestsBox.setText("Nests unchecked");
				}
			}
		});
	}

	private void defibrillatorsBoxJob() {
		defibrillatorsBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(defibrillatorsBox.isChecked()){
					defibrillatorsBox.setText("Defibrillators checked");
				}
				else{
					defibrillatorsBox.setText("Defibrillators unchecked");
				}
			}
		});		
	}
	
	private void personalBoxJob() {
		personalBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(personalBox.isChecked()){
					googleMapManager.showPersonalMarkers();
				}
				else{
					googleMapManager.hidePersonalMarkers();
				}
			}
		});		
	}
	
	public void activatePersonalMarkers(){
		personalBox.setActivated(true);
	}
	
	@Override
	public void onFetchParkingsSuccess(List<Parking> parkings) {
		//TODO Display parkings data
		updateParkings(parkings);
	}

	@Override
	public void onFetchParkingsError() {
		//TODO Display error
		System.out.println("An error occured while fetching parkings.");
	}
	
	@Override
	public void onWaitForParkings() {
		//TODO Display wait message
		System.out.println("Fetching parkings.");
	}
	
	//TODO display parkings data
	private void updateParkings(List<Parking> parkings) {
		System.out.println(parkings.size() + " parkings fetched !");
		for (Parking p : parkings) {
			System.out.println(p.toString());
		}
		googleMapManager.renderParkingMarkers(parkings);
	}

	@Override
	public void onWaitForPersonalItems() {
		// TODO Auto-generated method stub
		System.out.println("Fetching personalItems.");
		
	}

	@Override
	public void onFetchPersonalItemsSuccess(List<PersonalItem> personalItems) {
		// TODO Auto-generated method stub
		updatePersonalItems(personalItems);
		
	}

	@Override
	public void onFetchPersonalItemsError() {
		// TODO Auto-generated method stub
		System.out.println("An error occured while fetching personalItems.");
		
	}
	
	private void updatePersonalItems(List<PersonalItem> personalItems) {
		System.out.println(personalItems.size() + " personalItems fetched !");
		for (PersonalItem p : personalItems) {
			System.out.println(p.toString());
		}
	}
}
