package com.enseirb.swissknife33.business;

import java.util.List;

import android.content.Context;
import android.os.AsyncTask;

import com.enseirb.swissknife33.business.model.PersonalItem;
import com.enseirb.swissknife33.converter.ConverterFactory;
import com.enseirb.swissknife33.exception.Swissknife33Exception;
import com.enseirb.swissknife33.presenter.ui.FetchPersonalItemListener;

public class PersonalItemBusiness {
	
	private Context context = null;
	private FetchPersonalItemListener listener = null;
	private List<PersonalItem> personalItems = null;

	private ConverterFactory converterFactory = new ConverterFactory();

	public PersonalItemBusiness(Context context, FetchPersonalItemListener listener) {
		this.context = context;
		this.listener = listener;
	}

	public AsyncTask<Void, Void, Boolean> createFetchPersonalItemsAsyncTask() {
		return new AsyncTask<Void, Void, Boolean>() {

			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				listener.onWaitForPersonalItems();
			}

			@Override
			protected Boolean doInBackground(Void... params) {

				try {
					personalItems = converterFactory.getPersonalItemConverter(context).fetch();
				} catch (Swissknife33Exception e) {
					return false;
				}
				return true;
			}

			@Override
			protected void onPostExecute(Boolean success) {
				if (success) {
					listener.onFetchPersonalItemsSuccess(personalItems);
				}
				else {
					listener.onFetchPersonalItemsError();
				}
			}
		};
	}
	
	public AsyncTask<Void, Void, Boolean> createSavePersonalItemsAsyncTask(final List<PersonalItem> list) {
		return new AsyncTask<Void, Void, Boolean>() {

			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				//listener.onWaitForPersonalItems();
				System.out.println("saving PersonalItems.");
			}

			@Override
			protected Boolean doInBackground(Void... params) {

				try {
					converterFactory.getPersonalItemConverter(context).save(list);
				} catch (Swissknife33Exception e) {
					return false;
				}
				return true;
			}

			@Override
			protected void onPostExecute(Boolean success) {
				if (success) {
					//System.out.println("PersonalItems saved.");
				} else {
					//System.out.println("PersonalItems save failed.");
				}
			}
		};
	}
}
