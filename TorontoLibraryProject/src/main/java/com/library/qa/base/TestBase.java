package com.library.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.library.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	// we need to create class constructor to load properties 
	public TestBase() throws IOException {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\HomePractice\\TorontoLibraryProject\\src\\main\\java\\com\\library\\qa\\config\\config.properties");
		prop.load(ip);
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
		
		public static void initialization() {
			String browserName = prop.getProperty("browser");
			if(browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:/SeleniumJars/geckodriver.exe");
				 driver = new FirefoxDriver();
			}else if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome", "C:/SeleniumJars/chrome.exe");
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIME, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
