package org.testJenkins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSpringmvc {
	WebDriver driver;

	@BeforeTest
	public void testBefore() {
		//firefox
		/*System.setProperty("webdriver.firefox.bin", "E:\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
		driver = new FirefoxDriver();*/
		
		//Chrome
		//System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		// 连接url
		driver.navigate().to("http://springmvc-wfproject5.openshift.axies.org/springmvc/");
	}

	@Test
	public void testContent() {
		// 测试新增页面返回button
		driver.findElement(By.linkText("Add User Info")).click();
		driver.findElement(By.linkText("Go Back")).click();

		// 测试新增数据
		driver.findElement(By.linkText("Add User Info")).click();
		driver.findElement(By.id("username")).sendKeys("testAdd");
		driver.findElement(By.id("password")).sendKeys("testAdd1");
		driver.findElement(By.id("nickname")).sendKeys("testAdd2");
		driver.findElement(By.id("email")).sendKeys("testAdd3");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// 放置一个隐式等待，等待10秒后再抛出
		WebElement input = driver.findElement(By.xpath("//input[@value='Submit']"));
		input.submit();

		// 测试修改数据
		driver.findElements(By.linkText("Change")).get(0).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("testChange");
		driver.findElement(By.id("nickname")).clear();
		driver.findElement(By.id("nickname")).sendKeys("testChange2");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("testChange3");
		WebElement input2 = driver.findElement(By.xpath("//input[@value='Submit']"));
		input2.submit();

		// 测试删除数据
		driver.findElements(By.linkText("Delete")).get(0).click();

	}

	@AfterTest
	public void testAfter() {
		System.out.println("testFinsh");
		driver.close();
	}
}
