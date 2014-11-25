package com.enseirb.swissknife33.presenter.ui;

import java.util.List;

import com.enseirb.swissknife33.business.model.Parking;

public interface FetchParkingListener {
	
	public void onWaitForParkings();
	public void onFetchParkingsSuccess(List<Parking> data);
	public void onFetchParkingsError();
}
