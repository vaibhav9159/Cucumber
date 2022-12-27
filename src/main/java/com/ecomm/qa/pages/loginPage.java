package com.ecomm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {

	private WebDriver driver;
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver; 
	}
	 

	private By loginPageLogo = By.cssSelector("#header_logo");
	
	private By createAccountSection = By.xpath("//*[@id='create-account_form']/h3");
	
	private By createAccountButton = By.id("SubmitCreate"); 
	
	private By signInSection= By.id("login_form");
	
	private By signInButton = By.cssSelector("#SubmitLogin");
	
	private By Email = By.cssSelector("#email");
	
	private By Password = By.cssSelector("#passwd");

	private By forgotPasswordLink = By.cssSelector("a[href*='controller=password']");
	
	public boolean verifyLogo()
	{
		return driver.findElement(createAccountSection).isEnabled();
	}
	
	public String pageTitle()
	{
		return driver.getTitle();
	}
	
	public String verifyCreateAccountSection()
	{
		return driver.findElement(createAccountSection).getText();
	}
	
	public boolean verifyCreateAccountButton()
	{
		return driver.findElement(createAccountButton).isEnabled();
	}
	
	public boolean verifySignInSection()
	{
		return driver.findElement(signInSection).isDisplayed();
	}
	
	public boolean verifySignInButton()
	{
		return driver.findElement(signInButton).isDisplayed();
	}
	
	public void enterEmail(String email)
	{
		 driver.findElement(Email).sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		 driver.findElement(Password).sendKeys(password);
	}
	
	public void clickSIgnInButton()
	{
		driver.findElement(signInButton).click();
	}
	
	public boolean verifyForgotPasswordLink()
	{
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}
	
	public String homePageTitle()
	{
		return driver.getTitle();
	}
	
	public AccountsPage performLogin(String email, String password)
	{
		 driver.findElement(Email).sendKeys(email);
		 driver.findElement(Password).sendKeys(password);
		 driver.findElement(signInButton).click();
		 return new AccountsPage(driver);
	}
	
	
}
