package com.flipkart_testng;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGClass {

	WebDriver driver;

	@BeforeMethod

	public void setUp()

	{

		System.setProperty("webdriver.chrome.driver",
				"D:\\Monika\\SimpleFlipkartAppAutomation\\flipkart_testng\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@Test

	public void AddingTOCart() throws Exception

	{

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("username");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"))
				.sendKeys("iphone 13");
		driver.findElement(By.xpath("//button[@type='submit']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//div[normalize-space()='APPLE iPhone 13 (Green, 256 GB)']")).click();
		driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();

		Thread.sleep(2000);

		String actualText = driver.findElement(By.xpath("//a[@class='_2Kn22P gBNbID']")).getText();
		String expectedText = "APPLE iPhone 13 (Green, 256 GB)";

		Assert.assertEquals(actualText, expectedText);

	}

	@AfterMethod

	public void tearDown() throws Exception

	{

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[normalize-space()='Remove']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='_3dsJAO _24d-qY FhkMJZ']")).click();
		Thread.sleep(1000);
		driver.quit();

	}

}
