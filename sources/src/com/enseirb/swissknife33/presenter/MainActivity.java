package com.enseirb.swissknife33.presenter;

import java.net.URL;
import java.util.List;

import org.json.JSONException;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enseirb.swissknife33.R;
import com.enseirb.swissknife33.business.ParkingBusiness;
import com.enseirb.swissknife33.dao.DAOFactory;
import com.enseirb.swissknife33.dao.ParkingDAO;
import com.enseirb.swissknife33.dao.model.ParkingDTO;

public class MainActivity extends Activity implements
NavigationDrawerFragment.NavigationDrawerCallbacks {

	private NavigationDrawerFragment mNavigationDrawerFragment;
	private ParkingBusiness parkingBusiness = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);

		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));

		parkingBusiness = new ParkingBusiness(this);
		parkingBusiness.createAsyncTaskParkingRequest().execute();
	}

	public void updateParkings(List<ParkingDTO> parkings) {
		System.out.println("parkings recuperes ! (" + parkings.size() + ")");
		for (ParkingDTO parkingDTO : parkings) {
			System.out.println(parkingDTO.toString());
		}
	}

//	private AsyncTask<URL, Integer, List<ParkingDTO>> createAsyncTaskParkingRequest() {
//		return new AsyncTask<URL, Integer, List<ParkingDTO>>() {
//
//			@Override
//			protected List<ParkingDTO> doInBackground(URL... urls) {
//
//				DAOFactory factory = new DAOFactory();
//				List<ParkingDTO> parkings = null;
//				
//				try {
//					parkings = factory.getParkingDAO().fetch();
////					System.out.println("parkings recuperes ! (" + parkings.size() + ")");
////					for (ParkingDTO parkingDTO : parkings) {
////						System.out.println(parkingDTO.toString());
////					}
//				} catch (JSONException e) {
//					e.printStackTrace();
//				}
//				
//				return parkings;
//			}
//			
//			@Override
//			protected void onPostExecute(List<ParkingDTO> result) {
//				updateParkings(result);
////				callingActivity.updateDisplayedWeather(result);
////				callingActivity.closeWaitingPopupAndResetRefreshing();
//			}
//		};
//	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager
		.beginTransaction()
		.replace(R.id.map,
				PlaceholderFragment.newInstance(position + 1)).commit();
	}

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
	}

	public static class PlaceholderFragment extends Fragment {

		private static final String ARG_SECTION_NUMBER = "section_number";


		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}

	}

}
