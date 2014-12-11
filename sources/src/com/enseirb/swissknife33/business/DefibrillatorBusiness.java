package com.enseirb.swissknife33.business;

import java.util.List;

import android.content.Context;
import android.os.AsyncTask;

import com.enseirb.swissknife33.business.model.Defibrillator;
import com.enseirb.swissknife33.converter.ConverterFactory;
import com.enseirb.swissknife33.exception.Swissknife33Exception;
import com.enseirb.swissknife33.presenter.ui.FetchDefibrillatorListener;

public class DefibrillatorBusiness {
	
	private Context context = null;
	private FetchDefibrillatorListener listener = null;
	private List<Defibrillator> defibrillators = null;

	private ConverterFactory converterFactory = new ConverterFactory();

	public DefibrillatorBusiness(Context context, FetchDefibrillatorListener listener) {
		this.context = context;
		this.listener = listener;
	}

	public AsyncTask<Void, Void, Boolean> createFetchDefibrillatorsAsyncTask() {
		return new AsyncTask<Void, Void, Boolean>() {

			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				listener.onWaitForDefibrillators();
			}

			@Override
			protected Boolean doInBackground(Void... params) {

				try {
					defibrillators = converterFactory.getDefibrillatorConverter(context).fetch();
				} catch (Swissknife33Exception e) {
					return false;
				}
				return true;
			}

			@Override
			protected void onPostExecute(Boolean success) {
				if (success) {
					listener.onFetchDefibrillatorsSuccess(defibrillators);
				} else {
					listener.onFetchDefibrillatorsError();
				}
			}
		};
	}
}
