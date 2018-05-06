package com.ubs.opsit.interviews;

public enum LampEnum {
	HOURS_ON("R"),
	HOURS_OFF("O"),
	MINUTES_ON("Y"),
	MINUTES_OFF("O"),
	SECONDS_ON("Y"),
	SECONDS_OFF("O");
	
	private String value;
	
	private LampEnum(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
	
}
