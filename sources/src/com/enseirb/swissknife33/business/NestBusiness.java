package com.enseirb.swissknife33.business;

import java.util.List;

import android.content.Context;
import android.os.AsyncTask;

import com.enseirb.swissknife33.business.model.Nest;
import com.enseirb.swissknife33.converter.ConverterFactory;
import com.enseirb.swissknife33.exception.Swissknife33Exception;
import com.enseirb.swissknife33.presenter.ui.FetchNestListener;

public class NestBusiness {
	
	private Context context = null;
	private FetchNestListener listener = null;
	private List<Nest> nests = null;

	private ConverterFactory converterFactory = new ConverterFactory();

	public NestBusiness(Context context, FetchNestListener listener) {
		this.context = context;
		this.listener = listener;
	}

	public AsyncTask<Void, Void, Boolean> createFetchNestsAsyncTask() {
		return new AsyncTask<Void, Void, Boolean>() {

			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				listener.onWaitForNests();
			}

			@Override
			protected Boolean doInBackground(Void... params) {

				try {
					nests = converterFactory.getNestConverter(context).fetch();
				} catch (Swissknife33Exception e) {
					return false;
				}
				return true;
			}

			@Override
			protected void onPostExecute(Boolean success) {
				if (success) {
					listener.onFetchNestsSuccess(nests);
				} else {
					listener.onFetchNestsError();
				}
			}
		};
	}
}
