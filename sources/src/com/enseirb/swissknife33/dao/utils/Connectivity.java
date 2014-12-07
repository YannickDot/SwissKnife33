package com.enseirb.swissknife33.dao.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Connectivity {
	private ConnectivityManager connectivityManager;
	private NetworkInfo networkInfo;
	
	public Connectivity(Context context){
		connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		networkInfo = connectivityManager.getActiveNetworkInfo();
	}
	
	public boolean isOnline(){
		return networkInfo != null && networkInfo.isConnected();
	}
}
