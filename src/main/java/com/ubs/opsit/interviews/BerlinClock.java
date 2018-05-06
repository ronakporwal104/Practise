package com.ubs.opsit.interviews;

import org.apache.commons.lang.StringUtils;
/**
 * 
 * @author Ronak Porwal
 *
 */
public class BerlinClock implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		StringBuilder builder = new StringBuilder();
		
		if(StringUtils.isNotBlank(aTime)){
			
			String[] timeArray = aTime.split(":");
			if(StringUtils.isNotBlank(timeArray[2])){
				int seconds = Integer.parseInt(timeArray[2]);
				getSeconds(builder,seconds);
			}
			
			if(StringUtils.isNotBlank(timeArray[0])){
				int hours = Integer.parseInt(timeArray[0]);
				builder.append("\r\n");
				getHours(builder,hours);
			}
			
			if(StringUtils.isNotBlank(timeArray[1])){
				int mins = Integer.parseInt(timeArray[1]);
				builder.append("\r\n");
				getMinutes(builder,mins);
			}
		}
		
		return builder.toString();
	}

	
	/**
	 * Gets hours in berlin clock format
	 * @param hoursBuilder
	 * @param hours
	 */
	private void getHours(StringBuilder hoursBuilder, int hours){
		//FirstRow
		int firstRowRed = hours/5;
		
		for (int i = 0; i < LampColumnsEnum.HOURS_FIRSTROW_NO_OF_COLUMNS.getValue(); i++) {
			if(firstRowRed>i){
				hoursBuilder.append(LampEnum.HOURS_ON.getValue());
			}
			else{
				hoursBuilder.append(LampEnum.HOURS_OFF.getValue());
			}
		}
		
		hoursBuilder.append("\r\n");
		
		//SecondRow
		int secondRowRed = hours%5;
		
		for (int i = 0; i < LampColumnsEnum.HOURS_SECONDROW_NO_OF_COLUMNS.getValue(); i++) {
			if(secondRowRed>i){
				hoursBuilder.append(LampEnum.HOURS_ON.getValue());
			}
			else{
				hoursBuilder.append(LampEnum.HOURS_OFF.getValue());
			}
		}
	}
	
	/**
	 * Gets minutes in berlin clock format
	 * @param minsBuilder
	 * @param mins
	 */
	private void getMinutes(StringBuilder minsBuilder, int mins){
		//FirstRow
		int firstRowVal = mins/5;
		
		for (int i = 0; i < LampColumnsEnum.MINUTES_FIRSTROW_NO_OF_COLUMNS.getValue(); i++) {
			if(firstRowVal>i){
				if(((i+1)%3) == 0){
					minsBuilder.append(LampEnum.HOURS_ON.getValue());
				}
				else{
					minsBuilder.append(LampEnum.MINUTES_ON.getValue());
				}
			}
			else{
				minsBuilder.append(LampEnum.MINUTES_OFF.getValue());
			}
		}
		
		minsBuilder.append("\r\n");
		
		//SecondRow
		int secondRowVal = mins%5;
		
		for (int i = 0; i < LampColumnsEnum.MINUTES_SECONDROW_NO_OF_COLUMNS.getValue(); i++) {
			if(secondRowVal>i){
				minsBuilder.append(LampEnum.MINUTES_ON.getValue());
			}
			else{
				minsBuilder.append(LampEnum.MINUTES_OFF.getValue());
			}
		}
	}
	
	
	/**
	 * Gets seconds in berlin clock format
	 * @param secondsBuilder
	 * @param seconds
	 */
	private void getSeconds(StringBuilder secondsBuilder, int seconds){
		int secValue = seconds%2;
		
		if(secValue==0){
			secondsBuilder.append(LampEnum.SECONDS_ON.getValue());
		}
		else{
			secondsBuilder.append(LampEnum.SECONDS_OFF.getValue());
		}
	}
	/*public static void main(String[] args){
		BerlinClock clock = new BerlinClock();
		System.out.println(clock.convertTime("13:17:01"));
	}*/
}
