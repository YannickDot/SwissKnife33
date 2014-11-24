package com.enseirb.swissknife33.business;

import java.net.URL;
import java.util.List;

import org.json.JSONException;

import android.os.AsyncTask;

import com.enseirb.swissknife33.dao.DAOFactory;
import com.enseirb.swissknife33.dao.model.ParkingDTO;
import com.enseirb.swissknife33.presenter.MainActivity;

public class ParkingBusiness {
	
	private MainActivity callingActivity = null;

	public ParkingBusiness(MainActivity callingActivity) {
		this.callingActivity = callingActivity;
	}

	public AsyncTask<URL, Integer, List<ParkingDTO>> createAsyncTaskParkingRequest() {
		return new AsyncTask<URL, Integer, List<ParkingDTO>>() {

			@Override
			protected List<ParkingDTO> doInBackground(URL... urls) {

				DAOFactory factory = new DAOFactory();
				List<ParkingDTO> parkings = null;
				
				try {
					parkings = factory.getParkingDAO().fetch();
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
				return parkings;
			}
			
			@Override
			protected void onPostExecute(List<ParkingDTO> result) {
				callingActivity.updateParkings(result);
			}
		};
	}
}
