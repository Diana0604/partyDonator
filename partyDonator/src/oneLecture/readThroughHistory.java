package oneLecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class readThroughHistory { // Llegim l'historial de l'Alexa.
	public static char[] arrayHist; 
	public static int Debug = 0; 
	public readThroughHistory(String hist)
	{
		arrayHist = hist.toCharArray(); 
	}
	
	public static boolean partyLauncher(int i)
	{
		if(i >= arrayHist.length || arrayHist[i] != 'p') return false; 
		if(i + 1 >= arrayHist.length || arrayHist[i+1] != 'a') return false; 
		if(i+2 >= arrayHist.length || arrayHist[i+2] != 'r') return false; 
		if(i+3 >= arrayHist.length || arrayHist[i+3] != 't') return false; 
		if(i+4 >= arrayHist.length || arrayHist[i+4] != 'y') return false;
		return true;
	}
	
	public static boolean dialogTitle(int i)
	{
		if(i <= 13 || arrayHist[i] != '>') return false; 
		if(arrayHist[i-1] != '"') return false; 
		if(arrayHist[i-2] != 'e') return false; 
		if(arrayHist[i-3] != 'l') return false; 
		if(arrayHist[i-4] != 't') return false;
		if(arrayHist[i-5] != 'i') return false; 
		if(arrayHist[i-6] != 't') return false; 
		if(arrayHist[i-7] != '-') return false; 
		if(arrayHist[i-8] != 'g') return false;
		if(arrayHist[i-9] != 'o') return false; 
		if(arrayHist[i-10] != 'l') return false; 
		if(arrayHist[i-11] != 'a') return false;
		if(arrayHist[i-12] != 'i') return false; 
		if(arrayHist[i-13] != 'd') return false;
		return true;
	}
	
	public static char[] afterParty(int i)
	{
		i -= 100; 
		
		
		char[] nextCommand = new char[0]; 
		
		while(!dialogTitle(i) && i > 0) --i; 
		++i; 
		while(i > 0 && arrayHist[i] != '<')
		{
			if(Debug == 1) System.out.println("while de llegir el command...");
			nextCommand = Arrays.copyOf(nextCommand, nextCommand.length + 1); 
			nextCommand[nextCommand.length-1] = arrayHist[i]; 
			if(Debug == 2)
			{
				
				System.out.print(nextCommand[nextCommand.length - 1]);
			}
			++i;
		}
		if(Debug == 2) 
		{
			System.out.println();
		}
		return nextCommand; 
	}
	
	public static char[] findNextCommand(int i)
	{
		while(!partyLauncher(i) && i < arrayHist.length)  ++i; 
		if(i >= arrayHist.length)  return null;
		
		char[] nextCommand = new char[0]; 
		nextCommand = afterParty(i);
		return nextCommand; 
	}
}
