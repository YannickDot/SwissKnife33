package com.enseirb.swissknife33.business;

import java.util.List;

import android.content.Context;
import android.os.AsyncTask;

import com.enseirb.swissknife33.business.model.Parking;
import com.enseirb.swissknife33.converter.ConverterFactory;
import com.enseirb.swissknife33.exception.Swissknife33Exception;
import com.enseirb.swissknife33.presenter.ui.FetchParkingListener;

public class ParkingBusiness {

	private Context context = null;
	private FetchParkingListener listener = null;
	private List<Parking> parkings = null;

	private ConverterFactory converterFactory = new ConverterFactory();


	public ParkingBusiness(Context context, FetchParkingListener listener) {
		this.context = context;
		this.listener = listener;
	}

	public AsyncTask<Void, Void, Boolean> createFetchParkingsAsyncTask() {
		return new AsyncTask<Void, Void, Boolean>() {

			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				listener.onWaitForParkings();
			}

			@Override
			protected Boolean doInBackground(Void... params) {

				//TODO Check network connectivity using context !
				// Here or not ? We can check it in the DAO.
				// If we do it in the DAO, we need to pass the context.
				try {
					parkings = converterFactory.getParkingConverter().fetch();
				} catch (Swissknife33Exception e) {
					return false;
				}
				return true;
			}

			@Override
			protected void onPostExecute(Boolean success) {
				if (success) {
					listener.onFetchParkingsSuccess(parkings);
				}
				else {
					listener.onFetchParkingsError();
				}
			}
		};
	}
}
