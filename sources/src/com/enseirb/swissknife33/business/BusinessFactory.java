package com.enseirb.swissknife33.business;

import android.content.Context;

import com.enseirb.swissknife33.presenter.ui.FetchParkingListener;
import com.enseirb.swissknife33.presenter.ui.FetchPersonalItemListener;

public class BusinessFactory {
	
	public ParkingBusiness getParkingBusiness(Context context, FetchParkingListener listener) {
		return new ParkingBusiness(context, listener);
	}
	
	public PersonalItemBusiness getPersonalItemBusiness(Context context, FetchPersonalItemListener listener){
		return new PersonalItemBusiness(context, listener);
	}
}
