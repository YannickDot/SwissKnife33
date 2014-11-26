package com.enseirb.swissknife33.converter;

import android.content.Context;

public class ConverterFactory {

	public ParkingConverter getParkingConverter() {
		return new ParkingConverter();
	}
	
	public PersonalItemConverter getPersonalItemConverter(Context context) {
		return new PersonalItemConverter(context);
	}
}
