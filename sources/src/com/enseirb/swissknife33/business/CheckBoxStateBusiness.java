package com.enseirb.swissknife33.business;

import java.util.List;

import android.content.Context;
import android.os.AsyncTask;

import com.enseirb.swissknife33.business.model.CheckBoxState;
import com.enseirb.swissknife33.converter.ConverterFactory;
import com.enseirb.swissknife33.exception.Swissknife33Exception;
import com.enseirb.swissknife33.presenter.ui.FetchCheckBoxStateListener;


public class CheckBoxStateBusiness {
	private Context context = null;
	private FetchCheckBoxStateListener listener = null;
	private List<CheckBoxState> checkboxstate = null;
	
	private ConverterFactory converterFactory = new ConverterFactory();

	public CheckBoxStateBusiness(Context context, FetchCheckBoxStateListener listener) {
		this.context = context;
		this.listener = listener;
	}

	public AsyncTask<Void, Void, Boolean> createFetchCheckBoxStatesAsyncTask() {
		return new AsyncTask<Void, Void, Boolean>() {

			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				listener.onWaitForCheckBoxStates();
			}

			@Override
			protected Boolean doInBackground(Void... params) {

				try {
					checkboxstate = converterFactory.getCheckBoxStateConverter(context).fetch();
				} catch (Swissknife33Exception e) {
					return false;
				}
				return true;
			}

			@Override
			protected void onPostExecute(Boolean success) {
				if (success) {
					listener.onFetchCheckBoxStatesSuccess(checkboxstate);
				}
				else {
					listener.onFetchCheckBoxStatesError();
				}
			}
		};
	}
	
}
