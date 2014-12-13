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
import com.google.android.gms.maps.MapsInitializer;

public class MainActivity extends Activity implements
FetchParkingListener, 
FetchPersonalItemListener,
FetchToiletListener,
FetchNestListener, 
FetchDefibrillatorListener,
FetchCheckBoxStateListener {

	private static final String PERSONAL_ITEMS = "personalItems";

	private static final String DEFIBRILLATORS = "defibrillators";

	private static final String NESTS = "nests";

	private static final String PARKINGS = "parkings";

	private static final String TOILETS = "toilets";

	public BusinessFactory businessFactory = new BusinessFactory();
	private ToastFactory toastFactory = new ToastFactory(this);

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

		initializeNavigationDrawer();
		initializeCheckBoxesAndButtons();
		MapsInitializer.initialize(getApplicationContext());
		initializeMap();

		setCheckBoxesBehaviour();
		setClearPersonalMarkersButtonBehavior();
		
		updateCheckBoxesState();
	}

	private void initializeNavigationDrawer() {
		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);

		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
	}

	private void initializeCheckBoxesAndButtons() {
		toiletsBox = (CheckBox) findViewById(R.id.toiletsBox);
		parkingsBox = (CheckBox) findViewById(R.id.parkingsBox);
		nestsBox = (CheckBox) findViewById(R.id.nestsBox);
		defibrillatorsBox = (CheckBox) findViewById(R.id.defibrillatorsBox);
		personalBox = (CheckBox) findViewById(R.id.personalItemBox);
		clearButton = (Button) findViewById(R.id.clearButton);
	}
	
	private void initializeMap() {
		MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
		googleMapManager = new GoogleMapManager(mapFragment, this);
	}
	
	public void setCheckBoxesBehaviour(){
		setToiletsCheckBoxBehaviour();
		setParkingsCheckBoxBehaviour();
		setNestsCheckBoxBehaviour();
		setDefibrillatorsCheckBoxBehaviour();
		setPersonalMarkersCheckBoxBehaviour();
	}

	private void setToiletsCheckBoxBehaviour() {
		toiletsBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				saveCheckBoxStates();
				if (toiletsBox.isChecked()) {
					googleMapManager.showToiletMarkers();
				} else {
					googleMapManager.hideToiletMarkers();
				}
			}
		});
	}

	private void setParkingsCheckBoxBehaviour() {
		parkingsBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				saveCheckBoxStates();
				if (parkingsBox.isChecked()) {
					googleMapManager.showParkingMarkers();
				} else {
					googleMapManager.hideParkingMarkers();
				}				
			}
		});
	}

	private void setNestsCheckBoxBehaviour() {
		nestsBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				saveCheckBoxStates();
				if (nestsBox.isChecked()) {
					googleMapManager.showNestMarkers();
				} else {
					googleMapManager.hideNestMarkers();
				}
			}
		});
	}

	private void setDefibrillatorsCheckBoxBehaviour() {
		defibrillatorsBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				saveCheckBoxStates();
				if (defibrillatorsBox.isChecked()) {
					googleMapManager.showDefibrillatorMarkers();
				} else {
					googleMapManager.hideDefibrillatorMarkers();
				}
			}
		});		
	}

	private void setPersonalMarkersCheckBoxBehaviour() {
		personalBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				saveCheckBoxStates();
				if (personalBox.isChecked()) {
					googleMapManager.showPersonalMarkers();
				} else {
					googleMapManager.hidePersonalMarkers();
				}
			}
		});		
	}

	public void saveCheckBoxStates() {
		initCheckBoxStateList();
		businessFactory.getCheckBoxStateBusiness(this, (FetchCheckBoxStateListener) this)
		.createSaveCheckBoxStatesAsyncTask(checkBoxStateList).execute();
	}

	private void initCheckBoxStateList() {
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

	private void setClearPersonalMarkersButtonBehavior() {
		final Context that = this;
		clearButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Storage st = new Storage(that);
				st.remove(Storage.PERSISTENCE_KEY_PERSONAL_ITEM);
				googleMapManager.removePersonnalItem();

				desactivatePersonalMarkers();
				toastFactory.displayShortToast(getString(R.string.notif_personal_items_deleted));
			}
		});
	}

	private void updateCheckBoxesState() {
		businessFactory.getCheckBoxStateBusiness(this, this)
		.createFetchCheckBoxStatesAsyncTask().execute();
	}

	public void activatePersonalMarkers() {
		personalBox.setChecked(true);
	}

	public void desactivatePersonalMarkers() {
		personalBox.setChecked(false);
	}

	public boolean isToiletsBoxChecked() {
		return toiletsBox.isChecked();
	}
	
	public boolean isParkingsBoxChecked() {
		return parkingsBox.isChecked();
	}
	
	public boolean isNestsBoxChecked() {
		return nestsBox.isChecked();
	}
	
	public boolean isDefibrillatorsBoxChecked() {
		return defibrillatorsBox.isChecked();
	}
	
	public boolean isPersonalBoxChecked() {
		return personalBox.isChecked();
	}
	
	// Parkings methods

	@Override
	public void onWaitForParkings() {
		toastFactory.displayShortToast(getString(R.string.notif_wait_parkings));
	}
	
	@Override
	public void onFetchParkingsSuccess(List<Parking> parkings) {
		updateParkings(parkings);
	}
	
	private void updateParkings(List<Parking> parkings) {
		googleMapManager.renderParkingMarkers(parkings);
	}

	@Override
	public void onFetchParkingsError() {
		toastFactory.displayShortToast(getString(R.string.notif_error_parkings));
	}

	// PersonalItems Methods

	@Override
	public void onWaitForPersonalItems() {
		toastFactory.displayShortToast(getString(R.string.notif_wait_personalitems));
	}

	@Override
	public void onFetchPersonalItemsSuccess(List<PersonalItem> personalItems) {
		updatePersonalItems(personalItems);
	}

	private void updatePersonalItems(List<PersonalItem> personalItems) {
		googleMapManager.renderPersonalItemMarkers(personalItems);
	}
	
	@Override
	public void onFetchPersonalItemsError() {
		toastFactory.displayShortToast(getString(R.string.notif_error_personalitems));
	}

	// Defibrillators Methods

	@Override
	public void onWaitForDefibrillators() {
		toastFactory.displayShortToast(getString(R.string.notif_wait_defibrillators));
	}

	@Override
	public void onFetchDefibrillatorsSuccess(List<Defibrillator> defibrillators) {
		updateDefibrillators(defibrillators);
	}

	private void updateDefibrillators(List<Defibrillator> defibrillators) {
		googleMapManager.renderDefibrillatorMarkers(defibrillators);
	}
	
	@Override
	public void onFetchDefibrillatorsError() {
		toastFactory.displayShortToast(getString(R.string.notif_error_defibrillators));
	}

	// Nests Methods

	@Override
	public void onWaitForNests() {
		toastFactory.displayShortToast(getString(R.string.notif_wait_nests));
	}

	@Override
	public void onFetchNestsSuccess(List<Nest> nests) {
		updateNests(nests);
	}

	private void updateNests(List<Nest> nests) {
		googleMapManager.renderNestMarkers(nests);
	}
	
	@Override
	public void onFetchNestsError() {
		toastFactory.displayShortToast(getString(R.string.notif_error_nests));
	}

	// Toilets Methods

	@Override
	public void onWaitForToilets() {
		toastFactory.displayShortToast(getString(R.string.notif_wait_toilets));
	}

	@Override
	public void onFetchToiletsSuccess(List<Toilet> toilets) {
		updateToilets(toilets);
	}

	private void updateToilets(List<Toilet> toilets) {
		googleMapManager.renderToiletMarkers(toilets);
	}
	
	@Override
	public void onFetchToiletsError() {
		toastFactory.displayShortToast(getString(R.string.notif_error_toilets));
	}

	@Override
	public void onWaitForCheckBoxStates() {
		toastFactory.displayShortToast(getString(R.string.notif_wait_checkboxes_states));
	}

	@Override
	public void onFetchCheckBoxStatesSuccess(List<CheckBoxState> data) {
		setCheckBoxState(data);
	}

	private void setCheckBoxState(List<CheckBoxState> data) {
		for (CheckBoxState cbs : data) {
			if (TOILETS.equals(cbs.getName())) {
				toiletsBox.setChecked(cbs.getState());
			} else if (PARKINGS.equals(cbs.getName())) {
				parkingsBox.setChecked(cbs.getState());
			} else if (NESTS.equals(cbs.getName())) {
				nestsBox.setChecked(cbs.getState());
			} else if (DEFIBRILLATORS.equals(cbs.getName())) {
				defibrillatorsBox.setChecked(cbs.getState());
			} else if (PERSONAL_ITEMS.equals(cbs.getName())) {
				personalBox.setChecked(cbs.getState());
			}
		}
	}

	@Override
	public void onFetchCheckBoxStatesError() {
		toastFactory.displayShortToast(getString(R.string.notif_error_checkboxes_states));
	}
}
