package com.maveric.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.maveric.magentopages.*;

public class MagentoTest {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.ie.driver", "./drivers/IEDriverserver.exe");
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 40);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://magento.com/");
	}

	@Test
	public void CredentialTest() throws IOException {
		
		try
		{
			HomePage home = new HomePage(driver);

			home.clickOnMyAccountIcon();

			LoginPage login = new LoginPage(driver);
			login.sendUserName("balajidinakaran1@gmail.com");
			login.sendPassword("Welcome123");
			login.clickOnLogin();

			MainPage main = new MainPage(driver, wait);
			Assert.assertEquals(main.getCurrentTitle(), "My Account");
			File srcFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String date = new Date().toString().replace(":", "-");
			FileUtils.copyFile(srcFile, new File("./screenshots/Success"+date+".png"));
			
			main.clickOnLogOut();
			Reporter.log("Success");
		}
		catch(Exception ex)
		{
			Reporter.log(ex.getMessage());
			File srcFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String date = new Date().toString().replace(":", "-");
			FileUtils.copyFile(srcFile, new File("./screenshots/Error"+date+".png"));
			Assert.fail();
		}
		
		

	}

	@AfterClass
	public void closeBrowser() {

		driver.quit();
	}

}
