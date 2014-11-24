package com.enseirb.swissknife33.business;

import java.util.List;

import android.os.AsyncTask;

import com.enseirb.swissknife33.business.model.Parking;
import com.enseirb.swissknife33.converter.ConverterFactory;
import com.enseirb.swissknife33.presenter.ui.InProgressMethodWrapper;
import com.enseirb.swissknife33.presenter.ui.OnSuccessMethodWrapper;

public class ParkingBusiness {
	
	private InProgressMethodWrapper inProgress = null;
	private OnSuccessMethodWrapper onSuccess = null;
	private ConverterFactory converterFactory = new ConverterFactory();
	
	public ParkingBusiness(InProgressMethodWrapper inProgress, OnSuccessMethodWrapper onSuccess) {
		this.inProgress = inProgress;
		this.onSuccess = onSuccess;
	}

	public AsyncTask<Void, Integer, List<Parking>> createAsyncTaskParkingRequest() {
		return new AsyncTask<Void, Integer, List<Parking>>() {

			@Override
            protected void onPreExecute() {
                super.onPreExecute();
                inProgress.callback();
            }
			
			@Override
			protected List<Parking> doInBackground(Void... params) {
					return converterFactory.getParkingConverter().fetch();
			}
			
			@Override
			protected void onPostExecute(List<Parking> result) {
				onSuccess.callback(result);
			}
		};
	}
}
