package com.enseirb.swissknife33.business;

import com.enseirb.swissknife33.presenter.ui.InProgressMethodWrapper;
import com.enseirb.swissknife33.presenter.ui.OnSuccessMethodWrapper;

public class BusinessFactory {

	public ParkingBusiness getParkingBusiness(
			InProgressMethodWrapper inProgress,
			OnSuccessMethodWrapper onSuccess) {
		
		ParkingBusiness parkingBusiness = new ParkingBusiness(inProgress, onSuccess);
		return parkingBusiness;
	}
}
