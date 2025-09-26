package com.hk.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder {
	
	@Autowired //field injection
	private LocalDate date;
	
	
	//business method
	public String showSeasonName() {
		//get current month of the year
		int month = date.getMonthValue();
		// find the season name
		if(month>=3 && month <=6)
			return "Sumeer Season";
		else if( month >= 7 && month <=12)
			return " Rainy Season";
		else
			return "Winter Season";
		
		
	}

	
	
	
}
