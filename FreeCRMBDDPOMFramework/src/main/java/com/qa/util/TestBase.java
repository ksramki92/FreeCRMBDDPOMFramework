package com.qa.util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class TestBase 
{

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try
		{
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:\\Users\\Ramki\\workspace\\FreeCRMBDDPOMFramework\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	public static void initialization()
	{
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gechko.driver", "D:\\Softwares\\Selenium\\geckodriver-v0.25.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("opera"))
		{
			System.setProperty("webdriver.opera.driver", "D:\\Softwares\\Selenium\\operadriver_win64\\operadriver.exe");
			driver=new OperaDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);	
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);		
	}
}
