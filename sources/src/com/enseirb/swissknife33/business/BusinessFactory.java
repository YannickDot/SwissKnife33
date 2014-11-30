package com.enseirb.swissknife33.business;

import android.content.Context;

import com.enseirb.swissknife33.presenter.ui.FetchDefibrillatorListener;
import com.enseirb.swissknife33.presenter.ui.FetchNestListener;
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
	
	public NestBusiness getNestBusiness(Context context, FetchNestListener listener){
		return new NestBusiness(context, listener);
	}
	
	public DefibrillatorBusiness getNestBusiness(Context context, FetchDefibrillatorListener listener){
		return new DefibrillatorBusiness(context, listener);
	}
}
