package com.enseirb.swissknife33.presenter.ui;

import java.util.List;

import com.enseirb.swissknife33.business.model.PersonalItem;

public interface FetchPersonalItemListener {
	public void onWaitForPersonalItems();
	public void onFetchPersonalItemsSuccess(List<PersonalItem> data);
	public void onFetchPersonalItemsError();
}
