package com.ubs.opsit.interviews;

public enum LampColumnsEnum {

	HOURS_FIRSTROW_NO_OF_COLUMNS(4),
	HOURS_SECONDROW_NO_OF_COLUMNS(4),
	MINUTES_FIRSTROW_NO_OF_COLUMNS(11),
	MINUTES_SECONDROW_NO_OF_COLUMNS(4);
	
	private int value;
	
	private LampColumnsEnum(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}
