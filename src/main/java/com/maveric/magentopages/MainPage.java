package com.maveric.magentopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	static By logout=By.xpath("//a[text()='Log Out']");
	
	@FindBy(partialLinkText="Out")
	WebElement logoutEle;
	WebDriver driver;
	WebDriverWait wait;
	
	public MainPage(WebDriver driver,WebDriverWait wait)
	{
		this.wait=wait;
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String getCurrentTitle()
	{
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(logout));
		return driver.getTitle();
	}
	
	public void clickOnLogOut()
	{
		logoutEle.click();
	}

}
