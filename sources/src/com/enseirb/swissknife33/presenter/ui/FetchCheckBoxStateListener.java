package com.enseirb.swissknife33.presenter.ui;

import java.util.List;

import com.enseirb.swissknife33.business.model.CheckBoxState;

public interface FetchCheckBoxStateListener {
	public void onWaitForCheckBoxStates();
	public void onFetchCheckBoxStatesSuccess(List<CheckBoxState> data);
	public void onFetchCheckBoxStatesError();
}
