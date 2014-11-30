package com.enseirb.swissknife33.business;

import android.content.Context;

import com.enseirb.swissknife33.presenter.ui.FetchParkingListener;
import com.enseirb.swissknife33.presenter.ui.FetchPersonalItemListener;
import com.enseirb.swissknife33.presenter.ui.FetchToiletListener;

public class BusinessFactory {
	
	public ParkingBusiness getParkingBusiness(Context context, FetchParkingListener listener) {
		return new ParkingBusiness(context, listener);
	}
	
	public PersonalItemBusiness getPersonalItemBusiness(Context context, FetchPersonalItemListener listener){
		return new PersonalItemBusiness(context, listener);
	}
	
	public ToiletBusiness getToiletBusiness(Context context, FetchToiletListener listener){
		return new ToiletBusiness(context, listener);
	}
}
