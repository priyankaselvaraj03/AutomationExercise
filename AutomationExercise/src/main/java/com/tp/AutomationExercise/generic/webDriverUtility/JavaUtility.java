package com.tp.AutomationExercise.generic.webDriverUtility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random randon = new Random();
		int randonNum = randon.nextInt(5000);
		return randonNum;
	}
	
	public String getSystemDateddMMyyyy()
	{
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(dateObj);
		return date;
	}
	
	public String getRequriedDate(int days) {
		Date dateObj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateObj);
		System.out.println(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqiredDate = sim.format(cal.getTime());
		return reqiredDate;
	}
	
	public String getFilePath(String fileName) {
		File f = new File("./testData/"+fileName+".png");
		String path=f.getAbsolutePath();
		return path;
	}
}
