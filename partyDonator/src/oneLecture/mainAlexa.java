package oneLecture;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;


import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.JPasswordField;

import javax.swing.JTextField;

import javax.swing.SwingConstants;


public class mainAlexa {

	public static void main(String[] args) {
		PayPal myAccount = null; 
		timing waitingForYou = null; 
		int hour = -1; 
		int minute = -1; 
		int Debug = 2; 
		while(true)
		{
			if(Debug == 1) System.out.println("Comenca el while");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// 
				e1.printStackTrace();
			}
			//1. Llegir Hist
			if(Debug == 1) System.out.println("A punt de llegir history");
			downloadHistory alexaHistory = new downloadHistory();
			if(Debug == 1) System.out.println("history downloaded");
			String hist = null;
			try {
				hist = alexaHistory.getHistory();
				
				if(Debug == 1) 
				{
					System.out.println("history no es null yuhu");
					
				}
			} catch (InterruptedException e) {
				// 
				e.printStackTrace();
			}
			//2. Llegir comandes
			readThroughHistory reader = new readThroughHistory(hist); 
			char[] commandToCheck = reader.findNextCommand(0); 
			if(commandToCheck == null) continue; 
			
			//iniciar interpreter
			commandInterpreter interpreter = new commandInterpreter();
			
			//3.En cas que no tingui PayPal configurat, o es paypal o sudo
			if(myAccount == null)
			{
				if(!interpreter.checkIfSetPaypalAccount(commandToCheck)) continue; 
				JFrame frame1 = new JFrame("PayPal");
				frame1.setVisible(true);
				Hashtable<String, String> loginInfo = login(frame1);
				
				String email = loginInfo.get("user");
				String password = loginInfo.get("pass");
				
				myAccount = new  PayPal(email,password); 
				continue;
			}
			
			//4.Interpretem
			if(interpreter.checkIfSetPaypalAccount(commandToCheck)) continue; 
			if(interpreter.checkIfCameBack(commandToCheck))
			{
				waitingForYou = null; 
				continue; 
			}
			if(interpreter.checkIfGetDeadline(commandToCheck))
			{
				//timing(int deadlineHour, int deadlineMinute, int deadlineDay, int intervalMin, int intervalHour)
				
				int[] newTime = timeDetector.timeDetection(String.valueOf(commandToCheck));
				//aqui entrara tant si esta a -1, i -1 com si ha canviat d'alarma
				if(hour != newTime[0] || minute != newTime[1])
				{
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date = new Date();
					System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
					int currentHour = date.getHours(); 
					int currentMinute = date.getMinutes(); 
					int currentDay = date.getDate();
					
					if(hour < currentHour) ++currentDay; 
					if(hour == currentHour && minute < currentMinute) ++currentDay; 
					
					hour = newTime[0]; 
					minute = newTime[1]; 
					waitingForYou = new timing(hour,minute, currentDay, 30, 0); //TODO estaria be fer intervals costumizables pero otro dia sera 
				}
			}


			//5. Si hi ha paypal i alarma activada interactua
			if(waitingForYou != null && myAccount != null)
			{
				waitingForYou.readHour(); 
				if(waitingForYou.deadlineReached())
				{
					myAccount.giveMyMoney();	
				}
			}
		}

	}
	
	public static Hashtable<String, String> login(JFrame frame) {

	    Hashtable<String, String> logininformation = new Hashtable<String, String>();


	    JPanel panel = new JPanel(new BorderLayout(5, 5));


	    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));

	    label.add(new JLabel("E-Mail", SwingConstants.RIGHT));

	    label.add(new JLabel("Password", SwingConstants.RIGHT));

	    panel.add(label, BorderLayout.WEST);


	    JPanel controls = new JPanel(new GridLayout(0, 1, 4, 4));

	    JTextField username = new JTextField(10);

	    controls.add(username);

	    JPasswordField password = new JPasswordField(10);

	    controls.add(password);

	    panel.add(controls, BorderLayout.CENTER);


	    JOptionPane.showMessageDialog(frame, panel, "PayPal - Login", JOptionPane.QUESTION_MESSAGE);

	    
	    

	    logininformation.put("user", username.getText());

	    logininformation.put("pass", new String(password.getPassword()));
	    
	    

	    return logininformation;

	}

}
