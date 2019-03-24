package com.qa.tests;


import java.beans.Visibility;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Log4jDemo {

	WebDriver driver;
	String baseUrl;
	Logger log = Logger.getLogger(Log4jDemo.class);

	@BeforeMethod
	public void setUp() throws Exception {
		log.info("***************** Starting Test Case Execution ***************");
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://freecrm.com/";
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		driver.get(baseUrl);
		log.info("entering Application URL");
	}
	@Test(priority = 1)
	public void validateTitle() {
		log.info("***************** Statring Test Case***************");
		log.info("***************** validateTitle Started ***************");
		
		log.info("entering Application URL");
		String str = driver.getTitle();
		log.info("Title of Page is -->"+driver.getTitle());
	//	Assert.assertEquals(str, "###Free CRM software in the cloud for sales and service");
		
		SoftAssert saaset = new SoftAssert();
		saaset.assertEquals(str, "###Free CRM software in the cloud for sales and service");
		log.info("***************** Ending Test Case***************");
		log.info("***************** validateTitle Finished***************");
	}
	
	@Test(priority = 2)
	public void LoginClick() {
		log.info("***************** Statring Test Case***************");
		log.info("***************** LoginClick Started ***************");

		WebElement eleLogin = driver.findElement(By.xpath("//span[contains(text(),'Log In')]"));
		WebDriverWait wait  = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(eleLogin));
		if (eleLogin.isDisplayed()) {
			eleLogin.click();
			
			log.debug("This is dubug message");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Assert.assertEquals(driver.getTitle(), "Cogmento CRM");
			Assert.assertEquals(driver.getTitle(), "CRM");
			log.info("Title of Page is -->"+driver.getTitle());
			
			log.info("***************** Ending Test Case***************");
			log.info("***************** LoginClick Finished***************");
		}
	}
	
	@AfterMethod
	public void quit()
	{
		driver.quit();
		log.info("***************** Driver closed sucessfully***************");
	}
}
