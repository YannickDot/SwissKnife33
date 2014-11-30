package com.enseirb.swissknife33.presenter.ui;

import java.util.List;

import com.enseirb.swissknife33.business.model.Toilet;

public interface FetchToiletListener {
	public void onWaitForToilets();
	public void onFetchToiletsSuccess(List<Toilet> data);
	public void onFetchToiletsError();
}
