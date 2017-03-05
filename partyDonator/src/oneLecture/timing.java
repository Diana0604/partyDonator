package oneLecture;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date; 

import oneLecture.timeDetector; 

public class timing {
	
	//deadlines and currents
	public static int deadlineHour;
	public static int deadlineMinute; 
	public static int currentHour; 
	public static int currentMinute; 
	public static int deadlineDay; 
	public static int currentDay; 
	
	//intervals
	public static int intervalMin; 
	public static int intervalHour;
	
	public timing(int deadlineHour, int deadlineMinute, int deadlineDay, int intervalMin, int intervalHour)
	{
		this.deadlineHour = deadlineHour;
		this.deadlineMinute = deadlineMinute; 
		this.deadlineDay = deadlineDay; 
		this.intervalMin = intervalMin; 
		this.intervalHour = intervalHour; 
	}
	
	//gets current hour and minute
	@SuppressWarnings("deprecation")
	public static void readHour()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		currentHour = date.getHours(); 
		currentMinute = date.getMinutes(); 
		currentDay = date.getDate();
	}
	
	//returns true if I'm being late
	public static boolean deadlineReached()
	{
		if(deadlineDay < currentDay)
		{
			System.out.println("currentDay:" + currentDay);
			System.out.println("deadlineDay:" + deadlineDay);
			updateHour(); 
			updateMinute();
			return true; 
		}
		if(deadlineDay == currentDay)
		{
			if(deadlineHour < currentHour)
			{
				updateHour();
				updateMinute();
				return true; 
			}
			
			if(deadlineHour == currentHour)
			{
				if(deadlineMinute <= currentMinute)
				{
					System.out.println("passed minute");
					updateHour(); 
					updateMinute();
					return true; 
				}
			}
		}
		return false; 
	}
	//update deadline hour, minute and day
	public static void updateHour()
	{
		deadlineHour += intervalHour; 
		if(deadlineHour < 24) return; 
		deadlineHour -= 24; 
		deadlineDay += 1; 
	}
	
	public static void updateMinute()
	{
		deadlineMinute += intervalMin; 
		if(deadlineMinute < 60) return; 
		deadlineMinute -= 60; 
		deadlineHour += 1; 
		if(deadlineHour < 24) return; 
		deadlineHour -= 24; 
		deadlineDay += 1; 
	}
}
