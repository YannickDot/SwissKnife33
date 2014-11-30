package com.enseirb.swissknife33.business;

import java.util.List;

import android.content.Context;
import android.os.AsyncTask;

import com.enseirb.swissknife33.business.model.Toilet;
import com.enseirb.swissknife33.converter.ConverterFactory;
import com.enseirb.swissknife33.exception.Swissknife33Exception;
import com.enseirb.swissknife33.presenter.ui.FetchToiletListener;

public class ToiletBusiness {
	private Context context = null;
	private FetchToiletListener listener = null;
	private List<Toilet> toilets = null;

	private ConverterFactory converterFactory = new ConverterFactory();


	public ToiletBusiness(Context context, FetchToiletListener listener) {
		this.context = context;
		this.listener = listener;
	}

	public AsyncTask<Void, Void, Boolean> createFetchToiletsAsyncTask() {
		return new AsyncTask<Void, Void, Boolean>() {

			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				listener.onWaitForToilets();
			}

			@Override
			protected Boolean doInBackground(Void... params) {

				try {
					toilets = converterFactory.getToiletConverter(context).fetch();
				} catch (Swissknife33Exception e) {
					return false;
				}
				return true;
			}

			@Override
			protected void onPostExecute(Boolean success) {
				if (success) {
					listener.onFetchToiletsSuccess(toilets);
				}
				else {
					listener.onFetchToiletsError();
				}
			}
		};
	}
}
