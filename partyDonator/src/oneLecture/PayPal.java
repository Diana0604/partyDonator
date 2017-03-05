package oneLecture;


import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	

public class PayPal { // Ens connectem a la web de la ONG per a donar diners mitjançant PayPal.
	public static final String paypalUrl = "http://www.clowns.org/"; 
	public static String email = new String();
	public static String password = new String();
	public static WebDriver driver; 
	
	public PayPal(String email, String password)
	{
		//TODO you should download the webdriver for chrome and set the path here
		System.setProperty("webdriver.chrome.driver", "C:\\Path\\chromedriver.exe");
		
		this.email = email;
		this.password = password; 
	}
	
	public static void giveMyMoney()
	{
		try {
			driver = new ChromeDriver(); 
			driver.get(paypalUrl); 
			Thread.sleep(2000);
			WebElement donateButton = driver.findElement(By.name("submit")); 
			donateButton.click(); 
			Thread.sleep(20000);
			
			WebElement donatingTextBox = driver.findElement(By.id("amount")); 
			donatingTextBox.sendKeys("0,5"); 
			Thread.sleep(20000);
			
			WebElement paypalLoginButton = driver.findElement(By.name("unified_login.x")); 
			paypalLoginButton.click(); 
			Thread.sleep(20000);
			WebElement emailTextBox = driver.findElement(By.id("email"));
			emailTextBox.clear();
			emailTextBox.sendKeys(email);
			
			WebElement passwordTextBox = driver.findElement(By.id("password"));
			passwordTextBox.clear(); 
			passwordTextBox.sendKeys(password);
			passwordTextBox.submit(); 
			Thread.sleep(10000);
			
			WebElement finalDonation = driver.findElement(By.name("continue.x")); 
			finalDonation.click(); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
         
         driver.close();
	}
	
	
}
