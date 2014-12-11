package com.enseirb.swissknife33.converter;

import android.content.Context;

public class ConverterFactory {

	public ParkingConverter getParkingConverter(Context context) {
		return new ParkingConverter(context);
	}
	
	public PersonalItemConverter getPersonalItemConverter(Context context) {
		return new PersonalItemConverter(context);
	}
	
	public NestConverter getNestConverter(Context context) {
		return new NestConverter(context);
	}
	
	public ToiletConverter getToiletConverter(Context context) {
		return new ToiletConverter(context);
	}
	
	public DefibrillatorConverter getDefibrillatorConverter(Context context) {
		return new DefibrillatorConverter(context);
	}

	public CheckBoxStateConverter getCheckBoxStateConverter(Context context) {
		return new CheckBoxStateConverter(context);
	}
}
