package com.maveric.magentopages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id="email")
	WebElement emailEle;
	
	@FindBy(name="login[password]")
	WebElement passEle;
	
	@FindBy(xpath="//button[@id='send2']")
	WebElement loginEle;
	
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void sendUserName(String userName)
	{
		emailEle.sendKeys(userName);
	}
	
	public void sendPassword(String password)
	{
		passEle.sendKeys(password);
	}

	public void clickOnLogin()
	{
		loginEle.click();
	}
}
