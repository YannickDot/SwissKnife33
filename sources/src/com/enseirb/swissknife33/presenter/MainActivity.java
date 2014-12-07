package com.enseirb.swissknife33.presenter;

import java.util.ArrayList;
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
import android.widget.Toast;

import com.enseirb.swissknife33.R;
import com.enseirb.swissknife33.business.BusinessFactory;
import com.enseirb.swissknife33.business.model.CheckBoxState;
import com.enseirb.swissknife33.business.model.Defibrillator;
import com.enseirb.swissknife33.business.model.Nest;
import com.enseirb.swissknife33.business.model.Parking;
import com.enseirb.swissknife33.business.model.PersonalItem;
import com.enseirb.swissknife33.business.model.Toilet;
import com.enseirb.swissknife33.dao.utils.Storage;
import com.enseirb.swissknife33.presenter.ui.FetchCheckBoxStateListener;
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
FetchDefibrillatorListener,
FetchCheckBoxStateListener{
	private static final String PERSONAL_ITEMS_DELETED_STR = "Personal Items deleted.";

	private static final String PERSONAL_ITEMS = "personalItems";

	private static final String DEFIBRILLATORS = "defibrillators";

	private static final String NESTS = "nests";

	private static final String PARKINGS = "parkings";

	private static final String TOILETS = "toilets";

	//,
	//FetchNestListener,
	// ... 
	public static BusinessFactory businessFactory = new BusinessFactory();

	private NavigationDrawerFragment mNavigationDrawerFragment;

	private CheckBox toiletsBox;
	private CheckBox parkingsBox;
	private CheckBox nestsBox;
	private CheckBox defibrillatorsBox;
	private CheckBox personalBox;
	private Button clearButton;

	private List<CheckBoxState> checkBoxStateList = new ArrayList<CheckBoxState>();
	
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
		clearButtonJob();
		updateCheckBoxState();
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
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
				saveCheckBoxStates();
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
				saveCheckBoxStates();
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
				saveCheckBoxStates();
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
				saveCheckBoxStates();
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
				saveCheckBoxStates();
				if(personalBox.isChecked()){
					googleMapManager.showPersonalMarkers();
				}
				else{
					googleMapManager.hidePersonalMarkers();
				}
			}
		});		
	}

	public void saveCheckBoxStates(){
		initCheckBoxStateList();
		businessFactory.getCheckBoxStateBusiness(this, (FetchCheckBoxStateListener) this)
		.createSaveCheckBoxStatesAsyncTask(checkBoxStateList).execute();
	}
	
	private void initCheckBoxStateList(){
		CheckBoxState toiletsBoxState = new CheckBoxState().setName(TOILETS)
				.setState(toiletsBox.isChecked());
		CheckBoxState parkingsBoxState = new CheckBoxState().setName(PARKINGS)
				.setState(parkingsBox.isChecked());
		CheckBoxState nestsBoxState = new CheckBoxState().setName(NESTS)
				.setState(nestsBox.isChecked());
		CheckBoxState defibrillatorsBoxState = new CheckBoxState().setName(DEFIBRILLATORS)
				.setState(defibrillatorsBox.isChecked());
		CheckBoxState personalItemsBoxState = new CheckBoxState().setName(PERSONAL_ITEMS)
				.setState(personalBox.isChecked());
		checkBoxStateList.clear();
		checkBoxStateList.add(toiletsBoxState);
		checkBoxStateList.add(parkingsBoxState);
		checkBoxStateList.add(nestsBoxState);
		checkBoxStateList.add(defibrillatorsBoxState);
		checkBoxStateList.add(personalItemsBoxState);
	}
	
	private void clearButtonJob(){
		final Context that = this;
		clearButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Storage st = new Storage(that);
				st.remove(Storage.PERSISTENCE_KEY_PERSONAL_ITEM);
				googleMapManager.removePersonnalItem();
				
				Context context = getApplicationContext();
				String toastText = PERSONAL_ITEMS_DELETED_STR;
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, toastText, duration);
				toast.show();
			}
		});
	}
	
	
	private void updateCheckBoxState(){
		businessFactory.getCheckBoxStateBusiness(this, this)
		.createFetchCheckBoxStatesAsyncTask().execute();
	}
	
	
	
	public void activatePersonalMarkers(){
		personalBox.setChecked(true);
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
		googleMapManager.renderPersonalItemMarkers(personalItems);
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



	@Override
	public void onWaitForCheckBoxStates() {
		// TODO Auto-generated method stub
		System.out.println("Fetching checkboxes states.");
	}

	@Override
	public void onFetchCheckBoxStatesSuccess(List<CheckBoxState> data) {
		// TODO Auto-generated method stub
		setCheckBoxState(data);
	}

	private void setCheckBoxState(List<CheckBoxState> data) {
		// TODO Auto-generated method stub
		for (CheckBoxState cbs : data){
			if(TOILETS.equals(cbs.getName())){
				toiletsBox.setChecked(cbs.getState());
			}
			else if(PARKINGS.equals(cbs.getName())){
				parkingsBox.setChecked(cbs.getState());
			}
			else if(NESTS.equals(cbs.getName())){
				nestsBox.setChecked(cbs.getState());
			}
			else if(DEFIBRILLATORS.equals(cbs.getName())){
				defibrillatorsBox.setChecked(cbs.getState());
			}
			else if(PERSONAL_ITEMS.equals(cbs.getName())){
				personalBox.setChecked(cbs.getState());
			}
		}
	}

	@Override
	public void onFetchCheckBoxStatesError() {
		// TODO Auto-generated method stub
		System.out.println("An error occured while fetching checkboxes states.");

	}
}
