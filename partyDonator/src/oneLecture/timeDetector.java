package oneLecture;

import java.util.*;


public class timeDetector {

	public static void main(String args[])

	{
		
		//example of usage
		String s = "i'll be at home at half past twenty three";

		timeDetection(s);

	}

	public static int[] timeDetection(String s) {

		int[] time = new int[2];

		

		String[] connector = new String[3];

		connector[0] = "past";

		connector[1] = "to";

		connector[2] = "clock";

		

		String[] minutes = new String[60];

		minutes[0] = "one";

		minutes[1] = "two";

		minutes[2] = "three";

		minutes[3] = "four";

		minutes[4] = "five";

		minutes[5] = "six";

		minutes[6] = "seven";

		minutes[7] = "eight";

		minutes[8] = "nine";

		minutes[9] = "ten";

		minutes[10] = "eleven";

		minutes[11] = "twelve";

		minutes[12] = "thirteen";

		minutes[13] = "fourteen";

		minutes[14] = "fifteen";

		minutes[15] = "sixteen";

		minutes[16] = "seventeen";

		minutes[17] = "eighteen";

		minutes[18] = "nineteen";

		minutes[19] = "twenty";

		minutes[20] = "twenty one";

		minutes[21] = "twenty two";

		minutes[22] = "twenty three";

		minutes[23] = "twenty four";

		minutes[24] = "twenty five";

		minutes[25] = "twenty six";

		minutes[26] = "twenty seven";

		minutes[27] = "twenty eight";

		minutes[28] = "twenty nine";

		minutes[29] = "twenty four";

		minutes[20] = "twenty one";

		minutes[21] = "twenty two";

		minutes[22] = "twenty three";

		minutes[23] = "twenty four";

		minutes[24] = "twenty five";

		minutes[25] = "twenty six";

		minutes[26] = "twenty seven";

		minutes[27] = "twenty eight";

		minutes[28] = "twenty nine";

		minutes[29] = "half";

		minutes[30] = "thirty one";

		minutes[31] = "thirty two";

		minutes[32] = "thirty three";

		minutes[33] = "thirty four";

		minutes[34] = "thirty five";

		minutes[35] = "thirty six";

		minutes[36] = "thirty seven";

		minutes[37] = "thirty eight";

		minutes[38] = "thirty nine";

		minutes[39] = "fourty";

		minutes[40] = "fourty one";

		minutes[41] = "fourty two";

		minutes[42] = "fourty three";

		minutes[43] = "fourty four";

		minutes[44] = "fourty five";

		minutes[45] = "fourty six";

		minutes[46] = "fourty seven";

		minutes[47] = "fourty eight";

		minutes[48] = "fourty nine";

		minutes[49] = "fifty";

		minutes[50] = "fifty one";

		minutes[51] = "fifty two";

		minutes[52] = "fifty three";

		minutes[53] = "fifty four";

		minutes[54] = "fifty five";

		minutes[55] = "fifty six";

		minutes[56] = "fifty seven";

		minutes[57] = "fifty eight";

		minutes[58] = "fifty nine";

		minutes[59] = "sixty";

		

		if (s.contains(connector[2])) { //o'clock

			for(int i = 0; i <= 59; ++i) {

				if (s.contains(minutes[i])) {

					time[0] = i + 1;

					time [1] = 0;

				}

			}

		} else if (s.contains(connector[1])){ //to

			boolean found = false;

			for(int i = 0; i <= 59; ++i) {

				if(s.contains(minutes[i])){

					if(s.indexOf(minutes[i]) < s.indexOf(connector[1])) {

						time[1] = 59 - i;

					}

					else {

						time[0] = i;

						found = true;

					}

				

				}

			}

			if (!found) time[0] = 59 - time[1];

			if (s.contains("midnight")) time[0] = 23;

		} else if (s.contains(connector[0])){ //past

			boolean found = false;

			for(int i = 0; i <= 59; ++i) {

				if(s.contains(minutes[i])){

					if(s.indexOf(minutes[i]) < s.indexOf(connector[0])){

						time[1] = i + 1;

					}

					else {

						time[0] = i + 1;

						found = true;

					}

					

				}

			}

			if (!found) time[0] = time[1];

			if (s.contains("midnight")) time[0] = 0; 

		} else {

			time[0] = 0;

			time[1] = 0;

		}

		System.out.print(time[0]);

		System.out.print(':');

		System.out.println(time[1]);

		return time;

	}

}
