package org.testJenkins;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.URL;

public class TestGrid {
	public WebDriver driver;
	//public String URL, Node;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;

	@Parameters("browser")
	@BeforeTest
	public void launchapp(String browser) throws MalformedURLException {
		//String URL = "http://springmvc-wfproject5.openshift.axies.org/springmvc/";
		//String URL = "https://www.baidu.com.cn";
		//String URL = "http://la-springmvc.lingandev.svc:8080/springmvc/index.jsp";
		String URL = "http://10.131.0.124:8080/springmvc/index.jsp";
		try {
		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(" Executing on FireFox");
			//String Node = "http://selenium-hub.lingandev.svc:4444/wd/hub";
			String Node = "http://10.131.0.152:4444/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			System.out.println(" cap = DesiredCapabilities.firefox()");
			cap.setBrowserName("firefox");
            System.out.println(" hub =" + Node);
            System.out.println(" URL =" + URL);
            
			driver = new RemoteWebDriver(new URL(Node), cap);
			System.out.println(" timeouts = 100 sec");
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			// Launch website
			driver.navigate().to(URL);
			System.out.println(" driver.navigate().to(URL) end");
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("chrome")) {

		    System.out.println(" Executing on CHROME");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			System.out.println(" cap = DesiredCapabilities.chrome()");
			cap.setBrowserName("chrome");
			//cap.setCapability("chrome.switches", Arrays.asList("--start-maximized")); 
			//String Node = "http://selenium-hub.lingandev.svc:4444/wd/hub";
			String Node = "http://10.131.0.152:4444/wd/hub";
			System.out.println(" hub =" + Node);
            System.out.println(" URL =" + URL);
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
            System.out.println(" timeouts = 300 sec");
			// Launch website
			driver.navigate().to(URL);
			System.out.println(" driver.navigate().to(URL) end");
     		//driver.manage().window().maximize();


		}
		/*
		 * else if (browser.equalsIgnoreCase("ie")) { System.out.println(
		 * " Executing on IE"); DesiredCapabilities cap =
		 * DesiredCapabilities.chrome(); cap.setBrowserName("ie"); String Node =
		 * "http://10.112.66.52:5558/wd/hub"; driver = new RemoteWebDriver(new
		 * URL(Node), cap); driver.manage().timeouts().implicitlyWait(10,
		 * TimeUnit.SECONDS);
		 * 
		 * //Launch website driver.navigate().to(URL);
		 * driver.manage().window().maximize(); }
		 */
		else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
		} catch(Exception ex) {
		        System.out.println("ex1");
		        System.out.println(ex);
		    }
	}

	@Test
	public void calculatepercent() {
	    try {
		// 测试新增页面返回button
				driver.findElement(By.linkText("Add User Info")).click();
				driver.findElement(By.linkText("Go Back")).click();

				// 测试新增数据
				driver.findElement(By.linkText("Add User Info")).click();
				driver.findElement(By.id("username")).sendKeys("markAdd");
				driver.findElement(By.id("password")).sendKeys("markAdd1");
				driver.findElement(By.id("nickname")).sendKeys("markAdd2");
				driver.findElement(By.id("email")).sendKeys("markAdd3");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// 放置一个隐式等待，等待10秒后再抛出
				WebElement input = driver.findElement(By.xpath("//input[@value='Submit']"));
				input.submit();

				// 测试修改数据
				driver.findElements(By.linkText("Change")).get(0).click();
				driver.findElement(By.id("password")).clear();
				driver.findElement(By.id("password")).sendKeys("markChange");
				driver.findElement(By.id("nickname")).clear();
				driver.findElement(By.id("nickname")).sendKeys("markChange2");
				driver.findElement(By.id("email")).clear();
				driver.findElement(By.id("email")).sendKeys("markChange3");
				WebElement input2 = driver.findElement(By.xpath("//input[@value='Submit']"));
				input2.submit();

				// 测试删除数据
				driver.findElements(By.linkText("Delete")).get(0).click();
				
				
						    
		    //System.out.println(" click() begin");
			//driver.findElement(By.linkText("hao123")).click();
		//	driver.findElements(By.linkText("Delete")).get(0).click();
			//System.out.println(" click() end");
     		//driver.manage().window().maximize();
		    } catch(Exception ex) {
		        System.out.println("ex2");
		        System.out.println(ex);
		    }
				
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}