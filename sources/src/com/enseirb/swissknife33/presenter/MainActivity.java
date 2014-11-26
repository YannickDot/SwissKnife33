package com.enseirb.swissknife33.presenter;

import java.util.List;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.enseirb.swissknife33.R;
import com.enseirb.swissknife33.business.BusinessFactory;
import com.enseirb.swissknife33.business.model.Parking;
import com.enseirb.swissknife33.business.model.PersonalItem;
import com.enseirb.swissknife33.presenter.ui.FetchParkingListener;
import com.enseirb.swissknife33.presenter.ui.FetchPersonalItemListener;

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

	private BusinessFactory businessFactory = new BusinessFactory();

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

		checkBoxJob();

		// Getting Parking data. See bottom of the code to tell how to process it
		businessFactory.getParkingBusiness(this, this)
			.createFetchParkingsAsyncTask().execute();
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager
		.beginTransaction().commit();
		// TODO Les deux lignes d'en dessous sont à remettre. Ne compilait plus sinon.
		// J'ai peut-être fait une erreur de merge !
		//		.replace(R.id.map,
		//				PlaceholderFragment.newInstance(position + 1)).commit();
	}

	public void checkBoxJob(){
		toiletssBoxJob();
		parkingsBoxJob();
		nestsBoxJob();
		defibrillatorsBoxJob();
	}

	private void nestsBoxJob() {
		nestsBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(nestsBox.isChecked()){
					nestsBox.setText("nests checked");
				}
				else{
					nestsBox.setText("nests unchecked");
				}
			}
		});
	}

	private void defibrillatorsBoxJob() {
		defibrillatorsBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(defibrillatorsBox.isChecked()){
					defibrillatorsBox.setText("defibrillators checked");
				}
				else{
					defibrillatorsBox.setText(" defibrillators unchecked");
				}
			}
		});		
	}

	private void parkingsBoxJob() {
		parkingsBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(parkingsBox.isChecked()){
					parkingsBox.setText("parkings checked");
				}
				else{
					parkingsBox.setText("parkings unchecked");
				}				
			}
		});
	}

	private void toiletssBoxJob() {
		toiletsBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(toiletsBox.isChecked()){
					toiletsBox.setText("toilets checked");
				}
				else{
					toiletsBox.setText("toilets unchecked");
				}
			}
		});
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
	
	//TODO Display parkings data
	private void updateParkings(List<Parking> parkings) {
		System.out.println(parkings.size() + " parkings fetched !");
		for (Parking p : parkings) {
			System.out.println(p.toString());
		}
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
