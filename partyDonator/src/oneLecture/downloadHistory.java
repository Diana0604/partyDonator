package oneLecture;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class downloadHistory {

	public static WebDriver driver; 
	public static String alexaHistoryUrl = "http://alexa.amazon.co.uk/spa/index.html#settings/dialogs"; 
	//TODO substitute this by your email and password to access alexa.amazon
	public static String email = "*****************@gmail.com";
	public static String password = "*****************"; 
	
	public downloadHistory()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Cabrera\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-chrome-driver\\2.25.0\\chromedriver.exe");
	}
	
	public String getHistory() throws InterruptedException
	{
		driver = new ChromeDriver(); 
		driver.get(alexaHistoryUrl); 
		Thread.sleep(10000);
		
		WebElement emailTextBox = driver.findElement(By.id("ap_email"));
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		WebElement passwordTextBox = driver.findElement(By.id("ap_password"));
		passwordTextBox.clear(); 
		passwordTextBox.sendKeys(password);
		passwordTextBox.submit(); 
		Thread.sleep(5000);
		
		driver.get(alexaHistoryUrl);
		
		Thread.sleep(5000);
		
		String source = driver.getPageSource();
		
		
		driver.close();
		
		return source; 
	}
}
