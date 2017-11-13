package org.testJenkins;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestJenkins {
	public DesiredCapabilities abilities;
	public WebDriver driver;
	public FirefoxProfile profile;
	
	@BeforeTest
	public void beforeng() {
		
		// 火狐浏览器
		System.setProperty("webdriver.firefox.bin", "E:\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
		
		/*this.abilities = DesiredCapabilities.firefox();
		this.abilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);*/
		
		//String firefoxProfileDir = "C:\\Users\\douhao\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\u1cbi30x.default";
		//profile = new FirefoxProfile(new File("C:\\Users\\douhao\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\"));
		
		/*FirefoxProfile fp = new FirefoxProfile();
		ProfilesIni allProfiles = new ProfilesIni();
		fp = allProfiles.getProfile("default");*/
		FirefoxOptions options = new FirefoxOptions();
	    options.setProfile(getProfile("default"));
		driver = new FirefoxDriver(options);
		
		//driver = new FirefoxDriver(profile);
		
		// 谷歌Driver
		/*System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		  System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		 driver = new ChromeDriver();*/
		 
		driver.navigate().to("http://localhost:8081/TestSelenium/");
	}
	private static FirefoxProfile getProfile(String profileName) {
	    if (profileName == null || profileName.trim().isEmpty()) {
	        return new FirefoxProfile();
	    }
	    return new ProfilesIni().getProfile(profileName);
	}
	@Test
	public void testJ() {

		/*
		 * driver.navigate().to("https://www.baidu.com");
		 * System.out.println("baidu");
		 */

		driver.findElement(By.id("first")).sendKeys("345");
		driver.findElement(By.id("last")).sendKeys("1678");
		driver.findElement(By.id("button")).click();
		WebElement element = driver.findElement(By.id("all"));
		String result = element.getAttribute("value");
		System.out.println(" The Result is " + result);

	}

	@AfterTest
	public void afterng() {
		driver.close();
	}
}
