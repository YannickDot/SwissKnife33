package com.enseirb.swissknife33.presenter.ui;

import java.util.List;

import com.enseirb.swissknife33.business.model.Defibrillator;

public interface FetchDefibrillatorListener {
	public void onWaitForDefibrillators();
	public void onFetchDefibrillatorsSuccess(List<Defibrillator> data);
	public void onFetchDefibrillatorsError();
}
