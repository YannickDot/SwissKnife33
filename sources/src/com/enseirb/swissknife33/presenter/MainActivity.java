package com.enseirb.swissknife33.presenter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.enseirb.swissknife33.R;
import com.enseirb.swissknife33.business.model.Defibrillator;
import com.enseirb.swissknife33.business.model.Nest;
import com.enseirb.swissknife33.business.model.Parking;
import com.enseirb.swissknife33.business.model.PersonalItem;
import com.enseirb.swissknife33.business.model.Toilet;
import com.enseirb.swissknife33.dao.utils.Storage;
import com.enseirb.swissknife33.presenter.ui.FetchDefibrillatorListener;
import com.enseirb.swissknife33.presenter.ui.FetchNestListener;
import com.enseirb.swissknife33.presenter.ui.FetchParkingListener;
import com.enseirb.swissknife33.presenter.ui.FetchPersonalItemListener;
import com.enseirb.swissknife33.presenter.ui.FetchToiletListener;
import com.google.android.gms.maps.MapFragment;

public class MainActivity extends Activity implements
NavigationDrawerFragment.NavigationDrawerCallbacks,
FetchParkingListener, 
FetchPersonalItemListener,
FetchToiletListener,
FetchNestListener, 
FetchDefibrillatorListener {
//,
//FetchNestListener,
// ... 

	private NavigationDrawerFragment mNavigationDrawerFragment;

	private CheckBox toiletsBox;
	private CheckBox parkingsBox;
	private CheckBox nestsBox;
	private CheckBox defibrillatorsBox;
	private CheckBox personalBox;
	private Button clearButton;

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
		clearButton = (Button) findViewById(R.id.clearButton);
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
					googleMapManager.showToiletMarkers();
				}
				else{
					googleMapManager.hideToiletMarkers();
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
					googleMapManager.showNestMarkers();
				}
				else{
					googleMapManager.hideNestMarkers();
				}
			}
		});
	}

	private void defibrillatorsBoxJob() {
		defibrillatorsBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(defibrillatorsBox.isChecked()){
					googleMapManager.showDefibrillatorMarkers();
				}
				else{
					googleMapManager.hideDefibrillatorMarkers();
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
	
	
	
	//Parkings methods 
	
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
	
	
	//PersonalItems Methods

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
	
	
	//Defibrillators Methods

	@Override
	public void onWaitForDefibrillators() {
		// TODO Auto-generated method stub
		System.out.println("Fetching defibrillators.");
	}

	@Override
	public void onFetchDefibrillatorsSuccess(List<Defibrillator> defibrillators) {
		// TODO Auto-generated method stub
		updateDefibrillators(defibrillators);
	}

	@Override
	public void onFetchDefibrillatorsError() {
		// TODO Auto-generated method stub
		System.out.println("An error occured while fetching defibrillators.");
		
	}
	
	private void updateDefibrillators(List<Defibrillator> defibrillators) {
		googleMapManager.renderDefibrillatorMarkers(defibrillators);
	}
	
	
	
	//Nests Methods 

	@Override
	public void onWaitForNests() {
		// TODO Auto-generated method stub
		System.out.println("Fetching nests.");
		
	}

	@Override
	public void onFetchNestsSuccess(List<Nest> nests) {
		// TODO Auto-generated method stub
		updateNests(nests);
	}

	@Override
	public void onFetchNestsError() {
		// TODO Auto-generated method stub
		System.out.println("An error occured while fetching nests.");
		
	}
	
	private void updateNests(List<Nest> nests) {
		googleMapManager.renderNestMarkers(nests);
	}
	
	
	
	//Toilets Methods

	@Override
	public void onWaitForToilets() {
		// TODO Auto-generated method stub
		System.out.println("Fetching toilets.");
		
	}
	
	@Override
	public void onFetchToiletsSuccess(List<Toilet> toilets) {
		// TODO Auto-generated method stub
		updateToilets(toilets);
		
	}

	@Override
	public void onFetchToiletsError() {
		// TODO Auto-generated method stub
		System.out.println("An error occured while fetching toilets.");
		
	}
	
	private void updateToilets(List<Toilet> toilets) {
		googleMapManager.renderToiletMarkers(toilets);
	}
	
	private void clearButtonJob(){
		final Context that = this;
		clearButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Storage st = new Storage(that));
				st.rem
			}
		});
	}
}
