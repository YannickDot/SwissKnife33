package com.enseirb.swissknife33.presenter;

import android.content.Context;
import android.widget.Toast;

public class ToastFactory {
	
	private Context context = null;

	public ToastFactory(Context context) {
		this.context = context;
	}

	public void displayShortToast(String toastMessage) {
		Toast toast = Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT);
		toast.show();
	}

	public void displayLongToast(String toastMessage) {
		Toast toast = Toast.makeText(context, toastMessage, Toast.LENGTH_LONG);
		toast.show();
	}	
}
