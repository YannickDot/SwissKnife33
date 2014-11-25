package com.enseirb.swissknife33.business;

import android.content.Context;

import com.enseirb.swissknife33.presenter.ui.FetchParkingListener;

public class BusinessFactory {
	
	public ParkingBusiness getParkingBusiness(Context context, FetchParkingListener listener) {
		return new ParkingBusiness(context, listener);
	}
}
