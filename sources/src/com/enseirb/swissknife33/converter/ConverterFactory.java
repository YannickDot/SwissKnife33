package com.enseirb.swissknife33.converter;

import android.content.Context;

public class ConverterFactory {

	public ParkingConverter getParkingConverter(Context context) {
		return new ParkingConverter(context);
	}
	
	public PersonalItemConverter getPersonalItemConverter(Context context) {
		return new PersonalItemConverter(context);
	}
}
