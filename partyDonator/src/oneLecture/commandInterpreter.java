package oneLecture;

import java.util.ArrayList;
import java.util.List;

public class commandInterpreter {
	
	public static List<char[]> SetPaypalAccount = new ArrayList<char[]>(); 
	public static List<char[]> CameBack = new ArrayList<char[]>(); 
	public static List<char[]> GetDeadline = new ArrayList<char[]>(); 
	public int Debug = 0; 
	
	public commandInterpreter()
	{
		String paypalString = "set paypal account"; char[] paypalArray = paypalString.toCharArray(); 
		SetPaypalAccount.add(0,paypalArray); 
		paypalString = "paypal account"; paypalArray = paypalString.toCharArray(); 
		SetPaypalAccount.add(0,paypalArray); 
		
		String cameBackString = "i am home"; char[] cameBackArray = cameBackString.toCharArray(); 
		CameBack.add(0,cameBackArray); 
		cameBackString = "i arrived"; cameBackArray = cameBackString.toCharArray(); 
		CameBack.add(0,cameBackArray); 
		cameBackString = "home"; cameBackArray = cameBackString.toCharArray(); 
		CameBack.add(0,cameBackArray); 
		cameBackString = "just in time"; cameBackArray = cameBackString.toCharArray(); 
		CameBack.add(0,cameBackArray); 
		cameBackString = "i'm not late"; cameBackArray = cameBackString.toCharArray(); 
		CameBack.add(0,cameBackArray); 
		cameBackString = "in time"; cameBackArray = cameBackString.toCharArray(); 
		CameBack.add(0,cameBackArray); 
		
		String getDeadlineString = "i will be back at"; char[] getDeadlineArray = getDeadlineString.toCharArray(); 
		GetDeadline.add(0,getDeadlineArray); 
		getDeadlineString = "i'll be back at"; getDeadlineArray = getDeadlineString.toCharArray(); 
		GetDeadline.add(0,getDeadlineArray); 
		getDeadlineString = "expect me back at"; getDeadlineArray = getDeadlineString.toCharArray(); 
		GetDeadline.add(0,getDeadlineArray); 
		getDeadlineString = "i'll be home at"; getDeadlineArray = getDeadlineString.toCharArray(); 
		GetDeadline.add(0,getDeadlineArray); 
		
	}
	//char[] comparisor
	public boolean sameArray(char[] c1, char[] c2)
	{
		for(int k = 0; k < c1.length; ++k) if(c1[k] != c2[k]) return false; 
		return true; 
	}
	
	//paypal stuff
	public boolean checkIfSetPaypalAccount(char[] commandToCheck)
	{
		for(int i = 0; i < SetPaypalAccount.size(); ++i)
		{
			char[] comparing = SetPaypalAccount.get(i);
			if(comparing.length != commandToCheck.length) continue;
			
			if(sameArray(commandToCheck,comparing)) return true;	
		}
		return false;
	}
	//erase alarm
	public boolean checkIfCameBack(char[] commandToCheck)
	{
		for(int i = 0; i < CameBack.size(); ++i)
		{
			char[] comparing = CameBack.get(i);
			if(comparing.length != commandToCheck.length) continue; 
			
			if(sameArray(commandToCheck, comparing)) return true;	
		}
		return false;
	}
	//put alarm
	public boolean checkIfGetDeadline(char[] commandToCheck)
	{
		for(int i = 0; i < GetDeadline.size(); ++i)
		{
			char[] comparing = GetDeadline.get(i);
			boolean equal = true; 
			if(commandToCheck.length < comparing.length) equal = false; 
			for(int j = 0; j < comparing.length && equal; ++j)
			{
				if(comparing[j] != commandToCheck[j]) equal = false; 
			}
			if(equal) return true; 
		}
		return false;
	}
}
