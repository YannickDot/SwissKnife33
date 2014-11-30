package com.enseirb.swissknife33.presenter.ui;

import java.util.List;

import com.enseirb.swissknife33.business.model.Nest;

public interface FetchNestListener {
	public void onWaitForNests();
	public void onFetchNestsSuccess(List<Nest> data);
	public void onFetchNestsError();
}
